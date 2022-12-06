package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.model.PatientModel;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @GetMapping("/")
    public String homePage(){
        return "Welcome";
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public String addPage(){
        return "success";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<PatientModel> viewPage(){
        Object list = null;
        return (List<PatientModel>)list;
    }
}
