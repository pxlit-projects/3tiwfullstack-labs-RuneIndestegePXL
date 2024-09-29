package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.DepartmentRecord;
import be.pxl.services.controller.DTO.output.DepartmentResponseDTO;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentResponseDTO> findByOrganizationId(long organizationId);


    List<DepartmentResponseDTO> getAllDepartments();

    DepartmentResponseDTO getDepartmentById(long id);

    void addDepartment(DepartmentRecord departmentRecord);

    List<DepartmentResponseDTO> findByOrganizationIdWithEmployees(long organizationId);
}
