package be.pxl.services.controller;

import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.controller.DTO.output.EmployeeResponseDTO;
import be.pxl.services.domain.Employee;
import be.pxl.services.services.IEmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final IEmployeeService _employeeService;
    public EmployeeController(IEmployeeService employeeService){
        this._employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody EmployeeRecord employeeRecord){
        _employeeService.addEmployee(employeeRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> findAll(){
        return new ResponseEntity<>(_employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDTO> findById(@PathVariable long id){
        return new ResponseEntity<>(_employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<EmployeeResponseDTO>> findByDepartment(@PathVariable long departmentId){
        return new ResponseEntity<>(_employeeService.findByDepartmentId(departmentId), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<EmployeeResponseDTO>> findByOrganization(@PathVariable long organizationId){
        return new ResponseEntity<>(_employeeService.findByOrganizationId(organizationId), HttpStatus.OK);
    }
}
