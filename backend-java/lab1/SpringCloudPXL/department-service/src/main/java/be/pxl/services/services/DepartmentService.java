package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.DepartmentRecord;
import be.pxl.services.controller.DTO.output.DepartmentResponseDTO;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository _departmentRepository;
    private final RestTemplate restTemplate;
    @Value("${employee.service.url}")
    private String employeeServiceUrl;
    public DepartmentService(DepartmentRepository departmentRepository, RestTemplate restTemplate){
        this._departmentRepository = departmentRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<DepartmentResponseDTO> findByOrganizationId(long organizationId) {
        return convertDepartmentListToDepartmentResponseDTOList(_departmentRepository.findByOrganizationId(organizationId));
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return convertDepartmentListToDepartmentResponseDTOList(_departmentRepository.findAll());
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(long id) {
        Department department = _departmentRepository.findById(id).orElseThrow();
        return new DepartmentResponseDTO(
                department.getId(),
                department.getOrganizationId(),
                department.getPosition(),
                department.getEmployees()
        );
    }

    @Override
    public void addDepartment(DepartmentRecord departmentRecord) {
        _departmentRepository.save(new Department(
                departmentRecord.id(),
                departmentRecord.organizationId(),
                departmentRecord.position()
        ));

    }

    @Override
    public List<DepartmentResponseDTO> findByOrganizationIdWithEmployees(long organizationId) {
        /*
        List<Department> departments = _departmentRepository.findByOrganizationId(organizationId);
        return convertDepartmentListToDepartmentResponseDTOList(departments);

         */

        List<Department> departments = _departmentRepository.findByOrganizationId(organizationId);
        for (Department department : departments) {
            List<Employee> employees = fetchEmployeesByDepartmentId(department.getId());
            department.setEmployees(employees); // manually populate employees
        }
        return convertDepartmentListToDepartmentResponseDTOList(departments);

    }
    private List<Employee> fetchEmployeesByDepartmentId(long departmentId) {
        String url = employeeServiceUrl + "/api/employee/department/" + departmentId;
        ResponseEntity<List<Employee>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {}
        );
        return response.getBody();
    }

    private List<DepartmentResponseDTO> convertDepartmentListToDepartmentResponseDTOList(List<Department>departments) {
        List<DepartmentResponseDTO> departmentResponseDTOS = new ArrayList<>();
        for (Department department : departments) {
            departmentResponseDTOS.add(new DepartmentResponseDTO(
                    department.getId(),
                    department.getOrganizationId(),
                    department.getPosition(),
                    department.getEmployees()));
        }
        return departmentResponseDTOS;
    }
}
