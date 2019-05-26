package pl.lukaszgilga.ministack.model.repository;

import org.springframework.data.repository.CrudRepository;
import pl.lukaszgilga.ministack.model.entity.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {
    Iterable<PostEntity> findTop10ByOrderByIdDesc();
}
