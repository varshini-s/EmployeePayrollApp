package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController 
{
	// curl localhost:8080/employeepayrollservice/ -w "\n"
    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData()
    {
        EmployeePayrollData empData=null;
        empData= new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        ResponseDTO respDTO = new ResponseDTO("Get call Succesfull", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }


    //curl localhost:8080/employeepayrollservice/get/1 -w "\n"
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId") int empId)
    {
        EmployeePayrollData empData=null;
        empData= new EmployeePayrollData(1,new EmployeePayrollDTO("Pankaj",30000));
        ResponseDTO respDTO = new ResponseDTO("Get call For ID Succesfull", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
    
    //curl -X POST -H "Content-Type: application/json" -d '{"name": "Lisa","salary":2000}' "http://localhost:8080/employeepayrollservice/create" -w "\n"

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {

        EmployeePayrollData empData=null;
        empData= new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created payroll data successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
	
    //curl -X PUT -H "Content-Type: application/json" -d '{"name": "Lisa","salary": 2000}' "http://localhost:8080/employeepayrollservice/update" -w "\n"
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@RequestBody EmployeePayrollDTO employeePayrollDTO)
    {

        EmployeePayrollData empData=null;
        empData= new EmployeePayrollData(1,employeePayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created payroll data successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }

    
    //curl -X DELETE -H "Content-Type: application/json" localhost:8080/employeepayrollservice/delete/1 -w "\n"
    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId)
    {

        ResponseDTO respDTO = new ResponseDTO("Deleted successfuly","Deleted id: "+empId);
        return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
    }
}
