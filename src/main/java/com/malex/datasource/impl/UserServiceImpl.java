package com.malex.datasource.impl;

import com.malex.datasource.UserService;
import com.malex.entities.Account;
import com.malex.entities.User;
import com.malex.entities.enums.Roles;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private static List<User> userList;

    static {
        userList = new ArrayList<>();
        userList.add(
                new User("LNAdmin","FNAdmin","male","admin@admin.com",
                        new Account("admin", "12345", Roles.ADMIN)));
    }

    @Override
    public boolean create(User user) {
        return userList.add(user);
    }

    @Override
    public Account findAccount(String name, String password){
        for (User user: userList ){
            if(user.getAccount().equals(new Account(name, password))){
                return user.getAccount();
            }
        }
        return null;
    }


    @Override
    public User findOne(Account account) {
        for (User user: userList ){
            if(user.getAccount().equals(account)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userList;
    }
}
