package com.na.authentication.api.controllers;

import com.na.authentication.api.model.LoginRequest;
import com.na.authentication.api.model.SignUpRequest;
import com.na.authentication.api.model.UserModel;
import com.na.authentication.api.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthServices authServices;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUpUser(@RequestBody SignUpRequest signUpRequest) {
        return authServices.signUpRequest(new UserModel(
                signUpRequest.getName(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword(),
                signUpRequest.getPhone()
        ));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return authServices.loginRequest(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
    }
}
