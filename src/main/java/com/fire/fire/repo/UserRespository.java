package com.fire.fire.repo;

import com.fire.fire.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRespository extends MongoRepository<User, String> {
    User findByEmail(String emial);


}
