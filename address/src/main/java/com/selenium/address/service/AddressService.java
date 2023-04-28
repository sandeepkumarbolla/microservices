package com.selenium.address.service;

import com.selenium.address.entity.Address;
import com.selenium.address.repository.AddressRepo;
import com.selenium.address.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;
    @Autowired
   private ModelMapper modelMapper;
    public AddressResponse findAddressEmployeeById(int employee_id){
      Address  address = addressRepo.findAddressByEmployeeId(employee_id);
       AddressResponse addressResponse=modelMapper.map(address,AddressResponse.class);
        return addressResponse;
    }

    public List<AddressResponse>  getAllAddresses() {
        List<Address> addresses=addressRepo.findAll();
        List<AddressResponse> addressResponses= Arrays.asList(modelMapper.map(addresses,AddressResponse[].class));
        return addressResponses;

    }
}
