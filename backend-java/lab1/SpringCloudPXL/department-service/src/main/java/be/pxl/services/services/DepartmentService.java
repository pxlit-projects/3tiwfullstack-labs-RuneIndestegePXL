package be.pxl.services.services;

import be.pxl.services.controller.DTO.input.DepartmentRecord;
import be.pxl.services.controller.DTO.output.DepartmentResponseDTO;
import be.pxl.services.domain.Department;
import be.pxl.services.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository _departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository){
        this._departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentResponseDTO> findByOrganizationId(long organizationId) {

        return convertDepartmentListToDepartmentResponseDTOList(_departmentRepository.findByOrganizationId(organizationId));
    }

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return convertDepartmentListToDepartmentResponseDTOList(_departmentRepository.findAll());
    }

    @Override
    public DepartmentResponseDTO getDepartmentById(long id) {
        Department department = _departmentRepository.findById(id).orElseThrow();
        return new DepartmentResponseDTO(
                department.getId(),
                department.getOrganizationId(),
                department.getPosition(),
                department.getEmployees()
        );
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
    public List<DepartmentResponseDTO> findByOrganizationIdWithEmployees(long organizationId) {
        //return _departmentRepository.findByOrganizationIdWithEmployees(organizationId);
        return null;
    }


    private List<DepartmentResponseDTO> convertDepartmentListToDepartmentResponseDTOList(List<Department>departments) {
        List<DepartmentResponseDTO> departmentResponseDTOS = new ArrayList<>();
        for (Department department : departments) {
            departmentResponseDTOS.add(new DepartmentResponseDTO(
                    department.getId(),
                    department.getOrganizationId(),
                    department.getPosition(),
                    department.getEmployees()));
        }
        return departmentResponseDTOS;
    }
}
