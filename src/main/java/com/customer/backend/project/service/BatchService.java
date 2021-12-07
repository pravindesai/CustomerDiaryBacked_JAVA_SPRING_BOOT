package com.customer.backend.project.service;

import com.customer.backend.project.model.data.Batch;
import com.customer.backend.project.model.data.Customer;
import com.customer.backend.project.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BatchService {
    @Autowired BatchRepository batchRepository;

     public Batch addBatch(Batch batch){
        try {
            return  batchRepository.save(batch);
            }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public Batch updateBatch(Batch batch){
       Batch savedbatch =  batchRepository.save(batch);
        if (savedbatch==null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return savedbatch;
    }

    public void removeBatch(long batch_id){
        batchRepository.deleteById(batch_id);
    }

    public List<Batch> getAllBatch(){
        return batchRepository.findAll();
    }


    public List<Batch> getAllBatchForAdmin(String adminuid) {
        return batchRepository.findBatchesByAdminUid(adminuid);
     }

    public List<Batch> getAllBatchForStaff(String adminuid, long staffid) {
         return batchRepository.findBatchesByAdminUidAndStaffId(adminuid, staffid);
    }
}
