package org.example;

public class User {


    private String login;
    private String email;

    public User() {
    }

    public User(String login, String email) throws LoginMatchesEmailException, BadEmailException {
        if (login.equals(email)) {
            throw new LoginMatchesEmailException("Login and email must not match!");
        }

        if (!email.contains("@") || !email.contains(".")) {
            throw new BadEmailException("Email must contain all necessary characters!");
        }

        this.login = login;
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


