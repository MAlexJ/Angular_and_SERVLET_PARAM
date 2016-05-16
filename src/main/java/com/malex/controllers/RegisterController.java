package com.malex.controllers;

import com.malex.controllers.base.AbstractController;
import com.malex.datasource.UserService;
import com.malex.datasource.impl.UserServiceImpl;
import com.malex.entities.Account;
import com.malex.entities.User;
import com.malex.entities.enums.Roles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends AbstractController {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (validateLoginForm(firstName, lastName, email, sex, login, password)) {
            userService.create(new User(firstName, lastName, email, sex, new Account(login, password, Roles.USER)));
            resp.getWriter().print("STATUS_OK");
        }
    }

}
