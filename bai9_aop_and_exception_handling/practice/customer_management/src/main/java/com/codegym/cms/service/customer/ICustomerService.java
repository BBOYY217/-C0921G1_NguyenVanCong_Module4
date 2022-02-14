package com.codegym.cms.service.customer;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import com.codegym.cms.service.DuplicateEmailException;
import com.codegym.cms.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService extends IGeneralService<Customer> {
    Province save(Customer customer) throws DuplicateEmailException;

    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);

    Page<Customer> findAll(Pageable pageInfo) throws Exception;

    Optional<Customer> findOne(Long id) throws Exception;
}

