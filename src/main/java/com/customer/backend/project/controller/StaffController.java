package com.customer.backend.project.controller;

import com.customer.backend.project.model.data.Address;
import com.customer.backend.project.model.data.Customer;
import com.customer.backend.project.model.StaffInterface;
import com.customer.backend.project.service.CustomerService;
import com.customer.backend.project.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    @Autowired StaffService staffService;
    @Autowired CustomerService customerService;

    public StaffController() {
    }

    @PostMapping("/{staff_id}/customer")
    public Customer addCustomer(@RequestParam(required = false) Long staff_id,@Valid @RequestBody Customer c) {
        return customerService.addCustomer(c);
    }

    @DeleteMapping("/{staffid}/customer/{customerId}")
    public void removeCustomer(@Valid @RequestParam long staffid,@RequestParam long customerId) {
        customerService.removeCustomer(customerId);
    }

    @PutMapping("/{staffid}/customer/{customerId}")
    public Customer updateCustomer(@Valid @RequestParam long staffid, @RequestParam long customerId, @Valid @RequestBody Customer c) {
        return customerService.updateCustomer(c);
    }

    @GetMapping("/{staffid}/customer")
    public List<Customer> getAllCustomerForStaff(@Valid @RequestParam long staffid){
        return customerService.getAllCustomersForStaff(staffid);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

}

