package com.demo.serviceImpl;

import com.demo.DAO.PatientDataDoa;
import com.demo.entity.PatientData;
import com.demo.service.PatientDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientDataServiceImpl implements PatientDataService {
    @Autowired
    private PatientDataDoa patientDataDoa;

    @Override
    public boolean saveData(PatientData data) {
        boolean status = false;
        try {
            patientDataDoa.save(data);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<PatientData> getData(int id) {
        List<PatientData> temp = patientDataDoa.findAll();
        List<PatientData> list = new ArrayList<PatientData>();
        for (PatientData patientData : temp) {
            if (patientData.getCustomer().getCustomerId() == id) {
                list.add(patientData);
            }
        }
        return list;
    }

    @Override
    public boolean deleteData(PatientData data) {
        boolean status = false;
        try {
            patientDataDoa.delete(data);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


    @Override
    public Optional<PatientData> getDataByID(PatientData data) {
        return patientDataDoa.findById(data.getId());
    }


    @Override
    public boolean updateData(PatientData data) {
        boolean status = false;
        try {
            patientDataDoa.save(data);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}

