package com.employee.service.status.employeeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetEmployeeService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${dbservice.name}")
    private String dbServicePath;

    public String getEmployeeDetails(final long employeeId) {
        return restTemplate.getForObject("http://"+ dbServicePath +"/rest/db/" + employeeId, String.class);
    }
}
