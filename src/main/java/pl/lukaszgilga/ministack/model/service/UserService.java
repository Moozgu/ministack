package pl.lukaszgilga.ministack.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszgilga.ministack.model.entity.UserEntity;
import pl.lukaszgilga.ministack.model.form.RegisterForm;
import pl.lukaszgilga.ministack.model.repository.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    //Transactional joins everything below into a single indivisible method.
    //Doesn't allow the process to finish if a single part fails.
    //@Transactional

    public boolean registerUser(RegisterForm registerForm){
        //checking email to see if it's unique(without the use of Transactional)
        if(userRepository.existsByEmail(registerForm.getEmail())){
            return false;
        }
        else{
            UserEntity newUser = new UserEntity(registerForm);
            userRepository.save(newUser);
            return true;

        }
    }
}
