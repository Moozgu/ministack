package pl.lukaszgilga.ministack.models;


import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class RegisterForm {

    private String email;
    @Min(8)
    private String password;
    @Min(3)
    private String nickname;

}
