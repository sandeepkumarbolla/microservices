package com.selenium.employeeservice.controller;

import com.selenium.employeeservice.Entity.Employee;
import com.selenium.employeeservice.response.EmployeeResponse;
import com.selenium.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){

            EmployeeResponse employeeResponse= employeeService.getEmployeeID(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }

    @GetMapping("/employees")
    ResponseEntity<List<EmployeeResponse>>  getEmployeesDetails(){
       List<EmployeeResponse> employeeResponses=employeeService.getAllEmployees();
       return ResponseEntity.status(HttpStatus.OK).body(employeeResponses);
    }


//    @GetMapping("/employees")
//    ResponseEntity<List<Employee>> getEmployeeDetails(){
//        List<Employee> employeeList=employeeService.getEmployees();
//        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
//    }
}
