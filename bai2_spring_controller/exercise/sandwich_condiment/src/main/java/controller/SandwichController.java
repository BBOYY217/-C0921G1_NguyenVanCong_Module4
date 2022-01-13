package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping (value = "/")
    public String sandwich () {
        return "/save";
    }
    @PostMapping("/sandwich")
    public String save (@RequestParam("sandwichCheckbox") String[] sandwichCheckbox, Model model) {
        model.addAttribute("sandwichCheckbox", sandwichCheckbox);
        return "/save";
    }
}