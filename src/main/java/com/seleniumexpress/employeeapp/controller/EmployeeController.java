package com.seleniumexpress.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;
import com.seleniumexpress.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {

    // Moved to EmployeeService
    // @Autowired
    // private EmployeeRepo EmployeeRepo;

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {

        // Inside your controller, you shouldn't make a database call
        // db call -> employee 1
        // We're moving it to EmployeeService
        // Employee employee = EmployeeRepo.findById(id).get();

        EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);

        // return employeeResponse;

        // Using ResponseEntity allows you to also control the status code on top of the body
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
    }
}
