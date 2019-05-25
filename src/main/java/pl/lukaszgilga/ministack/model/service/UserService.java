package pl.lukaszgilga.ministack.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lukaszgilga.ministack.model.entity.UserEntity;
import pl.lukaszgilga.ministack.model.form.LoginForm;
import pl.lukaszgilga.ministack.model.form.RegisterForm;
import pl.lukaszgilga.ministack.model.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

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

        //hashing the password to prevent accidental userbase leak
        String passwordHash = getBCrypt().encode(registerForm.getPassword());
        registerForm.setPassword(passwordHash);

        UserEntity newUser = new UserEntity(registerForm);
        userRepository.save(newUser);
        return true;

    }
    public boolean loginUser(LoginForm loginForm){
        Optional<UserEntity> user = userRepository.findByEmail(loginForm.getEmail());
        if(!user.isPresent()){
            return false;
        }

        return getBCrypt().matches(loginForm.getPassword(),user.get().getPassword());

    }
    @Bean
    public BCryptPasswordEncoder getBCrypt(){
        return new BCryptPasswordEncoder();
    }
}
