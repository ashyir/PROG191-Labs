package com.example.sample_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProgramList {
    private static ObservableList<Program> _programs = FXCollections.observableArrayList();
    private static int _idCount = 0;

    public static int add(Program program) {
        if (program == null)
            return -1;

        program.setId(_idCount);
        _programs.add(program);
        ++_idCount;

        return 1;
    }

    public static Program find(int id) {
        return _programs.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public static Program find(String name) {
        return _programs.stream().filter(p -> p.getName().equals(name)).findFirst().get();
    }

    public static int edit(Program newProgram) {
        for (var program : _programs) {
            if (program.getId() == newProgram.getId()) {
                var index = _programs.indexOf(program);
                _programs.set(index, newProgram);

                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        for (var program : _programs) {
            if (program.getId() == id) {
                _programs.remove(program);
                return 1;
            }
        }

        return -1;
    }

    public static ObservableList<Program> getList() {
        return _programs;
    }
}