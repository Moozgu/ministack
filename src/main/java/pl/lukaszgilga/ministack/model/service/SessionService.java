package pl.lukaszgilga.ministack.model.service;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionService {
    private int userId;
    private boolean isLogin;
    private String nickname;
    private boolean isAdmin;


    public void logoutClean(){
        this.userId = 0;
        this.isLogin = false;
        this.nickname = null;
        this.isAdmin = false;
    }
}
