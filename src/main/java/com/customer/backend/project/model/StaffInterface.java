package com.customer.backend.project.model;

import com.customer.backend.project.model.data.Customer;


public interface StaffInterface extends UserInterface {
    Customer addCustomer(Customer c);
    void removeCustomer(long id);
    Customer updateCustomer(Customer c);
}
