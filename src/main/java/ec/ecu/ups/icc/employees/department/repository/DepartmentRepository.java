package ec.ecu.ups.icc.employees.department.repository;

import ec.ecu.ups.icc.employees.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("SELECT d FROM Department d WHERE d.company.id = :companyId AND d.active = 'S'")
    List<Department> findActiveDepartmentsByCompanyId(@Param("companyId") Long companyId);

    @Query("SELECT d FROM Department d WHERE d.id = :id AND d.active = 'S'")
    Optional<Department> findByIdAndActive(@Param("id") Long id);
}