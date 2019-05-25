package pl.lukaszgilga.ministack.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lukaszgilga.ministack.models.RegisterForm;

@Controller
public class AuthController {

    @GetMapping("/user/register")
    public String register(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "register_form";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute RegisterForm registerForm,
                            BindingResult bindingResult,
                            Model model){
        if (bindingResult.hasErrors()) {
                model.addAttribute("error", "Zle dane");
                return "register_form";
        }
        model.addAttribute("test", true);
                return "register_form";
        }

}
