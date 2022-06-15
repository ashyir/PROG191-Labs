package com.example.sample_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class LecturerList {
    private static ObservableList<Lecturer> _lecturers = FXCollections.observableArrayList();
    private static int _currentId = 0;

    public static int add(Lecturer lecturer) {
        if (lecturer == null)
            return -1;

        lecturer.setId(_currentId);
        _lecturers.add(lecturer);
        ++_currentId;

        return 1;
    }

    public static Lecturer search(int id) {
        for (var lecturer : _lecturers)
            if (lecturer.getId() == id)
                return lecturer;

        return null;
    }

    public static Lecturer search(String staffId) {
        for (var lecturer : _lecturers)
            if (lecturer.getStaffId() == staffId)
                return lecturer;

        return null;
    }

    public static int edit(int id, Lecturer newLecturer) {
        for (var lecturer : _lecturers) {
            if (lecturer.getId() == id) {
                lecturer.update(
                        newLecturer.getName(),
                        newLecturer.getStaffId(),
                        newLecturer.getPhone(),
                        newLecturer.getEmail()
                );

                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        var lecturer = search(id);

        if (lecturer == null)
            return -1;

        _lecturers.remove(lecturer);

        return 1;
    }

    public static int remove(Lecturer lecturer) {
        _lecturers.remove(lecturer);

        return 1;
    }

    public static ObservableList<Lecturer> getList() {
        return _lecturers;
    }
}