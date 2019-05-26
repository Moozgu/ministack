package pl.lukaszgilga.ministack.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.lukaszgilga.ministack.model.service.PostService;
import pl.lukaszgilga.ministack.model.service.SessionService;
import pl.lukaszgilga.ministack.model.service.UserService;

@Controller
public class DashboardController {

    @Autowired
    SessionService sessionService;
    @Autowired
    UserService userService;
    @Autowired
    PostService postService;

    @GetMapping("/user/dashboard")
    public String dashboard(Model model){
        if(!sessionService.isLogin()){
            return "redirect:/user/login";
        }
        model.addAttribute("posts",postService.getAllPosts());
        return "user/dashboard";
    }
}
