package com.selenium.address.controller;

import com.selenium.address.entity.Address;
import com.selenium.address.repository.AddressRepo;
import com.selenium.address.response.AddressResponse;
import com.selenium.address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    AddressRepo addressRepo;
    @Autowired
    AddressService addressService;

    @PostMapping("/addaddress")
    public ResponseEntity<Address> addAddress(@RequestBody Address address){
        addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(address);
    }

    @GetMapping("/alladdress")
    public ResponseEntity<List<AddressResponse>> getAddresses(){
        List<AddressResponse> addressResponses=addressService.getAllAddresses();
        return ResponseEntity.status(HttpStatus.OK).body(addressResponses);
    }


    @GetMapping("address/{employee_id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employee_id") int employee_id){
        Address address;
        AddressResponse addressResponse = null;
        addressResponse =addressService.findAddressEmployeeById(employee_id);
        System.out.println("finding address for employee with id="+employee_id);
        //System.out.println("running in server no 1");
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @GetMapping("/hello")
    public List<Address> getEmployee(){
        List<Address> address=addressRepo.findAll();
        return address;
    }

}
