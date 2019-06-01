package pl.lukaszgilga.ministack.model.service;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.lukaszgilga.ministack.model.entity.UserEntity;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionService {
    private int userId;
    private boolean isLogin;
    private String nickname;
    private UserEntity.AccountType accountType;


    public void logoutClean(){
        this.userId = 0;
        this.isLogin = false;
        this.nickname = null;
    }
}