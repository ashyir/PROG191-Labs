package PROG191.sample_project.data;

import PROG191.sample_project.models.Course;
import PROG191.sample_project.models.Session;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class SessionList {
    private final static String _FN_SESSIONS = "sessions.data";
    private static ObservableList<Session> _sessions = FXCollections.observableArrayList();
    private static int _idCount = 0;

    public static int add(Session session) {
        if (session == null)
            return -1;

        session.setId(_idCount);
        _sessions.add(session);
        ++_idCount;

        return 1;
    }

    public static Session find(int id) {
        return _sessions.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    public static Session find(String code) {
        return _sessions.stream().filter(s -> s.getCode().equals(code)).findFirst().get();
    }

    public static int edit(Session newSession) {
        for (var session : _sessions) {
            if (session.getId() == newSession.getId()) {
                var index = _sessions.indexOf(session);
                _sessions.set(index, newSession);

                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        for (var session : _sessions) {
            if (session.getId() == id) {
                _sessions.remove(session);
                return 1;
            }
        }

        return -1;
    }

    public static ObservableList<Session> getList() {
        return _sessions;
    }

    public static void readData() {
        try {
            File inFile = new File(_FN_SESSIONS);
            FileInputStream inFileStream = new FileInputStream(inFile);
            ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

            while (true) {
                Session item = (Session) inObjectStream.readObject();
                _sessions.add(item);
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
            File outFile = new File(_FN_SESSIONS);
            FileOutputStream outFileStream = new FileOutputStream(outFile);
            ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);

            for (var item : _sessions)
                outObjectStream.writeObject(item);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}