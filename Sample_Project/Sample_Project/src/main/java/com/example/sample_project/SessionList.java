package com.example.sample_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SessionList {
    private static ObservableList<Session> _sessions = FXCollections.observableArrayList();
    private static int _currentId = 0;

    public static int add(Session session) {
        if (session == null)
            return -1;

        session.setId(_currentId);
        _sessions.add(session);
        ++_currentId;

        return 1;
    }

    public static Session search(int id) {
        for (var session : _sessions)
            if (session.getId() == id)
                return session;

        return null;
    }

    public static Session search(String code) {
        for (var session : _sessions)
            if (session.getCode() == code)
                return session;

        return null;
    }

    public static int edit(int id, Session newSession) {
        for (var session : _sessions) {
            if (session.getId() == id) {
                session.update(
                        newSession.getCode(),
                        newSession.getStartDate(),
                        newSession.getEndDate(),
                        newSession.getSemester(),
                        newSession.getYear(),
                        newSession.getLecturerId(),
                        newSession.getCourseId()
                );

                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        var session = search(id);

        if (session == null)
            return -1;

        _sessions.remove(session);

        return 1;
    }

    public static int remove(Session session) {
        _sessions.remove(session);

        return 1;
    }

    public static ObservableList<Session> getList() {
        return _sessions;
    }
}