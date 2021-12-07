package com.customer.backend.project.controller;

import com.customer.backend.project.model.data.Address;
import com.customer.backend.project.repository.CustomerRepository;
import com.customer.backend.project.model.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController implements UserInterface {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerController() {
    }


    @Override
    public void changeName(String name) {

    }

    @Override
    public void changePassword(String pass) {

    }

    @Override
    public void changeAddress(Address address) {

    }

    @Override
    public void changeEmail(String email) {

    }

    @Override
    public void changePhoneNumber(String phone_number) {

    }

    @Override
    public void changeGender(String gender) {

    }

    @Override
    public void changeStatus(String status) {

    }
}
