package com.customer.backend.project.controller;

import com.customer.backend.project.model.data.Address;
import com.customer.backend.project.repository.AddressRepository;
import com.customer.backend.project.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    public AddressController() {
    }

    public Address createAddress(@Valid @RequestBody  Address address){
        return addressService.saveAddress(address);
    }
}
