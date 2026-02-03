package ec.ecu.ups.icc.employees.company.service;

import ec.ecu.ups.icc.employees.company.dto.CompanyDepartmentsDto;
import ec.ecu.ups.icc.employees.company.entity.Company;
import ec.ecu.ups.icc.employees.company.mapper.CompanyMapper;
import ec.ecu.ups.icc.employees.company.repository.CompanyRepository;
import java.util.Optional;
import ec.ecu.ups.icc.employees.department.entity.Department;
import java.util.List;
import ec.ecu.ups.icc.employees.department.repository.DepartmentRepository;
import org.springframework.stereotype.Service;


@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final DepartmentRepository departmentRepository;
    private final CompanyMapper companyMapper;

    public CompanyService(CompanyRepository companyRepository, DepartmentRepository departmentRepository, CompanyMapper companyMapper) {
        this.companyRepository = companyRepository;
        this.departmentRepository = departmentRepository;
        this.companyMapper = companyMapper;
    }

    public CompanyDepartmentsDto getCompanyDepartments(Long companyId) {
        Optional<Company> company = companyRepository.findById(companyId);

        if (company.isEmpty() || company.get().getActive() != 'S') {
            return null;
        }

        List<Department> activeDepartments = departmentRepository.findActiveDepartmentsByCompanyId(companyId);

        return companyMapper.toDepartmentsDto(company.get(), activeDepartments);
    }
}