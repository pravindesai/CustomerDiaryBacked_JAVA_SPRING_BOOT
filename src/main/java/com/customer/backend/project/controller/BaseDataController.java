package com.customer.backend.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/basedata")
public class BaseDataController {

    List<String > typeOptionList = List.of("PAID", "FREE", "LIMITED");
    List<String > statusOptionList = List.of("ACTIVE", "INACTIVE", "DISABLE");
    List<String > genderOptionList = List.of("MALE", "FEMALE", "OTHER");

    @GetMapping("/status")
    public List<String> getStatusOptions(){
        return statusOptionList;
    }

    @GetMapping("/type")
    public List<String> getTypeOptions(){
        return typeOptionList;
    }

    @GetMapping("/gender")
    public List<String> getgenderOptions(){
        return genderOptionList;
    }



}
