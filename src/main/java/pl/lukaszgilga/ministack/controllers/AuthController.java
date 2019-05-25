package pl.lukaszgilga.ministack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lukaszgilga.ministack.model.form.RegisterForm;

@Controller
public class AuthController {

    @GetMapping("/user/register")
    public String register(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "user/register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute RegisterForm registerForm,
                            Model model){
        System.out.println(registerForm);
                return "user/register";

        }

}
