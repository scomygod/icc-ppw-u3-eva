package ec.ecu.ups.icc.employees.employee.dto;

import java.util.List;

public class EmployeesResponseDto {
    private String companyName;
    private Double minSalary;
    private Integer count;
    private List<EmployeeHighSalaryDto> employees;

    public EmployeesResponseDto() {
    }

    public EmployeesResponseDto(String companyName, Double minSalary, Integer count, List<EmployeeHighSalaryDto> employees) {
        this.companyName = companyName;
        this.minSalary = minSalary;
        this.count = count;
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<EmployeeHighSalaryDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeHighSalaryDto> employees) {
        this.employees = employees;
    }
}