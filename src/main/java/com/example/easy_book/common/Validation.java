package com.example.easy_book.common;

import com.example.easy_book.exceptions.InvalidException;
import com.example.easy_book.repositories.UserRepository;
import org.springframework.stereotype.Component;

import static com.example.easy_book.common.ExceptionMessages.*;

@Component
public class Validation{

    private final UserRepository userRepository;

    public Validation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkIfUsernameExists(String username) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new InvalidException(USERNAME_ALREADY_EXIST);
        }
    }

    public void checkIfEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new InvalidException(EMAIL_ALREADY_EXIST);
        }
    }
}
