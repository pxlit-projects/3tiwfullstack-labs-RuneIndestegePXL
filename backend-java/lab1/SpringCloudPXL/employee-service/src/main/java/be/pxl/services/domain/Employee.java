package be.pxl.services.domain;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long organizationId;

    private long departmentId;
    private String name;
    private int age;
    private String position;

    public Employee(long id, long organizationId, long departmentId, String name, int age, String position) {
        this.id = id;
        this.organizationId = organizationId;
        this.departmentId = departmentId;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Employee(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public static class Builder {
        private long id;
        private long organizationId;
        private long departmentId;
        private String name;
        private int age;
        private String position;

        public Builder() {}

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder organizationId(long organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        public Builder departmentId(long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder position(String position) {
            this.position = position;
            return this;
        }

        // Build method to create an Employee instance
        public Employee build() {
            return new Employee(id, organizationId, departmentId, name, age, position);
        }
    }

}
