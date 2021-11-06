package com.bridgelabz.employeepayrollapp.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.ToString;

public @ToString class EmployeePayrollDTO 
{
	// @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$",message = "employee name Invalid")
	public String name;
	
	@Min(value = 500,message = "Min wage should be more than 50")
	public long salary;

	public String gender;

	public LocalDate startDate;

	public String note;

	public String profilePic;

	public List<String> department;
	

	public EmployeePayrollDTO(String name, long salary) 
	{
		this.name = name;
		this.salary = salary;
	}

	
	
	
}
