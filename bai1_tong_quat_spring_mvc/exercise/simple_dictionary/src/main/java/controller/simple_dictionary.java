package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class simple_dictionary {
    @GetMapping("/translate")
    public String translate () {
        return "/translate";
    }

    @PostMapping ("/translate")
    public String translateWord (@RequestParam(name = "wordSearch") String word, Model model) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chao");
        dictionary.put("red", "Mau do");
        dictionary.put("car", "Xe o to");
        dictionary.put("blue", "Mau xanh nuoc");
        String result = dictionary.get(word);
        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Not found");
        }
        return "/translate";
    }
}
