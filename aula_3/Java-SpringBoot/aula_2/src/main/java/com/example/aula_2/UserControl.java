package com.example.aula_2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula_2.models.User;

import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserControl {
    private UserRepository userRepository;

    public UserControl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping(value = "user")
    public User insertUser(@RequestBody User user) {
        userRepository.insert(user);
        
        return user;
    }

    @GetMapping(value="user")
    public List<User> obtainUsers() {
        return userRepository.obtainUsers();
    }
    
    
}
