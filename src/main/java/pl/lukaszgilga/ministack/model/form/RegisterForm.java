package pl.lukaszgilga.ministack.model.form;


import lombok.Data;

@Data
public class RegisterForm {

    private String email;
    private String password;
    private String nickname;

}
