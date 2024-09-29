package be.pxl.services.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long organizationId;

    @Transient
    private List<Employee> employees;

    private String position;

    public Department(){}

    public Department(long id, long organizationId, String position){
        this.id = id;
        this.organizationId = organizationId;
        this.position = position;
        //todo
        this.employees = null;
    }

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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
