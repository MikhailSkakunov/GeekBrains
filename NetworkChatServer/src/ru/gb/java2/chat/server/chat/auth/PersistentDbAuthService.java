package ru.gb.java2.chat.server.chat.auth;


import java.sql.*;

public class PersistentDbAuthService implements IAuthService {

    private static final String DB_URL = "jdbc:sqlite:C:/Users/skak8/IdeaProjects/GeekBrains/user.db";
    private Connection connection;
    private PreparedStatement getUsernameStatement;
    private PreparedStatement updateUsernameStatement;


    @Override
    public void start() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            getUsernameStatement = createGetUsernameStatement();
            updateUsernameStatement = createUpdateUsernameStatement();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.println("Filed to connect to DB by URL: " + DB_URL);
            throw new RuntimeException("Filed to start auth service");
        }
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String password) {
        String username = null;
        try {
            getUsernameStatement.setString(1, login);
            getUsernameStatement.setString(2, password);
            ResultSet resultSet = getUsernameStatement.executeQuery();
            while (resultSet.next()) {
             username = resultSet.getString("username");
                break;
            }
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.printf("Filed to fetch from DB. Login: %s; password: %s%n", login, password);
        }
        return username;
    }

    @Override
    public void updateUsername(String currentUsername, String newUsername) {
        try {
            updateUsernameStatement.setString(1, newUsername);
            updateUsernameStatement.setString(2, currentUsername);
            int result = updateUsernameStatement.executeUpdate();
            System.out.println("Update username. Update rows: " + result);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.err.printf("Filed to update username: currentUsername: %s; newUsername: %s%n", currentUsername, newUsername);
        }
    }

    private PreparedStatement createGetUsernameStatement() throws SQLException {
        return connection.prepareStatement("""
                SELECT username
                FROM user
                WHERE login = ?
                password = ?""");
    }

    private PreparedStatement createUpdateUsernameStatement() throws SQLException {
        return connection.prepareStatement("""
                UPDATE user
                SET username = ?
                WHERE username = ?
                """);
    }

    @Override
    public void stop() {

        if (connection != null) {
            try {
                System.out.println("Close connection");
                connection.close();
                System.out.println("Connection is closed");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.err.println("Filed to close connection to DB by URL: " + DB_URL);
                throw new RuntimeException("Filed to stop auth service");
            }
        }
    }
}