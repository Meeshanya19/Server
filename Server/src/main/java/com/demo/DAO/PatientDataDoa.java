package com.demo.DAO;

import com.demo.entity.PatientData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientDataDoa extends JpaRepository<PatientData, Integer> {
}
