package be.pxl.services.model.dto;

public class EmployeeRequest {
    private long organizationId;

    private long departmentId;
    private String name;
    private int age;
    private String position;
    public EmployeeRequest() {
    }

    public EmployeeRequest(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }
}
