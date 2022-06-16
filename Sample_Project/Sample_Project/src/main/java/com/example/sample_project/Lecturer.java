package com.example.sample_project;

import javafx.beans.property.StringProperty;

public class Lecturer {
    private int _id;
    private String _name;
    private String _staffId;
    private String _phone;
    private String _email;

    public Lecturer(int id, String name, String staffId) {
        _id = id;
        _name = name;
        _staffId = staffId;
    }

    public Lecturer(int id, String name, String staffId, String phone, String email) {
        _id = id;
        _name = name;
        _staffId = staffId;
        _phone = phone;
        _email = email;
    }

    public void update(String name, String staffId, String phone, String email) {
        _name = name;
        _staffId = staffId;
        _phone = phone;
        _email = email;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getId() {
        return _id;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setStaffId(String staffId) {
        _staffId = staffId;
    }

    public String getStaffId() {
        return _staffId;
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
}