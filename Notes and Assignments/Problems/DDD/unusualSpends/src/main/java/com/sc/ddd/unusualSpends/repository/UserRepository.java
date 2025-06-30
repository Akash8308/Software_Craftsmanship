package com.sc.ddd.unusualSpends.repository;

import com.sc.ddd.unusualSpends.database.UserDB;
import com.sc.ddd.unusualSpends.domain.entity.User;

import java.util.Optional;

public class UserRepository {

    UserDB users = new UserDB();

    public UserRepository(UserDB userDB){
        this.users = userDB;
    }

    public void addUser(User user){
        this.users.addUser(user);
    }

    public String getUserNameById(String id){
       String userName = this.users.getUserById(id).getName();

       return userName;
    }

    public String getUserContactById(String id){
       String userContact = this.users.getUserById(id).getEmail();

       return userContact;
    }

}
