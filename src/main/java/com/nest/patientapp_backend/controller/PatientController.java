package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.dao.PatientDao;
import com.nest.patientapp_backend.model.PatientModel;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientDao dao;
    @GetMapping("/")
    public String homePage(){
        return "Welcome";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addPage(@RequestBody PatientModel p){
        dao.save(p);
        return "success";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<PatientModel> viewPage(){
        return (List<PatientModel>) dao.findAll();
    }
}
