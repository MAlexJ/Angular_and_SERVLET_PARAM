package com.malex.controllers;

import com.malex.controllers.base.AbstractController;
import com.malex.datasource.UserService;
import com.malex.datasource.impl.UserServiceImpl;
import com.malex.entities.Account;
import com.malex.entities.enums.Roles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginController extends AbstractController {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (validateLoginForm(username, password)) {

            Account account = userService.findAccount(username, password);
            if (account != null) {

                if (account.getRole().equals(Roles.ADMIN)) {
                    resp.getWriter().print("ADMIN");
                    resp.flushBuffer();
                }
                if (account.getRole().equals(Roles.USER)) {
                    resp.getWriter().print("USER");
                    resp.flushBuffer();
                }

            } else {
                resp.getWriter().print("Not Account!!!");
                resp.flushBuffer();
            }
        }
    }
}
