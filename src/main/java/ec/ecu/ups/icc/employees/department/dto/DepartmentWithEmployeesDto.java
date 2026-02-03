package ec.ecu.ups.icc.employees.department.dto;

import ec.ecu.ups.icc.employees.company.dto.CompanyDto;
import java.math.BigDecimal;
import java.util.List;

public class DepartmentWithEmployeesDto {
    private Long id;
    private String name;
    private BigDecimal budget;
    private CompanyDto company;
    private List<EmployeeSummaryDto> employees;
    private Integer employeeCount;
    private Double totalSalaries;

    public DepartmentWithEmployeesDto() {
    }

    public DepartmentWithEmployeesDto(Long id, String name, BigDecimal budget, CompanyDto company, List<EmployeeSummaryDto> employees, Integer employeeCount, Double totalSalaries) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.company = company;
        this.employees = employees;
        this.employeeCount = employeeCount;
        this.totalSalaries = totalSalaries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public CompanyDto getCompany() {
        return company;
    }

    public void setCompany(CompanyDto company) {
        this.company = company;
    }

    public List<EmployeeSummaryDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeSummaryDto> employees) {
        this.employees = employees;
    }

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }

    public Double getTotalSalaries() {
        return totalSalaries;
    }

    public void setTotalSalaries(Double totalSalaries) {
        this.totalSalaries = totalSalaries;
    }
}