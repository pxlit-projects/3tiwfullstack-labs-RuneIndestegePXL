package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.OrganizationRecord;
import be.pxl.services.controller.DTO.output.*;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.Organization;
import be.pxl.services.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizationService implements  IOrganizationService{
    private final OrganizationRepository _organizationRepository;
    private final RestTemplate restTemplate;
    @Value("${employee.service.url}")
    private String employeeServiceUrl;
    @Value("${department.service.url}")
    private String departmentServiceUrl;

    public OrganizationService(OrganizationRepository organizationRepository, RestTemplate restTemplate){
        this._organizationRepository = organizationRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public OrganizationResponseDTO getOrganizationById(long id) {
        return mapToOrganizationResponseDTO(_organizationRepository.getOrganizationById(id));
    }

    @Override
    public OrganizationWithEmployeesResponseDTO findByIdWithEmployees(long id) {
        //return _organizationRepository.findByIdWithEmployees(id);
        Organization organization = _organizationRepository.findById(id).orElseThrow();
        List<Employee> employees = fetchEmployeesByOrganizationId(organization.getId());
        organization.setEmployees(employees); // manually populate employees
        return mapToOrganizationWithEmployeesResponseDTO(organization);
    }

    @Override
    public OrganizationWithDepartmentsResponseDTO findByIdWithDepartments(long id) {
        Organization organization = _organizationRepository.findById(id).orElseThrow();
        List<Department> departments = fetchDepartmentsByOrganizationId(id);
        organization.setDepartments(departments);
        return mapToOrganizationWithDepartmentsResponseDTO(organization);
        //return _organizationRepository.findByIdWithDepartments(id);
    }

    @Override
    public OrganizationWithEmployeesAndDepartmentsResponseDTO findByIdWithDepartmentsAndEmployees(long id) {
        Organization organization = _organizationRepository.findById(id).orElseThrow();
        List<Employee> employees = fetchEmployeesByOrganizationId(id);
        organization.setEmployees(employees);
        List<Department> departments = fetchDepartmentsByOrganizationId(id);
        organization.setDepartments(departments);
        return mapToOrganizationWithEmployeesAndDepartmentsResponseDTO(organization);
        //return _organizationRepository.findByIdWithDepartmentsAndEmployees(id);
    }
    private List<Employee> fetchEmployeesByOrganizationId(long organizationId) {
        String url = employeeServiceUrl + "/api/employee//organization/" + organizationId;
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {}
        );
        return response.getBody();
    }

    private List<Department> fetchDepartmentsByOrganizationId(long organizationId) {
        String url = departmentServiceUrl + "/api/department/organization/" + organizationId;
        ResponseEntity<List<Department>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Department>>() {}
        );
        return response.getBody();
    }
    @Override
    public void addOrganization(OrganizationRecord organizationRecord) {
        _organizationRepository.save(
                new Organization(
                        organizationRecord.id(),
                        organizationRecord.name(),
                        organizationRecord.address()
                )
        );
    }
    private List<EmployeeResponseDTO> convertEmployeeListToEmployeeResponseDTOList(List<Employee> employees){
        List<EmployeeResponseDTO> employeeResponseDTOS = new ArrayList<>();
        for (Employee employee : employees) {
            employeeResponseDTOS.add(new EmployeeResponseDTO(
                    employee.getId(),
                    employee.getOrganizationId(),
                    employee.getDepartmentId(),
                    employee.getName(),
                    employee.getAge(),
                    employee.getPosition())
            );
        }
        return employeeResponseDTOS;
    }
    private OrganizationResponseDTO mapToOrganizationResponseDTO(Organization organization) {
        // Map the fields from Organization to OrganizationWithEmployeesResponseDTO
        return new OrganizationResponseDTO(
                organization.getId(),
                organization.getName(),
                organization.getAddress()
        );
    }
    private OrganizationWithEmployeesResponseDTO mapToOrganizationWithEmployeesResponseDTO(Organization organization) {
        // Map the fields from Organization to OrganizationWithEmployeesResponseDTO
        return new OrganizationWithEmployeesResponseDTO(
                organization.getId(),
                organization.getName(),
                organization.getAddress(),
                organization.getEmployees()  // Already populated employees
        );
    }
    private OrganizationWithDepartmentsResponseDTO mapToOrganizationWithDepartmentsResponseDTO(Organization organization) {
        // Map the fields from Organization to OrganizationWithEmployeesResponseDTO
        return new OrganizationWithDepartmentsResponseDTO(
                organization.getId(),
                organization.getName(),
                organization.getAddress(),
                organization.getDepartments()
        );
    }
    private OrganizationWithEmployeesAndDepartmentsResponseDTO mapToOrganizationWithEmployeesAndDepartmentsResponseDTO(Organization organization) {
        // Map the fields from Organization to OrganizationWithEmployeesResponseDTO
        return new OrganizationWithEmployeesAndDepartmentsResponseDTO(
                organization.getId(),
                organization.getName(),
                organization.getAddress(),
                organization.getEmployees(),
                organization.getDepartments()// Already populated employees
        );
    }
}
