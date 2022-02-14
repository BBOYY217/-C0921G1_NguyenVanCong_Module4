package com.codegym.cms.controller;

import com.codegym.cms.model.Blog;
import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String index(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogs", blogList);
        return "/blog/index";
    }
    @GetMapping("/create")
    public String create (Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blogObj, RedirectAttributes redirectAttributes) {
        blogService.save(blogObj);
        redirectAttributes.addFlashAttribute("successMS",
                "Create blog: " + blogObj.getTitle() + " OK!");
        return "redirect:/blog";//chuyển hướng không kèm data
        //        return "forward:/student/list"; //chuyển hướng kèm data

    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable long id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "/blog/edit";
    }

    @PostMapping ("/edit")
    public String update (@ModelAttribute Blog blogObj, RedirectAttributes redirectAttributes) {
        blogService.update(blogObj);
        redirectAttributes.addFlashAttribute("message", "The blog was successful updated.");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete (@PathVariable long id,RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "The blog was successful deleted.");
        return "redirect:/blog";
    }
}
