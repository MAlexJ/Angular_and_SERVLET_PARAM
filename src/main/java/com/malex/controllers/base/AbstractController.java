package com.malex.controllers.base;

import javax.servlet.http.HttpServlet;

public class AbstractController extends HttpServlet {

    protected boolean validateLoginForm(String username, String password) {
        return !username.equals("")
                && !password.equals("")
                && username.length() <= 20;
    }

    protected boolean validateLoginForm(String firstName, String lastName, String email, String sex, String login, String password) {
        return !firstName.equals("")
                && !lastName.equals("")
                && !email.equals("")
                && !sex.equals("")
                && !login.equals("")
                && !password.equals("")
                && firstName.length() <= 20
                && lastName.length() <= 20
                && email.length() <= 30
                && sex.length() <= 6
                && login.length() <= 20
                && password.length() <= 20;
    }
}
