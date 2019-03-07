package com.enigma.dev.model;

public class Employee {
    private int id;
    private  int depId;
    private String name;
    private int salary;

    public Employee(int id, int depId, String name, int salary) {
        this.id = id;
        this.depId = depId;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", depId=" + depId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
