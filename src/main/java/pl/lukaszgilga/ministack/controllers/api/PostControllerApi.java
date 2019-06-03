package pl.lukaszgilga.ministack.controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszgilga.ministack.model.dto.PostDto;
import pl.lukaszgilga.ministack.model.entity.PostEntity;
import pl.lukaszgilga.ministack.model.repository.UserRepository;
import pl.lukaszgilga.ministack.model.service.PostService;
import pl.lukaszgilga.ministack.model.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostControllerApi {

    @Autowired
    PostService postService;
    @Autowired
    UserService userService;

    private final String API_KEY = "asffdfadskjfskjdfnjlaenf32hre23unrurfwfehfw73n2fs";

    @GetMapping("/post")
    public ResponseEntity getAllPosts(){
        return ResponseEntity.ok(
                postService.getAllPosts()
        );
    }
    @GetMapping("/post/{id}")
    public ResponseEntity getOnePost(@PathVariable("id") int id){
        Optional<PostEntity> post = postService.getPostOptional(id);
        if(!post.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post with this id does not exist");

        }
        return ResponseEntity.ok(post);
    }
    @PostMapping(value = "/post", consumes = "application/json")
    public ResponseEntity savePost(@RequestBody PostDto postDto,
                                    @RequestHeader("api-key") String key){
        if(!key.equals(API_KEY)){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if(!userService.userIdCheck(postDto.getUserId())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User with this id does not exist");
        }
        return ResponseEntity.ok(
                postService.addPostDto(postDto)
        );

    }

}
