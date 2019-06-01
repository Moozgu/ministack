package pl.lukaszgilga.ministack.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszgilga.ministack.model.entity.CommentEntity;
import pl.lukaszgilga.ministack.model.entity.PostEntity;
import pl.lukaszgilga.ministack.model.entity.UserEntity;
import pl.lukaszgilga.ministack.model.form.CommentForm;
import pl.lukaszgilga.ministack.model.form.PostForm;
import pl.lukaszgilga.ministack.model.repository.CommentRepository;
import pl.lukaszgilga.ministack.model.repository.PostRepository;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    SessionService sessionService;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;



    public void addPost(PostForm postForm) {
        PostEntity post = new PostEntity();
        post.setTitle(postForm.getTitle());
        post.setContent(postForm.getContent());
        UserEntity user = new UserEntity();
        user.setId(sessionService.getUserId());
        post.setUser(user);

        postRepository.save(post);

    }
    public void deletePost(int id){
        postRepository.deleteById(id);
    }
    public Iterable<PostEntity> getAllPosts(){
        return postRepository.findTop10ByOrderByIdDesc();
    }

    public PostEntity getPostById(int id){
        return postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void addComment(CommentForm commentForm, int postId, int userId) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postId);

        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setAuthor(userEntity);
        commentEntity.setPost(postEntity);
        commentEntity.setComment(commentForm.getComment());

        commentRepository.save(commentEntity);
    }

    public Object getAllCommentsByPost(int id) {
        return commentRepository.findCommentsByPostId(id);
    }
}
