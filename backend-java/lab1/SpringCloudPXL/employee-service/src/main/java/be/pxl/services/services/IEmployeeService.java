package be.pxl.services.services;


import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.controller.DTO.output.EmployeeResponseDTO;
import be.pxl.services.domain.Employee;
import be.pxl.services.model.dto.EmployeeRequest;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(long id);


    List<EmployeeResponseDTO> findByDepartmentId(long departmentId);

    List<EmployeeResponseDTO> findByOrganizationId(long organizationId);

    void addEmployee(EmployeeRecord employeeRecord);

    void createEmployee(EmployeeRequest employeeRequest);
}
