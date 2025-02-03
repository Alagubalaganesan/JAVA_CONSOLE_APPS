package Employeemanagement.models;

import java.util.UUID;
import Employeemanagement.driverclass.Role;
import Employeemanagement.driverclass.Status;

public class Employee
{
	private String employeeId;
    private String name;
    private String department;
    private Role role;
    private double salary;
    private Status status;
    
    public Employee(String name, String department, Role role, double salary) {
        this.employeeId = UUID.randomUUID().toString(); // Auto-generate ID
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.status = Status.ACTIVE;
    }
    
    // Getters and Setters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

