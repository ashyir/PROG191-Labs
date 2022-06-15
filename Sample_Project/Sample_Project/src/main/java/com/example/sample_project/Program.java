package com.example.sample_project;

public class Program {
    private int _id;
    private String _name;

    public Program(int id, String name) {
        _id = id;
        _name = name;
    }

    public void update(String name) {
        _name = name;
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
}