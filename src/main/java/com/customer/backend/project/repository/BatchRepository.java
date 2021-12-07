package com.customer.backend.project.repository;

import com.customer.backend.project.model.data.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    Batch findBatchById(long id);
    List<Batch> findBatchesByAdminUid(String adminUid);
    List<Batch> findBatchesByAdminUidAndStaffId(String adminUid, long staffId);


}
