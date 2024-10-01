package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.OrganizationRecord;
import be.pxl.services.controller.DTO.output.OrganizationWithEmployeesResponseDTO;
import be.pxl.services.domain.Organization;

import java.util.List;

public interface IOrganizationService {
    Organization getOrganizationById(long id);

    OrganizationWithEmployeesResponseDTO findByIdWithEmployees(long id);

    Organization findByIdWithDepartments(long id);

    Organization findByIdWithDepartmentsAndEmployees(long id);

    void addOrganization(OrganizationRecord organizationRecord);
}
