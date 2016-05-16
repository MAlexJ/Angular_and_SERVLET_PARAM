package com.malex.datasource;

import com.malex.entities.Account;
import com.malex.entities.User;

import java.util.List;

public interface UserService {

    boolean create(User user);

    Account findAccount(String name, String password);

    User findOne(Account account);

    List<User> findAll();
}
