package com.customer.backend.project.controller;

import com.customer.backend.project.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/batch")
public class BatchController{

    @Autowired
    BatchRepository batchRepository;

    public BatchController() {
    }



}
