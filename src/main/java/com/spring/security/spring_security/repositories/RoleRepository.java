package com.spring.security.spring_security.repositories;

import org.springframework.data.repository.CrudRepository;
import com.spring.security.spring_security.entities.Role;
import java.util.Optional;
// import java.util.List;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Optional<Role> findByName(String name);;
}
