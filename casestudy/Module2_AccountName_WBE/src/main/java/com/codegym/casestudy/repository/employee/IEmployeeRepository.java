package com.codegym.casestudy.repository.employee;

import com.codegym.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "SELECT * FROM  employee where employee_name like concat('%',:EmployeeName,'%') " +
            " and  employee_birth like concat('%',:employeeBirth,'%') " +
            " and  employe_id_card like concat('%',:employeeIdCard,'%') " +
            " and  employee_email like concat('%',:employeeEmail,'%') " +
            " and  employee_phone like concat('%',:employeePhone,'%') " +
            " and employee_address like concat('%',:employeeAddress,'%')", nativeQuery = true)
    Page<Employee> searchEmployee(@Param("EmployeeName") String customerName,
                                  @Param("employeeBirth") String employeeBirth,
                                  @Param("employeeIdCard") String employeeIdCard,
                                  @Param("employeeEmail") String employeeEmail,
                                  @Param("employeePhone") String employeePhone,
                                  @Param("employeeAddress") String employeeAddress,
                                  Pageable pageable);

    Page<Employee> searchEmployee(Pageable pageable);
}
