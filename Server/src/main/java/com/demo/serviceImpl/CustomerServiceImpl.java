package com.demo.serviceImpl;

import com.demo.DAO.CustomerDao;
import com.demo.entity.Customer;
import com.demo.entity.PatientData;
import com.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean saveCustomer(Customer customer) {
        boolean status = false;
        try {
            customerDao.save(customer);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> list;
        list = customerDao.findAll();
        return list;
    }


    @Override
    public boolean deleteCustomer(Customer customer) {
        boolean status = false;
        try {
            customerDao.delete(customer);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public Optional<Customer> getCustomerByID(Customer customer) {
        return customerDao.findById(customer.getCustomerId());

    }

    @Override
    public boolean updateCustomer(Customer customer) {
        boolean status = false;
        try {
            customerDao.save(customer);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public boolean addRecord(PatientData patientData ) {
        boolean status = false;
        try {

            status = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


}
