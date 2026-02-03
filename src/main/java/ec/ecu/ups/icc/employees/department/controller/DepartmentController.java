package ec.ecu.ups.icc.employees.department.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ec.ecu.ups.icc.employees.department.dto.DepartmentWithEmployeesDto;
import ec.ecu.ups.icc.employees.department.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<?> getDepartmentEmployees(@PathVariable Long id, @RequestParam(value = "sort", defaultValue = "desc") String sort) {
        DepartmentWithEmployeesDto result = departmentService.getDepartmentWithEmployees(id, sort);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto("Department not found or inactive"));
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