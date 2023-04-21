package com.selenium.employeeservice.service;

import com.selenium.employeeservice.Entity.Employee;
import com.selenium.employeeservice.Repository.EmployeeRepository;
import com.selenium.employeeservice.response.AddressResponse;
import com.selenium.employeeservice.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    //@Autowired
    private RestTemplate restTemplate;

//    @Value("${addressService.base.url}")
//    private String addressBaseUrl;
//test
    public EmployeeService(@Value("${addressService.base.url}") String addressBaseUrl,
                           RestTemplateBuilder builder) {
        System.out.println(addressBaseUrl);
        this.restTemplate=builder
                .rootUri(addressBaseUrl)
                .build();
    }

    public EmployeeResponse getEmployeeID(int id){

        AddressResponse addressResponse=new AddressResponse();

        Employee employee=employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);
        addressResponse = restTemplate.getForObject("/address/{id}",AddressResponse.class,id);
        employeeResponse.setAddressResponse(addressResponse);
//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setBloodGroup(employee.getBloodGroup());
//        employeeResponse.setEmail(employee.getEmail());
        return employeeResponse;
    }
}
