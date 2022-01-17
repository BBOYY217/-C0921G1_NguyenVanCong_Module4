package com.codegym.controller;

import com.codegym.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/email")
public class EmailController {

    @GetMapping("")
    public String showEmail (Model model) {
        model.addAttribute("email",new Email());
        return "home";
    }

    @PostMapping("/update")
    public ModelAndView update (@ModelAttribute Email email) {
            return new ModelAndView("show","email",email);
    }
}