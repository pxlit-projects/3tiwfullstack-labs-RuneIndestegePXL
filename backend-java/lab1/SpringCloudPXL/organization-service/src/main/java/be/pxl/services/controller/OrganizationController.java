package be.pxl.services.controller;

import be.pxl.services.controller.DTO.input.EmployeeRecord;
import be.pxl.services.controller.DTO.input.OrganizationRecord;
import be.pxl.services.controller.DTO.output.OrganizationResponseDTO;
import be.pxl.services.controller.DTO.output.OrganizationWithDepartmentsResponseDTO;
import be.pxl.services.controller.DTO.output.OrganizationWithEmployeesAndDepartmentsResponseDTO;
import be.pxl.services.controller.DTO.output.OrganizationWithEmployeesResponseDTO;
import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.Organization;
import be.pxl.services.services.IOrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    private final IOrganizationService _organizationService;
    public OrganizationController(IOrganizationService organizationService){
        this._organizationService = organizationService;
    }
    @PostMapping("/")
    public ResponseEntity<Organization> addOrganization(@RequestBody OrganizationRecord organizationRecord){
        _organizationService.addOrganization(organizationRecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrganizationResponseDTO> findById(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.getOrganizationById(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/with-departments")
    public ResponseEntity<OrganizationWithDepartmentsResponseDTO> findByIdWithDepartments(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.findByIdWithDepartments(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity<OrganizationWithEmployeesAndDepartmentsResponseDTO> findByIdWithDepartmentsAndEmployees(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.findByIdWithDepartmentsAndEmployees(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity<OrganizationWithEmployeesResponseDTO> findByIdWithEmployees(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.findByIdWithEmployees(id), HttpStatus.OK);
    }


}
