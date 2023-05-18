package com.selenium.employeeservice.service;

import com.selenium.employeeservice.Entity.Employee;
import com.selenium.employeeservice.Repository.EmployeeRepository;
import com.selenium.employeeservice.feignClient.AddressClient;
import com.selenium.employeeservice.response.AddressResponse;
import com.selenium.employeeservice.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    AddressClient addressClient;
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

    public EmployeeResponse getEmployeeByID(int id){

        AddressResponse addressResponse;
        Employee employee=employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);

        ResponseEntity<AddressResponse> addressResponseEntity=addressClient.getAddressByEmployeeId(id);
        addressResponse = addressResponseEntity.getBody();
        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;
    }



    public List<Employee> getEmployee(){
        List<Employee> employeeList =employeeRepository.findAll();
        return employeeList;
    }
}
