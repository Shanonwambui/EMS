package com.example.ems1.controller;


import com.example.ems1.exception.ResourceNotFoundException;
import com.example.ems1.model.Employee;
import com.example.ems1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    // build create employee rest api

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    // build get employee by id rest api

    @GetMapping("{id}")
    public ResponseEntity<Employee> getAllEmployeesById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Employee not found with id:" + id));
        return ResponseEntity.ok(employee);

    }
    // build update employee rest api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails){
        Employee updateEmployee= employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee not found with id"+ id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName((employeeDetails.getLastName()));
        updateEmployee.setEmailId((employeeDetails.getEmailId()));

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);


    }
@DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee deleteEmployee = employeeRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("Employee not found with id" +id));

        employeeRepository.delete(deleteEmployee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
