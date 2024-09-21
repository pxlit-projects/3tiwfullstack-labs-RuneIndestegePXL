package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.DepartmentRecord;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;

import java.util.List;

public interface IDepartmentService {
    List<Department> findByOrganizationId(long organizationId);


    List<Department> getAllDepartments();

    Department getDepartmentById(long id);

    void addDepartment(DepartmentRecord departmentRecord);

    List<Department> findByOrganizationIdWithEmployees(long organizationId);
}
