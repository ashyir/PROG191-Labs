package PROG191.sample_project.data;

import PROG191.sample_project.models.Course;
import PROG191.sample_project.models.Global;
import PROG191.sample_project.models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.security.NoSuchAlgorithmException;

public class UserList {
    private final static String _FN_USERS = "users.data";
    private static ObservableList<User> _users = FXCollections.observableArrayList();
    private static User _currentUser = null;
    private static int _idCount = 0;

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

    public static Global.Role getRole(String username) {
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
        return _users.filtered(u -> u.getRole() == Global.Role.LECTURER);
    }

    public static void readData() throws NoSuchAlgorithmException {
        try {
            File inFile = new File(_FN_USERS);
            FileInputStream inFileStream = new FileInputStream(inFile);
            ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

            while (true) {
                User item = (User) inObjectStream.readObject();
                _users.add(item);
            }
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            User user = new User(0,
                    "admin",
                    "admin",
                    "Administrator",
                    "+84962242999",
                    "baohnp@fe.edu.vn",
                    "12345",
                    Global.Role.ADMIN);

            UserList.add(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveData() {
        try {
            File outFile = new File(_FN_USERS);
            FileOutputStream outFileStream = new FileOutputStream(outFile);
            ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);

            for (var item : _users)
                outObjectStream.writeObject(item);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}