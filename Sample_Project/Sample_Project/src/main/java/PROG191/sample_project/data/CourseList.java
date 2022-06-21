package PROG191.sample_project.data;

import PROG191.sample_project.models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class CourseList {
    private final static String _FN_COURSES = "courses.data";
    private static ObservableList<Course> _courses = FXCollections.observableArrayList();
    private static int _idCount = 0;

    public static int add(Course course) {
        if (course == null)
            return -1;

        course.setId(_idCount);
        _courses.add(course);
        ++_idCount;

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

    public static void readData() {
        try {
            File inFile = new File(_FN_COURSES);
            FileInputStream inFileStream = new FileInputStream(inFile);
            ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

            while (true) {
                Course item = (Course) inObjectStream.readObject();
                _courses.add(item);
            }
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveData() {
        try {
            File outFile = new File(_FN_COURSES);
            FileOutputStream outFileStream = new FileOutputStream(outFile);
            ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);

            for (var item : _courses)
                outObjectStream.writeObject(item);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}