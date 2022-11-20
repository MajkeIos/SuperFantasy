package database.tablesHandlers;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SettingsHandler {

    public static ResultSet getSettings() {
        String command = """
                SELECT *
                FROM settings
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

    public static void updateRosterCost(int rosterCost) {
        String command = """
                UPDATE settings
                SET max_roster_cost = ?
                WHERE min_players_chosen = ?
                """;
        try {
            ResultSet result = getSettings();
            assert result != null;
            PreparedStatement prepareStatement = DatabaseConnection.getInstance().prepareStatement(command);
            prepareStatement.setInt(1, rosterCost);
            prepareStatement.setInt(2, result.getInt("min_players_chosen"));
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
