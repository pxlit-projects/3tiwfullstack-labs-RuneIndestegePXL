package be.pxl.services.controller;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;
import be.pxl.services.domain.Organization;
import be.pxl.services.services.IOrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    private final IOrganizationService _organizationService;
    public OrganizationController(IOrganizationService organizationService){
        this._organizationService = organizationService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Organization> findById(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.getOrganizationById(id), HttpStatus.OK);
    }
    @GetMapping("/{id}/with-departments")
    public ResponseEntity<Organization> findByIdWithDepartments(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.findByIdWithDepartments(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public ResponseEntity<Organization> findByIdWithDepartmentsAndEmployees(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.findByIdWithDepartmentsAndEmployees(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/with-employees")
    public ResponseEntity<Organization> findByIdWithEmployees(@PathVariable long id){
        return new ResponseEntity<>(_organizationService.findByIdWithEmployees(id), HttpStatus.OK);
    }


}
