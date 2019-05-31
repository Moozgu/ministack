package pl.lukaszgilga.ministack.controllers.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.lukaszgilga.ministack.model.entity.PostEntity;
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
                   RedirectAttributes redirectAttributes){
        postService.addPost(postForm);

        redirectAttributes.addFlashAttribute("info","Added new post");
        return "redirect:/user/dashboard";
    }
    @RequestMapping(value = "user/delete/{id}")
    private String deletePost(@PathVariable(name = "id") String id){
        System.out.println("Post_ID  : "+id);
        PostEntity post = new PostEntity();
        post.setId(Integer.parseInt(id));
        postService.deletePost(post);
        return "redirect:/user/dashboard";
    }


}
