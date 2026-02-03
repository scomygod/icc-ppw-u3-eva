package ec.ecu.ups.icc.employees.employee.controller;

import ec.ecu.ups.icc.employees.employee.dto.EmployeeTransferRequestDto;
import ec.ecu.ups.icc.employees.employee.dto.EmployeeTransferResponseDto;
import ec.ecu.ups.icc.employees.employee.dto.EmployeesResponseDto;
import ec.ecu.ups.icc.employees.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/companies/{id}/high-salary-employees")
    public ResponseEntity<?> getHighSalaryEmployees(@PathVariable Long id, @RequestParam(value = "minSalary", defaultValue = "5000.00") Double minSalary) {
        EmployeesResponseDto result = employeeService.getHighSalaryEmployees(id, minSalary);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto("Company not found or inactive"));
        }

        return ResponseEntity.ok(result);
    }

    @PatchMapping("/employees/{employeeId}/transfer")
    public ResponseEntity<?> transferEmployee(@PathVariable Long employeeId, @RequestBody EmployeeTransferRequestDto request) {
        EmployeeTransferResponseDto result = employeeService.transferEmployee(employeeId, request.getNewDepartmentId());

        if (result == null) {
            if (employeeService.employeeExists(employeeId)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponseDto("Target department not found or inactive"));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponseDto("Employee not found or inactive"));
            }
        }

        if ("conflict".equals(result.getMessage())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorResponseDto("Employee is already in the target department"));
        }

        return ResponseEntity.ok(result);
    }

    public static class ErrorResponseDto {
        private String message;

        public ErrorResponseDto(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}