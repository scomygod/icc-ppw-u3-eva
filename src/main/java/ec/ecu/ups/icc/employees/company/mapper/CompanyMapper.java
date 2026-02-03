package ec.ecu.ups.icc.employees.company.mapper;

import ec.ecu.ups.icc.employees.company.dto.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.company.dto.CompanyDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import ec.ecu.ups.icc.employees.company.dto.DepartmentSummaryDto;
import ec.ecu.ups.icc.employees.company.entity.Company;
import ec.ecu.ups.icc.employees.department.entity.Department;
import ec.ecu.ups.icc.employees.employee.entity.Employee;
import org.springframework.stereotype.Component;


@Component
public class CompanyMapper {
    public CompanyDto toDto(Company company) {
        if (company == null) {
            return null;
        }
        return new CompanyDto(company.getId(), company.getName(), company.getCountry());
    }

    public CompanyDepartmentsDto toDepartmentsDto(Company company, List<Department> activeDepartments) {
        if (company == null) {
            return null;
        }

        List<DepartmentSummaryDto> departmentDtos = new ArrayList<>();
        BigDecimal totalBudget = BigDecimal.ZERO;

        for (Department dept : activeDepartments) {
            long activeEmployeeCount = dept.getEmployees() != null ? 
                    dept.getEmployees().stream()
                            .filter(e -> e.getActive() == 'S')
                            .count() : 0;

            departmentDtos.add(new DepartmentSummaryDto(
                    dept.getId(),
                    dept.getName(),
                    dept.getBudget(),
                    (int) activeEmployeeCount
            ));

            totalBudget = totalBudget.add(dept.getBudget());
        }

        return new CompanyDepartmentsDto(
                company.getId(),
                company.getName(),
                company.getCountry(),
                departmentDtos.size(),
                departmentDtos,
                totalBudget
        );
    }
}