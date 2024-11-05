package com.ama.agencybooks.service;

import com.ama.agencybooks.model.SecurityLevel;
import com.ama.agencybooks.model.User;
import com.ama.agencybooks.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookSearchService {

    private UserRepository userRepository;

    //Normally I would autowire user repo instead of setting through constructor
    public BookSearchService(UserRepository userRepository) {this.userRepository = userRepository;}

    // Created this service and method to separate UserRepository from BookService
    // and give book service only what it needs from user
    public Optional<SecurityLevel> getUserClearance(long userId) {
        Optional<User> user = userRepository.findById(userId);

        return user.map(User::getClearance);
    }

}
