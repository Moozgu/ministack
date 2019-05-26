package pl.lukaszgilga.ministack.controllers.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lukaszgilga.ministack.model.form.PostForm;
import pl.lukaszgilga.ministack.model.service.PostService;
import pl.lukaszgilga.ministack.model.service.SessionService;

@Controller
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    SessionService sessionService;

    @GetMapping("/post/add")
    String addPost(Model model){
        if(!sessionService.isLogin()){
            return "redirect:/user/login";
        }
        model.addAttribute("postForm", new PostForm());
        return "post/add_post";

    }

    @PostMapping("post/add")
    String addPost(@ModelAttribute PostForm postForm,
                   Model model){
        postService.addPost(postForm);
        return "redirect:/user/dashboard";
    }

}
