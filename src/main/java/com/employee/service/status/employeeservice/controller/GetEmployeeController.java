package com.employee.service.status.employeeservice.controller;

import com.employee.service.status.employeeservice.service.GetEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/employee")
public class GetEmployeeController {

    @Autowired
    private GetEmployeeService getEmployeeService;

    @GetMapping("/{employeeId}")
    public String getEmployeeDetails(@PathVariable("employeeId") final long employeeId) {
        return getEmployeeService.getEmployeeDetails(employeeId);
    }
}
