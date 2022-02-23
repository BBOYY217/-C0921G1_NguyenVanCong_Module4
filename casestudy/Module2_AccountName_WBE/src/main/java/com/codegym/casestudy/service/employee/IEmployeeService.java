package com.codegym.casestudy.service.employee;

import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
   Page<Employee> findAll(String keyword, Pageable pageable);
   Employee findById(int id);
   void save(Employee employee);
   void remove(int id);
   List<Division> listDivision();
   List<Position> listPosition();
   List<EducationDegree> listEducationDegree();
}
