package com.danielsilvalima.workshopmongo.repository;

import com.danielsilvalima.workshopmongo.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
