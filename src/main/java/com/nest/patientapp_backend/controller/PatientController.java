package com.nest.patientapp_backend.controller;

import com.nest.patientapp_backend.dao.PatientDao;
import com.nest.patientapp_backend.model.PatientModel;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public HashMap<String,String> addPage(@RequestBody PatientModel p){
        dao.save(p);
        HashMap<String,String > map = new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<PatientModel> viewPage(){
        return (List<PatientModel>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<PatientModel> searchPage(@RequestBody PatientModel p){
        return (List<PatientModel>) dao.searchPatient(p.getPatientCode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public HashMap<String,String> delete(@RequestBody PatientModel p){
        if(p.getId() == 0)
        {
            System.out.println(p.getId());
        }
        dao.deletePatient(p.getId());
        HashMap<String,String > map = new HashMap<>();
        map.put("status","success");
        return map;
    }
}
