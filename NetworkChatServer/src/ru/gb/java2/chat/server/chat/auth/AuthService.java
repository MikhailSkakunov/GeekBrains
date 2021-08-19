package ru.gb.java2.chat.server.chat.auth;

import java.util.Set;

public class AuthService implements IAuthService {

    private static Set<User> USERS = Set.of(
               new User("login1", "pass1"),
               new User("login2", "pass2"),
               new User("login3", "pass3")
        );



    public String getUsernameByLoginAndPassword(String login, String password) {
        User user = getUserByLoginAndPassword(login, password);
        return user != null ? user.getUsername() : null;

    }
    private User getUserByLoginAndPassword(String login, String password) {
        User requiredUser = new User(login, password);
        for (User user : USERS) {
            if (requiredUser.equals(user)) {
                return user;
            }
        }
        return null;
    }

    private User getUserByUserName(String username) {
        for (User user : USERS) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void updateUsername(String currentUsername, String newUsername) {

        User user = getUserByUserName(currentUsername);
        if (user != null) {
            user.setUsername(newUsername);
        }
    }
}
