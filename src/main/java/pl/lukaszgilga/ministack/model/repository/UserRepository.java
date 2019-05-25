package pl.lukaszgilga.ministack.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukaszgilga.ministack.model.entity.UserEntity;

import java.util.Optional;

//Interface responsible for implementing C(reate)R(ead)U(pdate)D(elete) methods to allow operations on databases.
//Needs to be set on what we want it to work with, here User Entity
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email); //query searching by method's name
    boolean existsByEmail(String email);
}
