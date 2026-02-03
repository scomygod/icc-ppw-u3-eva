package ec.ecu.ups.icc.employees.employee.service;

import ec.ecu.ups.icc.employees.company.entity.Company;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import ec.ecu.ups.icc.employees.company.repository.CompanyRepository;
import ec.ecu.ups.icc.employees.department.entity.Department;
import ec.ecu.ups.icc.employees.department.repository.DepartmentRepository;
import ec.ecu.ups.icc.employees.employee.dto.EmployeeHighSalaryDto;
import ec.ecu.ups.icc.employees.employee.dto.EmployeesResponseDto;
import ec.ecu.ups.icc.employees.employee.dto.EmployeeTransferResponseDto;
import ec.ecu.ups.icc.employees.employee.entity.Employee;
import ec.ecu.ups.icc.employees.employee.mapper.EmployeeMapper;
import ec.ecu.ups.icc.employees.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository, DepartmentRepository departmentRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeesResponseDto getHighSalaryEmployees(Long companyId, Double minSalary) {
        Optional<Company> company = companyRepository.findById(companyId);

        if (company.isEmpty() || company.get().getActive() != 'S') {
            return null;
        }

        List<Employee> employees = employeeRepository.findHighSalaryEmployeesByCompanyId(companyId, minSalary);

        List<EmployeeHighSalaryDto> employeeDtos = new ArrayList<>();
        for (Employee emp : employees) {
            employeeDtos.add(employeeMapper.toHighSalaryDto(emp));
        }

        return new EmployeesResponseDto(
                company.get().getName(),
                minSalary,
                employeeDtos.size(),
                employeeDtos
        );
    }

    public EmployeeTransferResponseDto transferEmployee(Long employeeId, Long newDepartmentId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        if (employee.isEmpty() || employee.get().getActive() != 'S') {
            return null;
        }

        Optional<Department> newDepartment = departmentRepository.findByIdAndActive(newDepartmentId);

        if (newDepartment.isEmpty()) {
            return null;
        }

        Long currentDepartmentId = employee.get().getDepartment().getId();

        if (currentDepartmentId.equals(newDepartmentId)) {
            return new EmployeeTransferResponseDto(
                    employeeId,
                    employee.get().getFirstName() + " " + employee.get().getLastName(),
                    new EmployeeTransferResponseDto.DepartmentTransferDto(
                            employee.get().getDepartment().getId(),
                            employee.get().getDepartment().getName()
                    ),
                    new EmployeeTransferResponseDto.DepartmentTransferDto(
                            newDepartment.get().getId(),
                            newDepartment.get().getName()
                    ),
                    "conflict"
            );
        }

        EmployeeTransferResponseDto.DepartmentTransferDto oldDeptDto = new EmployeeTransferResponseDto.DepartmentTransferDto(
                employee.get().getDepartment().getId(),
                employee.get().getDepartment().getName()
        );

        Employee updatedEmployee = employee.get();
        updatedEmployee.setDepartment(newDepartment.get());
        employeeRepository.save(updatedEmployee);

        EmployeeTransferResponseDto.DepartmentTransferDto newDeptDto = new EmployeeTransferResponseDto.DepartmentTransferDto(
                newDepartment.get().getId(),
                newDepartment.get().getName()
        );

        return new EmployeeTransferResponseDto(
                employeeId,
                updatedEmployee.getFirstName() + " " + updatedEmployee.getLastName(),
                oldDeptDto,
                newDeptDto,
                "Employee transferred successfully"
        );
    }

    public boolean employeeExists(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.isPresent() && employee.get().getActive() == 'S';
    }
}