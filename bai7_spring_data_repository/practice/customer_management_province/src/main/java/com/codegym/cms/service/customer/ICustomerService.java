package com.codegym.cms.service.customer;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.IGeneralService;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    void save(Customer customer);

    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);

}
