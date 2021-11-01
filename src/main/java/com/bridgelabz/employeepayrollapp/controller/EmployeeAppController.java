package com.bridgelabz.employeepayrollapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.model.Employee;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeeAppController 
{
	// curl localhost:8080/employeepayrollservice/ -w "\n"
    @RequestMapping(value = {"","/","/home"})
    public String sayHello()
    {
        return "Hello from bridgelabz!";
    }

    // curl localhost:8080/employeepayrollservice/query/?name=ted -w "\n"
    @RequestMapping(value="/query", method=RequestMethod.GET)
    public String sayHello(@RequestParam(value="name") String name) 
    {
        return "Hello "+name+"!";
    }

    //curl localhost:8080/employeepayrollservice/param/sam -w "\n"
    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name)
    {
        return "Hello "+name+"!";
    }
    
    // curl -X POST -H "Content-Type: application/json" -d '{"firstName": "Lisa","lastName":"Harry"}' "http://localhost:8080/employeepayrollservice/post" -w "\n"    
    @PostMapping("/post")
    public String sayHello(@RequestBody Employee employee)
    {

        return "Hello "+employee.getFirstName()+" "+employee.getLastName();
    }
	
   //curl -X PUT localhost:8080/employeepayrollservice/put/Lisa/?lastName=jane -w "\n"
    @PutMapping("put/{firstName}")
    public String sayHello(@PathVariable String firstName, @RequestParam(value="lastName") String lastName) {
        
        return "Hello "+firstName+" "+lastName+"!";
    }

}
