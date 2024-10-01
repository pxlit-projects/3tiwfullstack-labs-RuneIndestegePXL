package be.pxl.services.controller.DTO.output;

import be.pxl.services.domain.Department;
import be.pxl.services.domain.Employee;

import java.util.List;
import java.util.Optional;

public record OrganizationResponseDTO (
        long id,
        String name,
        String address
) {
}
