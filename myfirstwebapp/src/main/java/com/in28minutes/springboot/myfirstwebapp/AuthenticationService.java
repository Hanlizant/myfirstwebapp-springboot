package com.in28minutes.springboot.myfirstwebapp;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String usearname,  String password){
        boolean isValidUsername= usearname.equalsIgnoreCase("hanna");
        boolean isValidPassword= password.equalsIgnoreCase("123");
        return  isValidUsername && isValidPassword;
    }
}
