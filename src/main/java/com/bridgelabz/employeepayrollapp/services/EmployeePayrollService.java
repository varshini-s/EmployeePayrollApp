package com.bridgelabz.employeepayrollapp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService 
{

	@Autowired
	private EmployeePayrollRepository employeePayrollRepository;

   private List<EmployeePayrollData> employeePayrollList= new ArrayList<>();
	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() 
    {
        return employeePayrollList;
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) 
    {
		return employeePayrollList.stream()
			   .filter(empData->empData.getEmployeeId()==empId)
			   .findFirst()
			   .orElseThrow(()->new EmployeePayrollException("Employee not found"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) 
    {
		
        EmployeePayrollData empData=null;
        empData= new EmployeePayrollData(employeePayrollList.size()+1,employeePayrollDTO);
		log.debug("Emp data :"+empData.toString());
        employeePayrollList.add(empData);
		return employeePayrollRepository.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId,EmployeePayrollDTO employeePayrollDTO) 
    {
		EmployeePayrollData empData=this.getEmployeePayrollDataById(empId);
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        employeePayrollList.set(empId-1,empData);
		return empData;
	}

	@Override
	public void deleteEmployeePayrollData(int empId) 
    {
		employeePayrollList.remove(empId-1);
		
	}

}
