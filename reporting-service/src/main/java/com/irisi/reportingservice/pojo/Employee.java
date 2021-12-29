package com.irisi.reportingservice.pojo;

public class Employee {

    private final Integer id;
    private final String name;
    private final String designation;
    private final String department;

    public Employee(final Integer id, final String name, final String designation, final String department) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }
}