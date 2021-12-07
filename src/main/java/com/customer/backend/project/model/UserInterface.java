package com.customer.backend.project.model;

import com.customer.backend.project.model.data.Address;

public interface UserInterface {

    void changeName(String name);
    void changePassword(String pass);
    void changeAddress(Address address);
    void changeEmail(String email);
    void changePhoneNumber(String phone_number);
    void changeGender(String gender);
    void changeStatus(String status);
}
