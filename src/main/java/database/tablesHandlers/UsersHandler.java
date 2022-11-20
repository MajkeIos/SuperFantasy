package database.tablesHandlers;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersHandler {

    public static void addUser(String username, String password) {
        String command = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            PreparedStatement prepareStatement = DatabaseConnection.getInstance().prepareStatement(command);
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getUser(String username) {
        String command = """
                SELECT *
                FROM users
                """;
        try {
            Statement statement = DatabaseConnection.getInstance().createStatement();
            ResultSet result = statement.executeQuery(command);
            while (result.next()) {
                if (result.getString("username").equals(username))
                    return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Integer getUserPoints(String username) {
        String command = """
                SELECT points
                FROM users
                WHERE username = ?
                """;
        try {
            PreparedStatement prepareStatement = DatabaseConnection.getInstance().prepareStatement(command);
            prepareStatement.setString(1, username);
            ResultSet result = prepareStatement.executeQuery();
            return result.next() ? result.getInt("points") : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addPointsToUser(String username, int pointsToAdd) {
        String command = """
                UPDATE users
                SET points = ?
                WHERE username = ?
                """;
        try {
            Integer userPoints = getUserPoints(username);
            assert userPoints != null;
            PreparedStatement prepareStatement = DatabaseConnection.getInstance().prepareStatement(command);
            prepareStatement.setInt(1, userPoints + pointsToAdd);
            prepareStatement.setString(2, username);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
