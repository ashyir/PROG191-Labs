package PROG191.sample_project.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Session implements Serializable {
    private int _id;
    private String _code;
    private LocalDate _startDate;
    private LocalDate _endDate;
    private Global.Semester _semester;
    private int _year;
    private int _lecturerId;
    private int _courseId;

    public Session(int id, String code, LocalDate startDate, LocalDate endDate, Global.Semester semester, int year, int lecturerId, int courseId) {
        setInfo(id, code, startDate, endDate, semester, year, lecturerId, courseId);
    }

    private void setInfo(int id, String code, LocalDate startDate, LocalDate endDate, Global.Semester semester, int year, int lecturerId, int courseId) {
        _id = id;
        _code = code;
        _startDate = startDate;
        _endDate = endDate;
        _semester = semester;
        _year = year;
        _lecturerId = lecturerId;
        _courseId = courseId;
    }

    public void update(String code, LocalDate startDate, LocalDate endDate, Global.Semester semester, int year, int lecturerId, int courseId) {
        setInfo(_id, code, startDate, endDate, semester, year, lecturerId, courseId);
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

    public void setStartDate(LocalDate startDate) {
        _startDate = startDate;
    }

    public LocalDate getStartDate() {
        return _startDate;
    }

    public void setEndDate(LocalDate endDate) {
        _endDate = endDate;
    }

    public LocalDate getEndDate() {
        return _endDate;
    }

    public void setSemester(Global.Semester semester) {
        _semester = semester;
    }

    public Global.Semester getSemester() {
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

    public String toString() {
        return _code;
    }
}