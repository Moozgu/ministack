package pl.lukaszgilga.ministack.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszgilga.ministack.model.entity.CommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {

}
