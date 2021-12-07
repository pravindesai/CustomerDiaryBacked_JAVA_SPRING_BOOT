package com.customer.backend.project.service;

import com.customer.backend.project.model.data.Customer;
import com.customer.backend.project.repository.CustomerRepository;
import com.customer.backend.project.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Service
public class CustomerService {

    @Autowired CustomerRepository customerRepository;
    @Autowired StaffRepository staffRepository;


    public Customer updateCustomer(Customer c) {
        Customer customer;
        if (customerRepository.findById(c.getId()).isPresent()){
            customer = customerRepository.findById(c.getId()).get();
            c.setPassword(customer.getPassword());
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return customerRepository.save(c);
    }

    public List<Customer> getAllCustomersForStaff(long staffid){
        return customerRepository.findAllByStaffId(staffid);
    }

    public Customer addCustomer( Customer c) {
        return customerRepository.save(c);
    }

    public void removeCustomer( long customerid) {
        customerRepository.deleteById(customerid);
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

}
