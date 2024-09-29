package be.pxl.services.controller.DTO.output;

public record EmployeeResponseDTO(
        long id,
        long organizationId,
        long departmentId,
        String name,
        int age,
        String position
) {}

