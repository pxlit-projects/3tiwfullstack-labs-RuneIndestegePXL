package be.pxl.services.controller.DTO.output;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;

import java.util.List;

public record OrganizationWithEmployeesResponseDTO(
        long id,
        String name,
        String address,
        List<Employee> employees) {
}
