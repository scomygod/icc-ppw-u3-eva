package ec.ecu.ups.icc.employees.company.dto;

import java.math.BigDecimal;

public class DepartmentSummaryDto {
    private Long id;
    private String name;
    private BigDecimal budget;
    private Integer employeeCount;

    public DepartmentSummaryDto() {
    }

    public DepartmentSummaryDto(Long id, String name, BigDecimal budget, Integer employeeCount) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.employeeCount = employeeCount;
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

    public Integer getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(Integer employeeCount) {
        this.employeeCount = employeeCount;
    }
}