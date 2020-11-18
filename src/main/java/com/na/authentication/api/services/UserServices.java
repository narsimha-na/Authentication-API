package com.na.authentication.api.services;

import com.na.authentication.api.dao.AuthDao;
import com.na.authentication.api.dao.AuthRepository;
import com.na.authentication.api.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    private AuthDao authRepo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserModel userDetails = authRepo.getUserDetailsByEmail(s);
        return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
    }
}
