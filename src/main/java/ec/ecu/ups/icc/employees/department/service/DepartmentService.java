package ec.ecu.ups.icc.employees.department.service;

import ec.ecu.ups.icc.employees.department.dto.DepartmentWithEmployeesDto;
import ec.ecu.ups.icc.employees.department.entity.Department;
import ec.ecu.ups.icc.employees.department.mapper.DepartmentMapper;
import ec.ecu.ups.icc.employees.department.repository.DepartmentRepository;
import ec.ecu.ups.icc.employees.employee.entity.Employee;
import ec.ecu.ups.icc.employees.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentMapper departmentMapper;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, DepartmentMapper departmentMapper) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.departmentMapper = departmentMapper;
    }

    public DepartmentWithEmployeesDto getDepartmentWithEmployees(Long departmentId, String sort) {
        Optional<Department> department = departmentRepository.findByIdAndActive(departmentId);

        if (department.isEmpty()) {
            return null;
        }

        List<Employee> employees;

        if ("asc".equalsIgnoreCase(sort)) {
            employees = employeeRepository.findActiveEmployeesByDepartmentIdOrderBySalaryAsc(departmentId);
        } else {
            employees = employeeRepository.findActiveEmployeesByDepartmentIdOrderBySalaryDesc(departmentId);
        }
        return departmentMapper.toDto(department.get(), employees);
    }
}