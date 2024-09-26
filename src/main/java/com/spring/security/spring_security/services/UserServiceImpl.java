package com.spring.security.spring_security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.security.spring_security.entities.Role;
import com.spring.security.spring_security.entities.User;
import com.spring.security.spring_security.repositories.RoleRepository;
import com.spring.security.spring_security.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    @Transactional(readOnly = true)
    public List<User> viewAll() {
        return (List<User>) repository.findAll(); 
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> view(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        List<Role> roles = new ArrayList<> ();

        roleRepository.findByName("USER_ROLE").ifPresent(roles::add);

        if (user.isAdmin())
            roleRepository.findByName("ADMIN_ROLE").ifPresent(roles::add);
        
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }
}
