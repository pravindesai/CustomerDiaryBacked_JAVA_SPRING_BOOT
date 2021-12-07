package com.customer.backend.project.service;

import com.customer.backend.project.model.data.Customer;
import com.customer.backend.project.model.data.Staff;
import com.customer.backend.project.repository.CustomerRepository;
import com.customer.backend.project.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StaffService {
    @Autowired StaffRepository staffRepository;
    @Autowired CustomerRepository customerRepository;

    public Staff saveStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public Staff updateStaff(Staff staff) {
        Staff updatedStaff = staffRepository.getById(staff.getId());
        updatedStaff.setAdminUid(    staff.getAdminUid()    );
        updatedStaff.setEmail(       staff.getEmail()       );
        updatedStaff.setPhoneNumber(staff.getPhoneNumber() );
        updatedStaff.setAddress(     staff.getAddress()     );
        updatedStaff.setName(        staff.getName()        );
        updatedStaff.setStatus(      staff.getStatus()      );
        updatedStaff.setType(        staff.getType()        );

        return staffRepository.save(updatedStaff);
    }

    public void removeStaffId(long staff_id) {
        staffRepository.deleteById(staff_id);
    }

    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }
    public List<Staff> getAllStaffByAdminUid(String admin_uid) {
        return staffRepository.findAllByAdminUid(admin_uid);
    }


}
