package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.OrganizationRecord;
import be.pxl.services.controller.DTO.output.OrganizationResponseDTO;
import be.pxl.services.controller.DTO.output.OrganizationWithDepartmentsResponseDTO;
import be.pxl.services.controller.DTO.output.OrganizationWithEmployeesAndDepartmentsResponseDTO;
import be.pxl.services.controller.DTO.output.OrganizationWithEmployeesResponseDTO;
import be.pxl.services.domain.Organization;

import java.util.List;

public interface IOrganizationService {
    OrganizationResponseDTO getOrganizationById(long id);

    OrganizationWithEmployeesResponseDTO findByIdWithEmployees(long id);

    OrganizationWithDepartmentsResponseDTO findByIdWithDepartments(long id);

    OrganizationWithEmployeesAndDepartmentsResponseDTO findByIdWithDepartmentsAndEmployees(long id);

    void addOrganization(OrganizationRecord organizationRecord);
}
