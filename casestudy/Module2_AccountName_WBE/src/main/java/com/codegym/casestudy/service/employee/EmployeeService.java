package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.repository.employee.IDivisionRepository;
import com.codegym.casestudy.repository.employee.IEducationDegreeRepository;
import com.codegym.casestudy.repository.employee.IEmployeeRepository;
import com.codegym.casestudy.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private IDivisionRepository divisionRepository;

    @Autowired
    private IEducationDegreeRepository educationDegreeRepository;

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public Page<Employee> findAll(String keyword, Pageable pageable) {
        return employeeRepository.findAllByKeyWord(keyword,pageable);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        Employee employee = this.findById(id);
        employee.setFlag(false);
        save(employee);
    }

    @Override
    public List<Division> listDivision() {
        return divisionRepository.findAll();
    }

    @Override
    public List<Position> listPosition() {
        return positionRepository.findAll();
    }

    @Override
    public List<EducationDegree> listEducationDegree() {
        return educationDegreeRepository.findAll();
    }
}
