package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.EmployeeDto;
import com.codegym.casestudy.model.employee.Division;
import com.codegym.casestudy.model.employee.EducationDegree;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.model.employee.Position;
import com.codegym.casestudy.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @ModelAttribute("position")
    public List<Position> positionList() {
        return employeeService.listPosition();
    }

    @ModelAttribute("education")
    public List<EducationDegree> educationDegreeList() {
        return employeeService.listEducationDegree();
    }

    @ModelAttribute("division")
    public List<Division> divisionList() {
        return employeeService.listDivision();
    }

    @GetMapping("" )
    public ModelAndView list(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                             @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0),10);
        Page<Employee> employees =employeeService.findAll(keyword,pageable);
        ModelAndView modelAndView = new ModelAndView("employee/list","employees",employees);
        modelAndView.addObject("keyword",keyword);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("employee/create",
                "employeeDto",new EmployeeDto());
        return modelAndView;
    }


    @PostMapping(value = "/create")
    public String createEmployee(@ModelAttribute @Valid EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setFlag(true);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","create successfully");
        return "redirect:/employee/";
    }


    @GetMapping(value = "/edit")
    public String showEdit(@RequestParam int id, Model model){
        Employee employee = this.employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "employee/edit";
    }

    @PostMapping(value = "/edit")
    public String editEmployee(@ModelAttribute @Valid EmployeeDto employeeDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new EmployeeDto().validate(employeeDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        employee.setFlag(true);
        this.employeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","edit successfully");
        return "redirect:/employee/";
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam int id,RedirectAttributes redirectAttributes ){
        employeeService.remove(id);
        redirectAttributes.addFlashAttribute("msg","successful delete");
        return  "redirect:/employee";
    }


}
