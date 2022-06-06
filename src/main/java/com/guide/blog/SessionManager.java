package com.guide.blog;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SessionManager {

    public static final String COOKIE_ID = "COOKIE_ID";

    public void createSession() {
        String uuid = UUID.randomUUID().toString();

    }

}
