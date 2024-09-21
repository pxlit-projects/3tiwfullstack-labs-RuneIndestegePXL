package be.pxl.services.controller.DTO.input;

public record EmployeeRecord(long id,
                             long organizationId,
                             long departmentId,
                             String name,
                             int age,
                             String position
) {
}
