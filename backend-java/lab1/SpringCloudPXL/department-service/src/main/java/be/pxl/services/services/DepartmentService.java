package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.DepartmentRecord;
import be.pxl.services.domain.Department;
import be.pxl.services.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository _departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository){
        this._departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findByOrganizationId(long organizationId) {
        return _departmentRepository.findByOrganizationId(organizationId);
    }

    @Override
    public List<Department> getAllDepartments() {
        return _departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(long id) {
        return _departmentRepository.findById(id).orElseThrow();
    }

    @Override
    public void addDepartment(DepartmentRecord departmentRecord) {
        _departmentRepository.save(new Department(
                departmentRecord.id(),
                departmentRecord.organizationId(),
                departmentRecord.position()
        ));
    }

    @Override
    public List<Department> findByOrganizationIdWithEmployees(long organizationId) {
        return _departmentRepository.findByOrganizationIdWithEmployees(organizationId);
    }
}
