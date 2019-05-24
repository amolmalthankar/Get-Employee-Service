package com.employee.service.status.employeeservice.service;


import com.employee.service.status.employeeservice.controller.GetEmployeeController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GetEmployeeController.class)
public class GetEmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private GetEmployeeService getEmployeeService;

    @Test
    public void test() throws Exception {
        Mockito.when(getEmployeeService.getEmployeeDetails(anyLong())).thenReturn("Already Exists");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/rest/employee/"+anyLong()).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        Assert.assertEquals("Already Exists", result.getResponse().getContentAsString());


//
//        mockMvc.perform(post("/rest/employee/add")
//                .contentType("application/json"))
//                .andExpect(status().isOk()).andExpect(mvcResult -> mvcResult.getResponse().getContentAsString().equals("Added"));
//        System.out.println("");
    }
}