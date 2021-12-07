package com.customer.backend.project.service;

import com.customer.backend.project.model.data.Address;
import com.customer.backend.project.repository.AddressRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@NoArgsConstructor
public class AddressService {

    @Autowired AddressRepository addressRepository;

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public void deleteAddressById(long id){
        addressRepository.deleteById(id);
    }

    public Address updateAddress(Address updatedAddress){
        Address address = addressRepository.findAddressById(updatedAddress.getId());
        if (address==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return addressRepository.save(updatedAddress);
    }
}
