package ec.ecu.ups.icc.employees.company.repository;

import ec.ecu.ups.icc.employees.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    
}