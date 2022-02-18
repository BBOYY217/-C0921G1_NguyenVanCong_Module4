package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService  {
    Page<Employee> findAll(Pageable pageable);
    Optional<Employee> findId(int id);
    Employee save (Employee Employee);
    void remove(int id);

    Page<Employee> searchEmployee(String employeeName, String employeeBirth, String employeeIdCard, String employeeEmail, String employeePhone, String employeeAddress, Pageable pageable);
}
