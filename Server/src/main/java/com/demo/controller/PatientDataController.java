package com.demo.controller;

import com.demo.entity.PatientData;
import com.demo.serviceImpl.PatientDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")

public class PatientDataController {
    @Autowired
    PatientDataServiceImpl patientDataService;

    @PostMapping("create-record")
    public boolean addRecord(
            @RequestBody PatientData patientData) {
        return patientDataService.saveData(patientData);
    }

    @GetMapping("get-record-list/{customer_id}")
    public List<PatientData> getCustomerRecord(
            @PathVariable("customer_id") int id) {
        return patientDataService.getData(id);
    }

    @GetMapping("record/{record_id}")
    public Optional<PatientData> recordByID(
            @PathVariable("record_id") int id) {
        PatientData patientData = new PatientData();
        patientData.setId(id);
        return patientDataService.getDataByID(patientData);

    }

    @DeleteMapping("delete-record/{record_id}")
    public void deleteRecord(
            @PathVariable("record_id") int id) {
        PatientData patientData = new PatientData();
        patientData.setId(id);
        patientDataService.deleteData(patientData);
    }

    @PostMapping("update-record/{record_id}")
    public boolean updateRecord(@PathVariable("record_id") int id,
                                @RequestBody PatientData patientData) {
        patientData.setId(id);
        return patientDataService.updateData(patientData);


    }

}
