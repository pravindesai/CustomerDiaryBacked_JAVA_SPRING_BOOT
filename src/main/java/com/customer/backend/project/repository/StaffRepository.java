package com.customer.backend.project.repository;

import com.customer.backend.project.model.data.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Staff findStaffByAdminUid(String adminUid);
    List<Staff> findAllByAdminUid(String adminUid);

    Staff findStaffByAdminUidAndPhoneNumber(String adminUid, String phoneNumber);
}
