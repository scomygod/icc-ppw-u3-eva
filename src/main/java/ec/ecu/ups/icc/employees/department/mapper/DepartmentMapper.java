package ec.ecu.ups.icc.employees.department.mapper;

import ec.ecu.ups.icc.employees.company.dto.CompanyDto;
import ec.ecu.ups.icc.employees.department.dto.DepartmentWithEmployeesDto;
import ec.ecu.ups.icc.employees.department.dto.EmployeeSummaryDto;
import ec.ecu.ups.icc.employees.department.entity.Department;
import ec.ecu.ups.icc.employees.employee.entity.Employee;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentMapper {
    public DepartmentWithEmployeesDto toDto(Department department, List<Employee> activeEmployees) {
        if (department == null) {
            return null;
        }

        List<EmployeeSummaryDto> employeeDtos = new ArrayList<>();
        Double totalSalaries = 0.0;

        for (Employee emp : activeEmployees) {
            employeeDtos.add(new EmployeeSummaryDto(
                    emp.getId(),
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getEmail(),
                    emp.getSalary()
            ));
            totalSalaries += emp.getSalary();
        }

        CompanyDto companyDto = null;
        if (department.getCompany() != null) {
            companyDto = new CompanyDto(
                    department.getCompany().getId(),
                    department.getCompany().getName(),
                    department.getCompany().getCountry()
            );
        }

        return new DepartmentWithEmployeesDto(
                department.getId(),
                department.getName(),
                department.getBudget(),
                companyDto,
                employeeDtos,
                activeEmployees.size(),
                totalSalaries
        );
    }
}