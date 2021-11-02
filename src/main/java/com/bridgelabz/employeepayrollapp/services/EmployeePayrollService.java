package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

@Service
public class EmployeePayrollService implements IEmployeePayrollService 
{

   private List<EmployeePayrollData> employeePayrollList= new ArrayList<>();
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() 
    {
        return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) 
    {
		return employeePayrollList.get(empId-1);
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) 
    {
		
        EmployeePayrollData empData=null;
        empData= new EmployeePayrollData(1,employeePayrollDTO);
		return empData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) 
    {
		EmployeePayrollData empData=null;
        empData= new EmployeePayrollData(1,employeePayrollDTO);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) 
    {
		// TODO Auto-generated method stub
		
	}

}
