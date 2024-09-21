package be.pxl.services.repository;

import be.pxl.services.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization getOrganizationById(long id);

    Organization findByIdWithEmployees(long id);

    Organization findByIdWithDepartments(long id);

    Organization findByIdWithDepartmentsAndEmployees(long id);
}
