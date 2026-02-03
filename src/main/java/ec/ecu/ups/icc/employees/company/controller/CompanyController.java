package ec.ecu.ups.icc.employees.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ec.ecu.ups.icc.employees.company.dto.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.company.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<?> getCompanyDepartments(@PathVariable Long id) {
        CompanyDepartmentsDto result = companyService.getCompanyDepartments(id);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponseDto("Company not found or inactive"));
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