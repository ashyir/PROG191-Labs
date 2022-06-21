package PROG191.sample_project.data;

import PROG191.sample_project.models.Course;
import PROG191.sample_project.models.Program;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class ProgramList {
    private final static String _FN_PROGRAMS = "programs.data";
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

    public static void readData() {
        try {
            File inFile = new File(_FN_PROGRAMS);
            FileInputStream inFileStream = new FileInputStream(inFile);
            ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

            while (true) {
                Program item = (Program) inObjectStream.readObject();
                _programs.add(item);
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
            File outFile = new File(_FN_PROGRAMS);
            FileOutputStream outFileStream = new FileOutputStream(outFile);
            ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);

            for (var item : _programs)
                outObjectStream.writeObject(item);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}