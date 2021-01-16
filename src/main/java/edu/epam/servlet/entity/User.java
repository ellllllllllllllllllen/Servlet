package edu.epam.servlet.entity;

public class User {

    private String login;
    private String firstname;
    private String lastname;
    private String email;

    public User(){}

    public User(String login, String firstname, String lastname, String email) {

        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
