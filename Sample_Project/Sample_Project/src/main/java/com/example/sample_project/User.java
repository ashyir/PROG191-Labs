package com.example.sample_project;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    private int _id;
    private String _username;
    private String _password;
    private String _name;
    private String _phone;
    private String _email;
    private String _number;
    private Role _role;

    public User() throws NoSuchAlgorithmException {
        setInfo(-1, "", "", "", "", "", "", Role.NONE);
    }

    public User(int id, String username, String password, Role role) throws NoSuchAlgorithmException {
        setInfo(id, username, password, "", "", "", "", role);
    }

    public User(int id, String username, String password, String name, String phone, String email, String number, Role role) throws NoSuchAlgorithmException {
        setInfo(id, username, password, name, phone, email, number, role);
    }

    private void setInfo(int id, String username, String password, String name, String phone, String email, String number, Role role) throws NoSuchAlgorithmException {
        _id = id;
        _username = username;
        _password = hashString(password);
        _name = name;
        _phone = phone;
        _email = email;
        _number = number;
        _role = role;
    }

    public void update(String name, String phone, String email, String number, Role role) {
        _name = name;
        _phone = phone;
        _email = email;
        _number = number;
        _role = role;
    }

    private String hashString(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(text.getBytes());
        return new String(messageDigest.digest());
    }

    public boolean matchPassword(String password) throws NoSuchAlgorithmException {
        if (_password.equals(hashString(password)))
            return true;

        return false;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getId() {
        return _id;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public String getUsername() {
        return _username;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        _password = hashString(password);
    }

    public String getPassword() {
        return _password;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setPhone(String phone) {
        _phone = phone;
    }

    public String getPhone() {
        return _phone;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getEmail() {
        return _email;
    }

    public void setNumber(String number) {
        _number = number;
    }

    public String getNumber() {
        return _number;
    }

    public void setRole(Role role) {
        _role = role;
    }

    public Role getRole() {
        return _role;
    }

    public String toString() {
        return _username;
    }
}