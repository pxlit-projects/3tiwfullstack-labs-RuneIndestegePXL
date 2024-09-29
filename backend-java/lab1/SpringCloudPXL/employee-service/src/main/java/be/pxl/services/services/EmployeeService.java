package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.controller.DTO.output.EmployeeResponseDTO;
import be.pxl.services.domain.Employee;
import be.pxl.services.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository _employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository){
        this._employeeRepository =employeeRepository;
    }
    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return convertEmployeeListToEmployeeResponseDTOList(_employeeRepository.findAll());
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(long id) {
        Employee employee = _employeeRepository.findById(id).orElseThrow();
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getOrganizationId(),
                employee.getDepartmentId(),
                employee.getName(),
                employee.getAge(),
                employee.getPosition());
    }

    @Override
    public List<EmployeeResponseDTO> findByDepartmentId(long departmentId) {
        return convertEmployeeListToEmployeeResponseDTOList(_employeeRepository.findByDepartmentId(departmentId));
    }

    @Override
    public List<EmployeeResponseDTO> findByOrganizationId(long organizationId) {
        return convertEmployeeListToEmployeeResponseDTOList(_employeeRepository.findByOrganizationId(organizationId));
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
}
