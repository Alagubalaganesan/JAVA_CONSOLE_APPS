package Employeemanagement.service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Employeemanagement.driverclass.Role;
import Employeemanagement.driverclass.Status;
import Employeemanagement.models.*;
public class Employeeservice
{
   private List<Employee> employees; 
   
   public Employeeservice()
   {
	   this.employees=new ArrayList<>();
   }
   
   //Add new employee
   public String addemployee(String name, String department, Role role, double salary )
   {
	   Employee employee=new Employee(name,department,role,salary);
	   employees.add(employee);
	   System.out.println("Employee " + name + " added successfully with ID: " + employee.getEmployeeId());
	   
	   return employee.getEmployeeId();
   }
   
   
   
   
   //Update employee's details ,updating employee whos details are incomplete 
   public void updateemployee(String employeeId, String department, Role role, double salary)
   {
	   Employee employee=findemployeebyid(employeeId);
	   if (employee == null)
	   {
           System.out.println("Employee with ID " + employeeId + " not found.");
           return;
       }
	   
	   employee.setDepartment(department);
	   employee.setRole(role);
	   employee.setSalary(salary);
	   
	   System.out.println("Employee " + employee.getName() + " updated successfully.");
	   
   }


   
   
   
   
   //Mark an employee as inactive
   public void markemployeestatus(String empid)
   {
	   Employee employee=findemployeebyid(empid);
	   
	   if (employee == null) {
           System.out.println("Employee with ID " + empid + " not found.");
           return;
       }
	   
	   employee.setStatus(Status.INACTIVE);
	   System.out.println("Employee " + employee.getName() + " marked as inactive.");
   }   
   
   
   
   //View an employee's details
   public void viewemployees(String empid)
   {
	   Employee employee=findemployeebyid(empid);
	   
	   if (employee == null) {
           System.out.println("Employee with ID " + empid + " not found.");
           return;
       }
	   System.out.println("Employee Details:");
       System.out.println("ID: " + employee.getEmployeeId());
       System.out.println("Name: " + employee.getName());
       System.out.println("Department: " + employee.getDepartment());
       System.out.println("Role: " + employee.getRole());
       System.out.println("Salary: " + employee.getSalary());
       System.out.println("Status: " + employee.getStatus());
	   
   }
   
   
   
   //List employees by department
   public void listemployeesbydept(String department)
   {
	   List<Employee> departmentemployees=employees.stream()
			   .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
			   .collect(Collectors.toList());
	   
	   if (departmentemployees.isEmpty()) {
           System.out.println("No employees found in department: " + department);
           return;
       }
	   System.out.println("Employees in department " + department + ":");
	   for (Employee employee : departmentemployees) {
           System.out.println(employee.getName() + " (ID: " + employee.getEmployeeId() + ")");
       }	   
   }   
   
   //Find employee by id
   public Employee findemployeebyid(String employeeId)
   {		
		return employees.stream()
				.filter(employee ->employee.getEmployeeId().equals(employeeId))
				.findFirst()
				.orElse(null);
   }
   
}
