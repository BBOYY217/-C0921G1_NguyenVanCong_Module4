package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return  employeeRepository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findId(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> searchEmployee(String employeeName, String employeeBirth, String employeeIdCard, String employeeEmail, String employeePhone, String employeeAddress, Pageable pageable) {
        return employeeRepository.searchEmployee(employeeName,employeeBirth,employeeIdCard,employeeEmail,employeePhone,employeeAddress,pageable);
    }
}
