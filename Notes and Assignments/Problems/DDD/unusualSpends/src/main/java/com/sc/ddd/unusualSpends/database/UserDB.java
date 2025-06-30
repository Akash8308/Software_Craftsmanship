package com.sc.ddd.unusualSpends.database;

import com.sc.ddd.unusualSpends.domain.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDB {
    private final List<User> users;

    public UserDB() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser( User user){
        this.users.add(user);
    }

    public User getUserById(String userId){
        User user = this.users.stream().filter(obj -> userId == obj.getId()).findFirst().get();

        if(user != null) return user;

        return null;
    }
}
