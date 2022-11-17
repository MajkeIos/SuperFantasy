package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersHandler {

    public static void addUser(String username, String password) {
        String command = "INSERT INTO users (username, password) VALUES (?, ?)";
        try {
            PreparedStatement prepareStatement = ConnectionHandler.getInstance().prepareStatement(command);
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkIfUserExists(String username) {
        String command = "SELECT * FROM users";
        try {
            Statement statement = ConnectionHandler.getInstance().createStatement();
            ResultSet result = statement.executeQuery(command);
            while (result.next()) {
                if (result.getString("username").equals(username))
                    return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
