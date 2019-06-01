package pl.lukaszgilga.ministack.controllers.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.lukaszgilga.ministack.model.entity.PostEntity;
import pl.lukaszgilga.ministack.model.entity.UserEntity;
import pl.lukaszgilga.ministack.model.form.CommentForm;
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

    @GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable("id") int id){

        if(sessionService.getAccountType() == UserEntity.AccountType.ADMIN) {
            postService.deletePost(id);
        }
        return "redirect:/user/dashboard";
    }

    @GetMapping("/comment/delete/{postId}/{id}")
    public String deleteComment(@PathVariable("postId") int postId,
            @PathVariable("id") int id){

        if(sessionService.getAccountType() == UserEntity.AccountType.ADMIN) {
            postService.deleteComment(id);
        }
        return "redirect:/post/details/" + postId;
    }


    @GetMapping("/post/details/{id}")
    public String details(@PathVariable("id") int id,
                          Model model){
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("comments", postService.getAllCommentsByPost(id));
        model.addAttribute("commentForm", new CommentForm());
        return "post/details_post";
    }

    @PostMapping("comment/add/{postId}")
    public String addComment(@ModelAttribute CommentForm commentForm,
                             @PathVariable("postId") int postId){
        if(!sessionService.isLogin()){
            return "redirect:/user/login";
        }
        postService.addComment(commentForm, postId,sessionService.getUserId());
        return "redirect:/post/details/" + postId;

    }






}
