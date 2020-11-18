package com.na.authentication.api.dao;

import com.na.authentication.api.model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepository  extends MongoRepository<UserModel, Integer> {

}
