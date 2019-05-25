package pl.lukaszgilga.ministack.model.form;


import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class RegisterForm {

    @Pattern(regexp = ".+@.+\\..{2,5}", message = "Incorrect email address")
    private String email;
    @Size (min = 6, max = 30, message = "Password needs to be between 6 and 30 characters long")
    private String password;
    @Pattern(regexp = ".{5,30}", message = "Nickname needs to be between 5 and 30 characters long")
    private String nickname;



}
