package com.spring.security.spring_security.repositories;

import org.springframework.data.repository.CrudRepository;
import com.spring.security.spring_security.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
