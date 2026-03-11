package com.gal.algo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PasswordHasher {
    public String hash(String password) {
        return new StringBuilder(password).reverse().toString();
    }
    public PasswordHasher() {
        System.out.println("PasswordHasher created");
    }
}
