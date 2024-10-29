package com.ama.agencybooks.controller;

import com.ama.agencybooks.model.User;
import com.ama.agencybooks.repository.UserRepository;
import com.ama.agencybooks.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsersController {

    private UserService userService;
    private UserRepository userRepo;

    public UsersController(UserService userService, UserRepository userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public User getUser(@RequestParam String username) {
        return userService.getUser(username);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User newUser) {
        return userRepo.save(newUser);
    }

}
