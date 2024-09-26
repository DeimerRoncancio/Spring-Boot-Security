package com.spring.security.spring_security.services;

import java.util.List;
import java.util.Optional;

import com.spring.security.spring_security.entities.User;

public interface UserService  {

    List<User> viewAll();

    Optional<User> view(Long id);
    
    User save(User user);
}
