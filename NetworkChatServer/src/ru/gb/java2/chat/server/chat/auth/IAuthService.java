package ru.gb.java2.chat.server.chat.auth;

public interface IAuthService {

    default void start() {
    }

    default void stop(){
    }

    String getUsernameByLoginAndPassword(String login, String password);

    void updateUsername(String currentUsername, String newUsername);
}
