package com.example.sample_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProgramList {
    private static ObservableList<Program> _programs = FXCollections.observableArrayList();
    private static int _currentId = 0;

    public static int add(Program program) {
        if (program == null)
            return -1;

        program.setId(_currentId);
        _programs.add(program);
        ++_currentId;

        return 1;
    }

    public static Program search(int id) {
        for (var program : _programs)
            if (program.getId() == id)
                return program;

        return null;
    }

    public static Program search(String name) {
        for (var program : _programs)
            if (program.getName() == name)
                return program;

        return null;
    }

    public static int edit(int id, Program newProgram) {
        for (var program : _programs) {
            if (program.getId() == id) {
                program.update(newProgram.getName());

                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        var program = search(id);

        if (program == null)
            return -1;

        _programs.remove(program);

        return 1;
    }

    public static int remove(Program program) {
        _programs.remove(program);

        return 1;
    }

    public static ObservableList<Program> getList() {
        return _programs;
    }
}