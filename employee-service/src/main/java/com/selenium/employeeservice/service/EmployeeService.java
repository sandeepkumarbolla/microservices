package com.selenium.employeeservice.service;

import com.selenium.employeeservice.Entity.Employee;
import com.selenium.employeeservice.Repository.EmployeeRepository;
import com.selenium.employeeservice.response.AddressResponse;
import com.selenium.employeeservice.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${addressService.base.url}")
    private String addressBaseUrl;
//test
//    public EmployeeService(@Value("${addressService.base.url}") String addressBaseUrl,
//                           RestTemplateBuilder builder) {
//        System.out.println(addressBaseUrl);
//        this.restTemplate=builder
//                .rootUri(addressBaseUrl)
//                .build();
//    }

    public EmployeeResponse getEmployeeID(int id){

        AddressResponse addressResponse=new AddressResponse();
        Employee employee=employeeRepository.findById(id).get();
        EmployeeResponse employeeResponse= modelMapper.map(employee,EmployeeResponse.class);

//        List<ServiceInstance> instances = discoveryClient.getInstances("address-service");
//        ServiceInstance serviceInstance=instances.get(0);
//        String url = serviceInstance.getUri().toString();

//        ServiceInstance serviceInstance = loadBalancerClient.choose("address-service");
//        String url = serviceInstance.getUri().toString();
//        String contextRoot = serviceInstance.getMetadata().get("configPath");
//        String user=serviceInstance.getMetadata().get("user");
//        System.out.println("user>>>>>>>>>>>>>>>>>>>>>>"+user);
//        System.out.println("context-path>>>>>>>>>>>>>>"+contextRoot);
//        System.out.println("url>>>>>>>>>>>>>>>>>>>>>>>"+url+contextRoot);
     //   System.out.println("AddressBaseURL>>>>>>>>>>>>"+addressBaseUrl);




        addressResponse = restTemplate.getForObject("http://ADDRESS-SERVICE/address-app/api/address/{id}",AddressResponse.class,id);
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }



    public List<Employee> getEmployee(){
        List<Employee> employeeList =employeeRepository.findAll();
        return employeeList;
    }
}






//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setBloodGroup(employee.getBloodGroup());
//        employeeResponse.setEmail(employee.getEmail());