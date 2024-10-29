package com.ama.agencybooks.service;

import com.ama.agencybooks.model.User;
import com.ama.agencybooks.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    public User getUser(String userName) {
        return userRepo.findByUserName(userName);
    }
}
