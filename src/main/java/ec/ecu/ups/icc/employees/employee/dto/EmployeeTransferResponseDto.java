package ec.ecu.ups.icc.employees.employee.dto;

public class EmployeeTransferResponseDto {
    
    private Long employeeId;
    private String employeeName;
    private DepartmentTransferDto oldDepartment;
    private DepartmentTransferDto newDepartment;
    private String message;

    public EmployeeTransferResponseDto() {
    }

    public EmployeeTransferResponseDto(Long employeeId, String employeeName, DepartmentTransferDto oldDepartment, DepartmentTransferDto newDepartment, String message) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.oldDepartment = oldDepartment;
        this.newDepartment = newDepartment;
        this.message = message;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public DepartmentTransferDto getOldDepartment() {
        return oldDepartment;
    }

    public void setOldDepartment(DepartmentTransferDto oldDepartment) {
        this.oldDepartment = oldDepartment;
    }

    public DepartmentTransferDto getNewDepartment() {
        return newDepartment;
    }

    public void setNewDepartment(DepartmentTransferDto newDepartment) {
        this.newDepartment = newDepartment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DepartmentTransferDto {
        private Long id;
        private String name;

        public DepartmentTransferDto() {
        }

        public DepartmentTransferDto(Long id, String name) {
            this.id = id;
            this.name = name;
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
    }
}