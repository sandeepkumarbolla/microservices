package com.selenium.address.service;

import com.selenium.address.entity.Address;
import com.selenium.address.repository.AddressRepo;
import com.selenium.address.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
