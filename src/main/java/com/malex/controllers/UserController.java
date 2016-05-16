package com.malex.controllers;

import com.malex.controllers.base.AbstractController;
import com.malex.datasource.UserService;
import com.malex.datasource.impl.UserServiceImpl;
import com.malex.entities.Account;
import com.malex.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends AbstractController {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (validateLoginForm(username, password)) {

            User user = userService.findOne(new Account(username, password));

            if (user != null) {
                resp.getWriter().print(user.getFirstName() + " " + user.getLastName());
                resp.flushBuffer();

            }
        }

    }
}
