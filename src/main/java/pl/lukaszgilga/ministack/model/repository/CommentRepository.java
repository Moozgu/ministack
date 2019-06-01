package pl.lukaszgilga.ministack.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszgilga.ministack.model.entity.CommentEntity;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {

    @Query(nativeQuery = true, name = "SELECT * FROM comment WHERE post_id =?1")
    List<CommentEntity> findCommentsByPostId(int postId);

}
