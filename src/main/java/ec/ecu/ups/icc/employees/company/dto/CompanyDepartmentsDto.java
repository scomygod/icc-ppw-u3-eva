package ec.ecu.ups.icc.employees.company.dto;

import java.math.BigDecimal;
import java.util.List;

public class CompanyDepartmentsDto {
    private Long companyId;
    private String companyName;
    private String country;
    private Integer departmentCount;
    private List<DepartmentSummaryDto> departments;
    private BigDecimal totalBudget;

    public CompanyDepartmentsDto() {
    }

    public CompanyDepartmentsDto(Long companyId, String companyName, String country, Integer departmentCount, List<DepartmentSummaryDto> departments, BigDecimal totalBudget) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.country = country;
        this.departmentCount = departmentCount;
        this.departments = departments;
        this.totalBudget = totalBudget;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(Integer departmentCount) {
        this.departmentCount = departmentCount;
    }

    public List<DepartmentSummaryDto> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentSummaryDto> departments) {
        this.departments = departments;
    }

    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }
}