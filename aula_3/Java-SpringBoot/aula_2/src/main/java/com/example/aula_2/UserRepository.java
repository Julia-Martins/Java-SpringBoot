package com.example.aula_2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.aula_2.models.User;

@Repository
public class UserRepository{
    private List<User> users = new ArrayList<>();

    public Boolean insert(User user){
        users.add(user);
        return true;
    }

    public List<User> obtainUsers(){
        return users;
    }
}
