package be.pxl.services.controller;

import be.pxl.services.controller.DTO.input.DepartmentRecord;
import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.controller.DTO.output.DepartmentResponseDTO;
import be.pxl.services.controller.DTO.output.DepartmentResponseWithEmployeesDTO;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.services.IDepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private final IDepartmentService _departmentService;
    public DepartmentController(IDepartmentService departmentService){
        this._departmentService = departmentService;
    }

    @PostMapping("/")
    public ResponseEntity<Void> add(@RequestBody DepartmentRecord departmentRecord){
        _departmentService.addDepartment(departmentRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponseDTO> findById(@PathVariable long id){
        return new ResponseEntity<>(_departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<DepartmentResponseDTO>> findAll(){
        return new ResponseEntity<>(_departmentService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<DepartmentResponseDTO>> findByOrganization(@PathVariable long organizationId){
        return new ResponseEntity<>(_departmentService.findByOrganizationId(organizationId), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public ResponseEntity<List<DepartmentResponseWithEmployeesDTO>> findByOrganizationWithEmployees(@PathVariable long organizationId){
        return new ResponseEntity<>(_departmentService.findByOrganizationIdWithEmployees(organizationId), HttpStatus.OK);
    }

}
