package be.pxl.services.repository;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    List<Department> findByOrganizationId(long organizationId);
/*
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.employees WHERE d.id = :organizationId")
    List<Department> findByOrganizationIdWithEmployees(long organizationId);

 */
}
