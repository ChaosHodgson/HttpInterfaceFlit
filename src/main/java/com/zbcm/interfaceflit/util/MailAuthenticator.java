package com.zbcm.interfaceflit.util;

import javax.mail.Authenticator;

/**
 * Created by ChaosWang on 2016/07/28.
 */
public class MailAuthenticator extends Authenticator {


    private String username;
    private String password;

    public MailAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
