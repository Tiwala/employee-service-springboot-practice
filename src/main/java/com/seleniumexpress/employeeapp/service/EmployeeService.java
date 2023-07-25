package com.seleniumexpress.employeeapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seleniumexpress.employeeapp.entity.Employee;
import com.seleniumexpress.employeeapp.repo.EmployeeRepo;
import com.seleniumexpress.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo EmployeeRepo;

    // You also have to create an EmployeeAppConfig for ModelMapper
    @Autowired
    private ModelMapper modelMapper;
    
    public EmployeeResponse getEmployeeById(int id) {
        // Return my employee object here whenever I make a db call

        // employee -> EmployeeResponse
        Employee employee = EmployeeRepo.findById(id).get();       

        // Doing this shit manually is ass; let's do something better
        // EmployeeResponse employeeResponse = new EmployeeResponse();
        // employeeResponse.setId(employee.getId());
        // employeeResponse.setName(employee.getName());
        // employeeResponse.setEmail(employee.getEmail());
        // employeeResponse.setBloodGroup(employee.getBloodGroup());

        // All of the properties in employee will be mapped to the EmployeeResponse class
        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);

        return employeeResponse;
    }
}
