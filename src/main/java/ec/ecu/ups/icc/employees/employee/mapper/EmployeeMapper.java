package ec.ecu.ups.icc.employees.employee.mapper;

import org.springframework.stereotype.Component;
import ec.ecu.ups.icc.employees.employee.dto.EmployeeHighSalaryDto;
import ec.ecu.ups.icc.employees.employee.entity.Employee;

@Component
public class EmployeeMapper {
    public EmployeeHighSalaryDto toHighSalaryDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeHighSalaryDto.DepartmentInfoDto deptInfo = null;
        if (employee.getDepartment() != null) {
            deptInfo = new EmployeeHighSalaryDto.DepartmentInfoDto(
                    employee.getDepartment().getId(),
                    employee.getDepartment().getName()
            );
        }
        
        return new EmployeeHighSalaryDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getSalary(),
                deptInfo
        );

    }


}