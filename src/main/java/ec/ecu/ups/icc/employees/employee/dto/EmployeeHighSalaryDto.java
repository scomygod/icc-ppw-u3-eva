package ec.ecu.ups.icc.employees.employee.dto;

public class EmployeeHighSalaryDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double salary;
    private DepartmentInfoDto department;

    public EmployeeHighSalaryDto() {
    }

    public EmployeeHighSalaryDto(Long id, String firstName, String lastName, String email, Double salary, DepartmentInfoDto department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public DepartmentInfoDto getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentInfoDto department) {
        this.department = department;
    }

    public static class DepartmentInfoDto {
        private Long id;
        private String name;

        public DepartmentInfoDto() {
        }

        public DepartmentInfoDto(Long id, String name) {
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