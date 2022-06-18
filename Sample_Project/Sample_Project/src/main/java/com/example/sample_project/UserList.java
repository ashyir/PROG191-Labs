package com.example.sample_project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

public class UserList {
    private static ObservableList<User> _users;
    private static User _currentUser;
    private static int _idCount = 0;

    static {
        try {
            _currentUser = new User();
            _users = FXCollections.observableArrayList(
                    new User(
                            0,
                            "admin",
                            "admin",
                            "Admin",
                            "+84962242999",
                            "baohnp@fe.edu.vn",
                            "12345",
                            Role.ADMIN
                    )
            );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static int add(User user) {
        if (user == null)
            return -1;

        user.setId(_idCount);
        _users.add(user);
        ++_idCount;

        return 1;
    }

    public static User find(int id) {
        return _users.stream().filter(u -> u.getId() == id).findFirst().get();
    }

    public static User find(String username) {
        return _users.stream().filter(u -> u.getUsername().equals(username)).findFirst().get();
    }

    public static boolean authenticate(String username, String password) throws NoSuchAlgorithmException {
        for (var user : _users) {
            if (user.getUsername().equals(username) && user.matchPassword(password))
                return true;
        }

        return false;
    }

    public static void setCurrentUser(User user) {
        _currentUser = user;
    }

    public static User getCurrentUser() {
        return _currentUser;
    }

    public static Role getRole(String username) {
        for (var user : _users) {
            if (user.getUsername().equals(username))
                return user.getRole();
        }

        return null;
    }

    public static int edit(User newUser) {
        for (var user : _users) {
            if (user.getId() == newUser.getId()) {
                var index = _users.indexOf(user);

                user.update(
                        newUser.getName(),
                        newUser.getPhone(),
                        newUser.getEmail(),
                        newUser.getNumber(),
                        newUser.getRole()
                );

                _users.set(index, user);

                return 1;
            }
        }

        return -1;
    }

    public static int remove(int id) {
        for (var user : _users) {
            if (user.getId() == id) {
                _users.remove(user);
                return 1;
            }
        }

        return -1;
    }

    public static ObservableList<User> getList() {
        return _users;
    }

    public static ObservableList<User> getLecturers() {
        return _users.filtered(u -> u.getRole() == Role.LECTURER);
    }
}