package pl.lukaszgilga.ministack.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lukaszgilga.ministack.model.service.SessionService;
import pl.lukaszgilga.ministack.model.service.UserService;

@Controller
public class DashboardController {

    @Autowired
    SessionService sessionService;
    @Autowired
    UserService userService;

    @GetMapping("/user/dashboard")
    public String dashboard(){
        if(!sessionService.isLogin()){
            return "redirect:/user/login";
        }
        return "user/dashboard";
    }
}
