package database.tablesHandlers;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ChosenRostersHandler {

    public static ResultSet getUserRoster(String username) {
        String command = """
                SELECT *
                FROM chosen_rosters
                WHERE username = ?
                """;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setString(1, username);
            ResultSet result = preparedStatement.executeQuery();
            return result.next() ? result : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void removeRoster(int rosterId) {
        String command = """
            DELETE FROM chosen_rosters
            WHERE roster_id = ?
            """;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setInt(1, rosterId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addNewRoster(String username, ArrayList<String> players) {
        String command = """
            INSERT INTO chosen_rosters (username, top, jungle, middle, bottom, support)
            VALUES (?, ?, ?, ?, ?, ?)
            """;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setString(1, username);
            for (int i = 0; i < players.size(); i++) {
                preparedStatement.setString(i + 2, players.get(i));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAllRosters() {
        String command = """
                SELECT *
                FROM chosen_rosters
                """;
        try {
            Statement statement = DatabaseConnection.getInstance().createStatement();
            ResultSet result = statement.executeQuery(command);
            return result.next() ? result : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
