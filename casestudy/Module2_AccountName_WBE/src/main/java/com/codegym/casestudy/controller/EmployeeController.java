package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.service.employee.IEmployeeService;
import com.codegym.casestudy.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IUserService userService;

    @GetMapping({"/employee"})
    public String getAllCustomer(Model model ,
                                 @PageableDefault(value = 7)Pageable pageable,
                                 @RequestParam(defaultValue = "") String employeeName,
                                 @RequestParam(defaultValue = "") String employeeBirth,
                                 @RequestParam(defaultValue = "") String employeeIdCard,
                                 @RequestParam(defaultValue = "") String employeeEmail,
                                 @RequestParam(defaultValue = "") String employeePhone,
                                 @RequestParam(defaultValue = "") String employeeAddress){
        model.addAttribute("employee" , employeeService.searchEmployee(employeeName,employeeBirth,employeeIdCard,employeeEmail,employeePhone,employeeAddress,pageable));
        model.addAttribute("user" , userService.findAll());
        return "customer/list";
    }

}
