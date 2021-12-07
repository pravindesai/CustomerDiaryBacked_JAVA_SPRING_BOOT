package com.customer.backend.project.repository;

import com.customer.backend.project.model.data.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findAdminByAdminUid(String admin_uid);

}
