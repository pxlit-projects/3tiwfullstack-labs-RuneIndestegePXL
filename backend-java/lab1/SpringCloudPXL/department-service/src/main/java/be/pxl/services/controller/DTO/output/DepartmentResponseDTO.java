package be.pxl.services.controller.DTO.output;

import be.pxl.services.domain.Employee;

import java.util.List;

public record DepartmentResponseDTO(
        long id,
        long organizationId,
        String position,
        List<Employee> employees
) {}
