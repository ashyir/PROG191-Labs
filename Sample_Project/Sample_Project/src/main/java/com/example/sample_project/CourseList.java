package com.example.sample_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CourseList {
    private static ObservableList<Course> _courses = FXCollections.observableArrayList();
    private static int _currentId = 0;

    public static int add(Course course) {
        if (course == null)
            return -1;

        course.setId(_currentId);
        _courses.add(course);
        ++_currentId;

        return 1;
    }

    public static Course search(int id) {
        for (var course : _courses)
            if (course.getId() == id)
                return course;

        return null;
    }

    public static Course search(String code) {
        for (var course : _courses)
            if (course.getCode() == code)
                return course;

        return null;
    }

    public static int edit(int id, Course newCourse) {
        for (var course : _courses) {
            if (course.getId() == id) {
                var index = _courses.indexOf(course);
                _courses.set(index, newCourse);
                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        var course = search(id);

        if (course == null)
            return -1;

        _courses.remove(course);

        return 1;
    }

    public static int remove(Course course) {
        _courses.remove(course);

        return 1;
    }

    public static ObservableList<Course> getList() {
        return _courses;
    }
}