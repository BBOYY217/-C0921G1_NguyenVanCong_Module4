package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ComputerController {
    @GetMapping(value = "/")
    public String computer() {
        return "calculator";
    }

    @PostMapping("/computer")
    public String calculator(@RequestParam(name = "firstNumber") Integer firstNumber,
                             @RequestParam(name = "secondNumber") Integer secondNumber,
                             @RequestParam(name = "calculate") String calculate,
                             Model model) {
        int result = 0;
        switch (calculate) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
//
                    result = firstNumber * secondNumber;
                break;
            case "/":
                if (firstNumber == 0||secondNumber == 0) {
                    result = 0;

                } else {
                    result = firstNumber / secondNumber;
                }
                break;
        }
        model.addAttribute("result",result);
        return "/calculator";
    }
}

