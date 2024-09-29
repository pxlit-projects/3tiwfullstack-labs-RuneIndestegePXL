package be.pxl.services.services;

import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService implements  IOrganizationService{
    private final OrganizationRepository _organizationRepository;
    public OrganizationService(OrganizationRepository organizationRepository){
        this._organizationRepository = organizationRepository;
    }

    @Override
    public Organization getOrganizationById(long id) {
        return _organizationRepository.getOrganizationById(id);
    }

    @Override
    public Organization findByIdWithEmployees(long id) {
        return null;
        //return _organizationRepository.findByIdWithEmployees(id);
    }

    @Override
    public Organization findByIdWithDepartments(long id) {
        return null;
        //return _organizationRepository.findByIdWithDepartments(id);
    }

    @Override
    public Organization findByIdWithDepartmentsAndEmployees(long id) {
        return null;
        //return _organizationRepository.findByIdWithDepartmentsAndEmployees(id);
    }
}
