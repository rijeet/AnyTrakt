package com.example.anytrakt;

public class User {
    String username;
    String password;
    String AccountType;

    public User() {
    }

    public User(String username, String password, String AccountType) {
        this.username = username;
        this.password = password;
        this.AccountType = AccountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String AccountType)
    {
        this.AccountType = AccountType;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", AccountType='" + AccountType + '\'' +
                '}';
    }
}
