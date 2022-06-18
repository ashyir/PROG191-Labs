package com.example.sample_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SessionList {
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
}