package be.pxl.services.services;

import be.pxl.services.client.NotificationClient;
import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.controller.DTO.output.EmployeeResponseDTO;
import be.pxl.services.domain.Employee;
import be.pxl.services.model.dto.EmployeeRequest;
import be.pxl.services.model.dto.NotificationRequest;
import be.pxl.services.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository _employeeRepository;
    private final NotificationClient _notificationClient;
    public EmployeeService(EmployeeRepository employeeRepository, NotificationClient notificationClient){
        this._employeeRepository =employeeRepository;
        _notificationClient = notificationClient;
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

        _notificationClient.sendNotification(new NotificationRequest(employeeRecord.name(), employeeRecord.position()));

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
    @Override
    public void createEmployee(EmployeeRequest employeeRequest){
        Employee employee = new Employee.Builder()
                .name(employeeRequest.getName())
                .age(employeeRequest.getAge())
                .position(employeeRequest.getPosition())
                .build();
        _employeeRepository.save(employee);
        _notificationClient.sendNotification(new NotificationRequest(employee.getName(), employee.getPosition()));
    }
}
