package com.na.authentication.api.dao;

import com.na.authentication.api.model.UserModel;
import com.na.authentication.api.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AuthDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    Query query = new Query();
    @Autowired
    private AuthenticationManager authenticationManager;

    public ResponseEntity<?> userSignUp(UserModel user) {
        try{
            mongoTemplate.save(user);
        }catch (Exception e){
            return ResponseEntity.ok(new UserResponse(false,"Their is an error in inserting user"));
        }
        return ResponseEntity.ok(new UserResponse(false,"User inserted successfully"));
    }

    public ResponseEntity<?> userLogin(String username, String password) {
//        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    username,
                    password
            ));
//        }catch (Exception e){
//            return ResponseEntity.ok(new UserResponse(true,"Something went wrong"+e.getMessage()));
//        }
        return ResponseEntity.ok(new UserResponse(false,"User login successfully"));
    }

    public UserModel getUserDetailsByEmail(String email){
        query = new Query();
        query.addCriteria(Criteria.where("email").is(email));
        if(mongoTemplate.findOne(query, UserModel.class) != null){
            return mongoTemplate.findOne(query, UserModel.class);
        }
        return null;
    }

}
