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

    public static Course find(int id) {
        return _courses.stream().filter(c -> c.getId() == id).findFirst().get();
    }

    public static Course find(String code) {
        return _courses.stream().filter(c -> c.getCode().equals(code)).findFirst().get();
    }

    public static int edit(Course newCourse) {
        for (var course : _courses) {
            if (course.getId() == newCourse.getId()) {
                var index = _courses.indexOf(course);
                _courses.set(index, newCourse);
                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        for (var course : _courses) {
            if (course.getId() == id) {
                _courses.remove(course);
                return 1;
            }
        }

        return -1;
    }

    public static ObservableList<Course> getList() {
        return _courses;
    }
}