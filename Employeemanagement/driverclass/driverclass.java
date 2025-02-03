package Employeemanagement.driverclass;

import Employeemanagement.service.Employeeservice;

public class driverclass
{
	
	public static void main(String args[]) {
	// Add employees
	Employeeservice es=new Employeeservice();
	String empid1=es.addemployee("Pramoth","Engineering",Role.DEVELOPER,35000);
	String empid2=es.addemployee("Aakash","Engineering",Role.MANAGER,45000);
	String empid3=es.addemployee("Mouli","HR",Role.HR,50000);
	System.out.println();
	
	
	//View employee details
	es.viewemployees(empid1);
	System.out.println();
	es.viewemployees(empid2);
	System.out.println();
	es.viewemployees(empid3);
	System.out.println();
	
	
	// Update employee details
	es.updateemployee(empid2,"ENGINEERING",Role.TESTER,70000);
	System.out.println();
	
	// Mark an employee as inactive
	
	es.markemployeestatus(empid3);	
	System.out.println();
	
	// List employees by department
	es.listemployeesbydept("Engineering");	
	System.out.println();
	}
}

