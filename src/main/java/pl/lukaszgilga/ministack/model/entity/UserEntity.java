package pl.lukaszgilga.ministack.model.entity;

import lombok.Data;
import pl.lukaszgilga.ministack.model.form.RegisterForm;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    public enum AccountType{
        ADMIN,
        MODERATOR,
        USER;
    }

    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String nickname;
    //@Column(name = "Password_user") --- Przypisanie nazwy kolumny do zmiennej
    private String password;

    @Column(name ="account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;


    public UserEntity(){}

    public UserEntity(RegisterForm registerForm){
        this.email = registerForm.getEmail();
        this.nickname = registerForm.getNickname();
        this.password =registerForm.getPassword();
    }
}
