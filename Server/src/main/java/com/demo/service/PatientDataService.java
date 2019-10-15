package com.demo.service;

import com.demo.entity.PatientData;

import java.util.List;
import java.util.Optional;


public interface PatientDataService {
    public boolean saveData(PatientData data);

    public List<PatientData> getData(int id);

    public boolean deleteData(PatientData data);

    public Optional<PatientData> getDataByID(PatientData data);

    public boolean updateData(PatientData data);
}
