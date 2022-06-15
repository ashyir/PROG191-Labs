package com.example.sample_project;

import java.util.Date;

public class Session {
    private int _id;
    private String _code;
    private Date _startDate;
    private Date _endDate;
    private String _semester;
    private int _year;
    private int _lecturerId;
    private int _courseId;

    public Session(int id, String code, Date startDate, Date endDate, String semester, int year, int lecturerId, int courseId) {
        _id = id;
        _code = code;
        _startDate = startDate;
        _endDate = endDate;
        _semester = semester;
        _year = year;
        _lecturerId = lecturerId;
        _courseId = courseId;
    }

    public void update(String code, Date startDate, Date endDate, String semester, int year, int lecturerId, int courseId) {
        _code = code;
        _startDate = startDate;
        _endDate = endDate;
        _semester = semester;
        _year = year;
        _lecturerId = lecturerId;
        _courseId = courseId;
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

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public Date getStartDate() {
        return _startDate;
    }

    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    public Date getEndDate() {
        return _endDate;
    }

    public void setSemester(String semester) {
        _semester = semester;
    }

    public String getSemester() {
        return _semester;
    }

    public void setYear(int year) {
        _year = year;
    }

    public int getYear() {
        return _year;
    }

    public void setLecturerId(int lecturerId) {
        _lecturerId = lecturerId;
    }

    public int getLecturerId() {
        return _lecturerId;
    }

    public void setCourseId(int courseId) {
        _courseId = courseId;
    }

    public int getCourseId() {
        return _courseId;
    }
}