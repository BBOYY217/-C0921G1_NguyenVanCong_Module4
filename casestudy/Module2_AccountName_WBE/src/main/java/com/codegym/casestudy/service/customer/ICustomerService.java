package com.codegym.casestudy.service.customer;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import com.sun.org.apache.xpath.internal.compiler.Keywords;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService  {
    Page<Customer> findAll(String keyword, Pageable pageable);
    Customer findById(String id);
    void save(Customer customer);
    void remove(String id);
    List<CustomerType> listCustomerType();
}
