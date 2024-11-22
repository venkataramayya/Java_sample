package com.project.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.task.employee.User;
import com.project.task.repository.RoleRepository;
import com.project.task.repository.UserRepository;

@Service // Marks this class as a service component for dependency injection
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository; // Injects the UserRepo for accessing user data

    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieves user details by username from the database
        return userRepository.findByUsername(username);
    }

    public String create(String username, String password) {
        // Encodes the password and creates a new User object
        User user = User.builder()
                .username(username)
                .password(password)
                //.password(new BCryptPasswordEncoder().encode(password)) // Encrypts the password
                .role(roleRepository.getById(1l)) // Assigns default authority
                .build();
        
        // Saves the new user to the database
        userRepository.save(user);
        
        return "Create Successfully !"; // Returns a success message
    }
}