package pl.lukaszgilga.ministack.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.lukaszgilga.ministack.model.entity.PostEntity;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {

//    @Query(nativeQuery = true, value = "SELECT * FROM post ORDER BY id DESC LIMIT 10")
    Iterable<PostEntity> findTop10ByOrderByIdDesc();
    //The two above are pretty much the same, if you disable nativequery

//    @Query(nativeQuery = true, value = "SELECT * FROM post WHERE user_id = ?1")
//    List<PostEntity> findAllUserPost (int userId);
}
