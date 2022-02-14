package com.codegym.cms.service;

import com.codegym.cms.model.Province;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    Province save(T t) throws DuplicateEmailException;
    void remove(Long id);
}
