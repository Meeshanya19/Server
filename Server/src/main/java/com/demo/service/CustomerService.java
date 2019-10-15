package com.demo.service;

import com.demo.entity.Customer;
import com.demo.entity.PatientData;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    public boolean saveCustomer(Customer customer);

    public List<Customer> getCustomers();

    public boolean deleteCustomer(Customer customer);

    public Optional<Customer> getCustomerByID(Customer customer);

    public boolean updateCustomer(Customer customer);

    public boolean addRecord(PatientData patientData);
}
