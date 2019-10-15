package com.demo.controller;

import com.demo.entity.Customer;
import com.demo.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")

public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;


    @PostMapping("save-customer")
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);

    }

    @GetMapping("customers-list")
    public List<Customer> allCustomers() {
        return customerService.getCustomers();

    }

    @GetMapping("customer/{customer_id}")
    public Optional<Customer> CustomerByID(@PathVariable("customer_id") int customer_id,
                                           Customer customer) {
        customer.setCustomerId(customer_id);
        return customerService.getCustomerByID(customer);

    }

    @DeleteMapping("delete-customer/{customer_id}")
    public void DeleteCustomer(@PathVariable("customer_id") int id,
                               Customer customer) {
        customer.setCustomerId(id);
        customerService.deleteCustomer(customer);
    }

    @PostMapping("update-customer/{customer_id}")
    public boolean UpdateCustomer(@PathVariable("customer_id") int id,
                                  @RequestBody Customer customer
    ) {
        customer.setCustomerId(id);
        return customerService.updateCustomer(customer);
    }


}
