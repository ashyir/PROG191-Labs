package com.example.sample_project;

public class Course {
    private int _id;
    private String _code;
    private String _name;
    private int _hour;
    private int _credit;
    private int _programId;

    public Course() {
        setInfo(-1, "", "", 0, 0, -1);
    }

    public Course(int id, String code, int programId) {
        setInfo(id, code, "", 0, 0, programId);
    }

    public Course(int id, String code, String name, int hour, int credit, int programId) {
        setInfo(id, code, name, hour, credit, programId);
    }

    private void setInfo(int id, String code, String name, int hour, int credit, int programId) {
        _id = id;
        _code = code;
        _name = name;
        _hour = hour;
        _credit = credit;
        _programId = programId;
    }

    public void update(String code, String name, int hour, int credit, int programId) {
        setInfo(_id, code, name, hour, credit, programId);
    }

    public void setId(int id) {
        _id = id;
    }

    public int getId() {
        return _id;
    }

    public void setCode(String code) {
        _code = code;
    }

    public String getCode() {
        return _code;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void setHour(int hour) {
        _hour = hour;
    }

    public int getHour() {
        return _hour;
    }

    public void setCredit(int credit) {
        _credit = credit;
    }

    public int getCredit() {
        return _credit;
    }

    public void setProgramId(int programId) {
        _programId = programId;
    }

    public int getProgramId() {
        return _programId;
    }

    public String toString() { return _code + " (" + _name + ")"; }
}