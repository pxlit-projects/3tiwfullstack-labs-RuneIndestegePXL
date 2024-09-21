package be.pxl.services.services;

import be.pxl.services.domain.Organization;

import java.util.List;

public interface IOrganizationService {
    Organization getOrganizationById(long id);

    Organization findByIdWithEmployees(long id);

    Organization findByIdWithDepartments(long id);

    Organization findByIdWithDepartmentsAndEmployees(long id);
}
