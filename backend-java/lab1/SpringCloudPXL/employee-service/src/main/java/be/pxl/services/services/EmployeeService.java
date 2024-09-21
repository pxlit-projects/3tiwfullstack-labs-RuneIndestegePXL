package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository _employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this._employeeRepository =employeeRepository;
    }
    @Override
    public List<Employee> getAllEmployees() {
        return _employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return _employeeRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Employee> findByDepartmentId(long departmentId) {
        return _employeeRepository.findByDepartmentId(departmentId);
    }

    @Override
    public List<Employee> findByOrganizationId(long organizationId) {
        return _employeeRepository.findByOrganizationId(organizationId);
    }

    @Override
    public void addEmployee(EmployeeRecord employeeRecord) {
        _employeeRepository.save(new Employee(
                employeeRecord.id(),
                employeeRecord.organizationId(),
                employeeRecord.departmentId(),
                employeeRecord.name(),
                employeeRecord.age() ,
                employeeRecord.position()));
    }
}
