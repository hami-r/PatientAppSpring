package com.nest.patientapp_backend.dao;

import com.nest.patientapp_backend.model.PatientModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientDao extends CrudRepository<PatientModel,Integer> {

    @Query(value = "SELECT `id`,`age`,`appointment_date`,`doctor_name`,`gender`,`name`,`patient_code` FROM `patients` WHERE `patient_code` =:code",nativeQuery = true)
    List<PatientModel> searchPatient(Integer code);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `patients` WHERE `id`= :id",nativeQuery = true)
    void deletePatient(Integer id);
}
