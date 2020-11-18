package com.na.authentication.api.services;

import com.na.authentication.api.dao.AuthDao;
import com.na.authentication.api.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {

    @Autowired
    private AuthDao authDao;

    public ResponseEntity<?> signUpRequest(UserModel user) {
       return authDao.userSignUp(user);
    }

    public ResponseEntity<?> loginRequest(String username, String password) {
        return authDao.userLogin(username,password);
    }
}
