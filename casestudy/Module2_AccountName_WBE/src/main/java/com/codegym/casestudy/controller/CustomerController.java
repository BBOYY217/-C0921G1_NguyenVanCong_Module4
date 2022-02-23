package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.CustomerDto;
import com.codegym.casestudy.dto.EmployeeDto;
import com.codegym.casestudy.model.customer.Customer;
import com.codegym.casestudy.model.customer.CustomerType;
import com.codegym.casestudy.model.employee.Employee;
import com.codegym.casestudy.service.customer.ICustomerService;
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
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customerType")
    private List<CustomerType> customerTypeList(){
        return customerService.listCustomerType();
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                             @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0),10);
        Page<Customer> customers =customerService.findAll(keyword,pageable);
        ModelAndView modelAndView = new ModelAndView("customer/list","customers",customers);
        modelAndView.addObject("keyword",keyword);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("customer/create",
                "customerDto",new CustomerDto());
        return modelAndView;
    }

    @PostMapping(value = "/create")
    public String createCustomer(@ModelAttribute @Valid CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customer.setFlag(true);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","create successfully");
        return "redirect:/customer/";
    }

    @GetMapping(value = "/edit")
    public String showEdit(@RequestParam String id, Model model){
        Customer customer = this.customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/edit";
    }

    @PostMapping(value = "/edit")
    public String editCustomer(@ModelAttribute @Valid CustomerDto customerDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        customer.setFlag(true);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","create successfully");
        return "redirect:/customer/";
    }


    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam String id, RedirectAttributes redirectAttributes ){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("msg","successful delete");
        return  "redirect:/customer";
    }

}
