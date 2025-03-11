package com.example.easy_book.services;

import com.example.easy_book.common.Validation;
import com.example.easy_book.utils.RegisterRequest;
import com.example.easy_book.entities.User;
import com.example.easy_book.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final Validation validation;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(UserRepository userRepository, Validation validation) {
        this.validation = validation;
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }

    public void registerUser(RegisterRequest request) {
        validation.checkIfUsernameExists(request.getUsername());
        validation.checkIfEmailExists(request.getEmail());
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User user = implementUserDetails(request);
        userRepository.save(user);
    }

    private User implementUserDetails(RegisterRequest request) {
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setEnabled(true);
        user.setRoles("ROLE_USER");

        return user;
    }

    public User getCurrentLoggedUser()
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String principalUsername = "";
        if (principal instanceof UserDetails) {
            principalUsername = ((UserDetails) principal).getUsername();
        }
        return userRepository.findByUsername(principalUsername).orElseThrow();
    }

}
