package com.selenium.employeeservice.service;

import com.selenium.employeeservice.Entity.Employee;
import com.selenium.employeeservice.Repository.EmployeeRepository;
import com.selenium.employeeservice.openFeignclient.AddressClient;
import com.selenium.employeeservice.response.AddressResponse;
import com.selenium.employeeservice.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
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
    @Autowired
    private AddressClient addressClient;

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
       // addressResponse = restTemplate.getForObject("http://ADDRESS-SERVICE/address-app/api/address/{id}",AddressResponse.class,id);
        addressResponse= addressClient.getAddressByEmployeeId(id).getBody();
        employeeResponse.setAddressResponse(addressResponse);
        return employeeResponse;
    }

//    public List<Employee> getEmployees() {
//        List<Employee> employeeList = employeeRepository.findAll();
//        return employeeList;
//    }


//    public List<EmployeeResponse> getEmployee(){
//        List<Employee> employee;
//        employee=employeeRepository.findAll();
//        EmployeeResponse employeeResponse=Arrays.asList(modelMapper.map(e,Employee.class));
//
//        return employeeResponse;
//    }


    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponse> employeeResponses = Arrays.asList(modelMapper.map(employeeList, EmployeeResponse[].class));
        ResponseEntity<List<AddressResponse>> addressResponses = addressClient.getAddresses();
        List<AddressResponse> addressResponses1=addressResponses.getBody();

        System.out.println(addressResponses.getBody().get(2).getState());
        employeeResponses.forEach(employeeResponse -> {
            System.out.println(employeeResponse.getId());
            for (AddressResponse addressResponse:addressResponses1
                 ) {
                        if (addressResponse.getId()==employeeResponse.getId()){
                            employeeResponse.setAddressResponse(addressResponse);
                        }

            }
            //System.out.println(addressResponses.get(employeeResponse.getId()-1).getState());
           // employeeResponse.setAddressResponse(addressResponses.get(employeeResponse.getId()-1));
          //  employeeResponse.setAddressResponse(addressClient.getAddressByEmployeeId(employeeResponse.getId()).getBody());
        });
        return employeeResponses;
    }

    public void addEmployee(EmployeeResponse employeeResponse) {
        AddressResponse addressResponse = employeeResponse.getAddressResponse();
        addressResponse.setEmployee_id(employeeResponse.getId());
        Employee employee = new Employee();
        System.out.println("employee Id from post request>>>>"+employeeResponse.getId());
        employee.setId(employeeResponse.getId());
        System.out.println("assigned employee id>>>>>>>>>>>>>"+employee.getId());
        employee.setName(employeeResponse.getName());
        employee.setEmail(employeeResponse.getEmail());
        employee.setBloodGroup(employeeResponse.getBloodGroup());
        System.out.println(employee.getId()+"\n"+
                employee.getEmail()+"\n"+
                employee.getName());
        System.out.println(addressResponse.getId()+"\n"+
                addressResponse.getLane1()+"\n"+
                addressResponse.getState()+"\n"+
                addressResponse.getZip());
        employeeRepository.save(employee);
        addressClient.addAddress(addressResponse);
//        addressResponse.setId(employeeResponse.getId());
//        addressResponse.setLane1(employeeResponse.getAddressResponse().getLane1());
//        addressResponse.setLane2(employeeResponse.getAddressResponse().getLane2());
//        addressResponse.setState(employeeResponse.getAddressResponse().getState());
//        addressResponse.setZip(employeeResponse.getAddressResponse().getZip());
    }
}






//        EmployeeResponse employeeResponse=new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setBloodGroup(employee.getBloodGroup());
//        employeeResponse.setEmail(employee.getEmail());