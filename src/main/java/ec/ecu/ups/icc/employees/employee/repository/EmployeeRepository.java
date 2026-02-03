package ec.ecu.ups.icc.employees.employee.repository;

import ec.ecu.ups.icc.employees.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId AND e.active = 'S' ORDER BY e.salary DESC")
    List<Employee> findActiveEmployeesByDepartmentIdOrderBySalaryDesc(@Param("departmentId") Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :departmentId AND e.active = 'S' ORDER BY e.salary ASC")
    List<Employee> findActiveEmployeesByDepartmentIdOrderBySalaryAsc(@Param("departmentId") Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.department.company.id = :companyId AND e.salary >= :minSalary AND e.active = 'S' AND e.department.active = 'S' ORDER BY e.salary DESC")
    List<Employee> findHighSalaryEmployeesByCompanyId(@Param("companyId") Long companyId, @Param("minSalary") Double minSalary);
}