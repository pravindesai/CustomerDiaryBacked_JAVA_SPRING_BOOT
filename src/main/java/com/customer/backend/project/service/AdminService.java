package com.customer.backend.project.service;

import com.customer.backend.project.Log;
import com.customer.backend.project.model.data.Staff;
import com.customer.backend.project.repository.AdminRepository;
import com.customer.backend.project.model.data.Admin;
import com.customer.backend.project.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdminService {

    @Autowired AdminRepository adminRepository;
    @Autowired StaffRepository staffRepository;


    public Admin saveAdmin(Admin admin){
        Staff defaultStaff = new Staff(
                admin.getServiceName(), admin.getType(), admin.getEmail(), "NA", admin.getAddress(),
                admin.getPhoneNumber(), admin.getStatus(), null,admin.getAdminUid(), 0, null);

        Admin savedAdmin = null;
        try{

            savedAdmin = adminRepository.save(admin);
            staffRepository.save(defaultStaff);

        }catch (Exception e){
            Log.exception(e.getMessage());
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        return savedAdmin;
    }

    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    public Admin getAdminByUid(String admin_uid) {
        Admin admin = adminRepository.findAdminByAdminUid(admin_uid);
        if(admin==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return admin;
    }

    public Admin updateAdmin(Admin updatedAdmin){
        Admin admin = adminRepository.findAdminByAdminUid(updatedAdmin.getAdminUid());
        if (admin == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Staff defaultStaff = staffRepository.findStaffByAdminUidAndPhoneNumber(admin.getAdminUid(), admin.getPhoneNumber());

        if (defaultStaff == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        admin.setAdminUid(     updatedAdmin.getAdminUid()     );
        admin.setEmail(        updatedAdmin.getEmail()        );
        admin.setAddress(      updatedAdmin.getAddress()      );
        admin.setServiceName(  updatedAdmin.getServiceName()  );
        admin.setStatus(       updatedAdmin.getStatus()       );
        admin.setType(         updatedAdmin.getType()         );

        defaultStaff.setAdminUid(updatedAdmin.getAdminUid());
        defaultStaff.setEmail(updatedAdmin.getEmail());
        defaultStaff.setPhoneNumber(updatedAdmin.getPhoneNumber());
        defaultStaff.setAddress(updatedAdmin.getAddress());
        defaultStaff.setName(updatedAdmin.getServiceName());
        defaultStaff.setStatus(updatedAdmin.getStatus());
        defaultStaff.setType(updatedAdmin.getType());




        try {
            Admin updated = adminRepository.save(admin);
            staffRepository.save(defaultStaff);
             return updated;
        }catch (Exception e){
            Log.exception(e.getMessage());
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }


    }

}
