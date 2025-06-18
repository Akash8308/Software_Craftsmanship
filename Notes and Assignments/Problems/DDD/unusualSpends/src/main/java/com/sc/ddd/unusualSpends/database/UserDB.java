package com.sc.ddd.unusualSpends.database;

import com.sc.ddd.unusualSpends.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private final List<User> users;

    public UserDB(List<User> users) {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    public void addUser( User user){
        this.users.add(user);
    }
}
