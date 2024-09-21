package be.pxl.services.services;


import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.domain.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);


    List<Employee> findByDepartmentId(long departmentId);

    List<Employee> findByOrganizationId(long organizationId);

    void addEmployee(EmployeeRecord employeeRecord);
}
