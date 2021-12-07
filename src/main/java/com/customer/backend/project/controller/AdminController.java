package com.customer.backend.project.controller;

import com.customer.backend.project.model.StaffInterface;
import com.customer.backend.project.model.data.*;
import com.customer.backend.project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired AdminService adminService;
    @Autowired AddressService addressService;
    @Autowired BatchService batchService;
    @Autowired CustomerService customerService;
    @Autowired StaffService staffService;

    public AdminController() {

    }

    @PostMapping()
    public Admin createAdmin(@Valid  @RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @PutMapping("/{admin_uid}")
    public Admin updateAdmin(@RequestParam String admin_uid,@Valid @RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }

    @GetMapping("/{admin_uid}")
    public Admin getLoggedInAdmin(@RequestParam String admin_uid){
        return  adminService.getAdminByUid(admin_uid);
    }

    @GetMapping()
    public List<Admin> getAllAdmin(){
        return adminService.getAllAdmin();
    }



    @PostMapping("/{admin_uid}/staff")
    public Staff addStaff(@RequestParam(required = false) String admin_uid, @RequestBody @Valid Staff staff){
        return staffService.saveStaff(staff);
    }

    @PutMapping("/{admin_uid}/staff/{staff_id}")
    public Staff updateStaff(@RequestParam String admin_uid, @RequestParam long staff_id, @RequestBody @Valid Staff staff){
        return staffService.updateStaff(staff);
    }

    @DeleteMapping("/{admin_uid}/staff/{staff_id}")
    public void removeStaff(@RequestParam String admin_uid, @RequestParam long staff_id){
        staffService.removeStaffId(staff_id);
    }

    @GetMapping("/{admin_uid}/staff/")
    public List<Staff> getAllStaff(@RequestParam String admin_uid){
        return staffService.getAllStaffByAdminUid(admin_uid);
    }

    @GetMapping("/staff")
    public List<Staff> getAllStaff(){
        return staffService.getAllStaff();
    }



    @PostMapping("/{admin_uid}/batch")
    public Batch addBatch(@Valid @RequestBody Batch batch){
        return batchService.addBatch(batch);
    }

    @PutMapping("/{admin_uid}/batch/{batch_id}")
    public Batch updateBatch(@RequestParam String admin_uid,@RequestParam long batch_id,  @Valid @RequestBody Batch batch){
        return batchService.updateBatch(batch);
    }

    @DeleteMapping("/{admin_uid}/batch/{batch_id}")
    public void removeBatch(@RequestParam String admin_uid, @RequestParam long batch_id){
        batchService.removeBatch(batch_id);
    }

    @GetMapping("/{admin_uid}/batch")
    public List<Batch> getAllBatchForAdmin(@RequestParam String admin_uid){
        return batchService.getAllBatchForAdmin(admin_uid);
    }

    @GetMapping("/{admin_uid}/batch/staff/{staffid}")
    public List<Batch> getAllBatchForStaff(@RequestParam String admin_uid, @RequestParam long staffid){
        return batchService.getAllBatchForStaff(admin_uid, staffid);
    }

    @GetMapping("/batch")
    public List<Batch> getAllBatch(){
        return batchService.getAllBatch();
    }

}
