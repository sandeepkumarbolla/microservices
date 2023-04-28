package com.selenium.employeeservice.openFeignclient;

import com.selenium.employeeservice.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ADDRESS-SERVICE",path = "/address-app/api")
public interface AddressClient {
    @GetMapping("address/{employee_id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employee_id") int employee_id);
    @GetMapping("/alladdress")
    public ResponseEntity<List<AddressResponse>> getAddresses();
}
