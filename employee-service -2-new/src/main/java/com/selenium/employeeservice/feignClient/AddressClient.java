package com.selenium.employeeservice.feignClient;


import com.selenium.employeeservice.response.AddressResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//http://localhost:8081/address-app/api/address/6 gdgerger
@FeignClient(name = "address-service",path="/address-app/api/")
@RibbonClient(name = "address-service")
public interface AddressClient {//proxy
//    @GetMapping("address/{id}")
//    AddressResponse getAddressByEmployeeId(@PathVariable("id") int id);
    @GetMapping("address/{employee_id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employee_id") int employee_id);

}
