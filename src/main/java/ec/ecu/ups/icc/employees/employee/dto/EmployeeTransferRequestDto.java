package ec.ecu.ups.icc.employees.employee.dto;

public class EmployeeTransferRequestDto {


    private Long newDepartmentId;

    public EmployeeTransferRequestDto() {
    }

    public EmployeeTransferRequestDto(Long newDepartmentId) {
        this.newDepartmentId = newDepartmentId;
    }

    public Long getNewDepartmentId() {
        return newDepartmentId;
    }

    public void setNewDepartmentId(Long newDepartmentId) {
        this.newDepartmentId = newDepartmentId;
    }
    
}