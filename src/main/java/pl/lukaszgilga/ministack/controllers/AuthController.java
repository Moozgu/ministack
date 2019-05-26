package pl.lukaszgilga.ministack.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lukaszgilga.ministack.model.form.LoginForm;
import pl.lukaszgilga.ministack.model.form.RegisterForm;
import pl.lukaszgilga.ministack.model.service.UserService;

import javax.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/user/register")
    public String register(Model model){
        model.addAttribute("registerForm", new RegisterForm());
        return "user/register";
    }

    @PostMapping("/user/register")
    public String register(@ModelAttribute("registerForm") @Valid RegisterForm registerForm,
                            BindingResult bindingResult,
                            Model model){
        if (bindingResult.hasErrors()){
            return "user/register";
        }
        boolean isRegistered = userService.registerUser(registerForm);
        if(isRegistered){
            return "redirect:/user/login";
        }
        model.addAttribute("isRegistered",isRegistered);

        registerForm.setPassword("");
        registerForm.setEmail("");
        registerForm.setNickname("");
        return "user/register";

    }

    @GetMapping("/user/login")
    public String login(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "user/login";
    }
    @PostMapping("/user/login")
    public String login(@ModelAttribute LoginForm loginForm,
                        Model model){
        if(userService.loginUser(loginForm)){
            return "redirect:/user/dashboard";
        }
        model.addAttribute("isLogged",false);
        return "user/login";
    }

}
