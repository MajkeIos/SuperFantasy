package database.tablesHandlers;

import database.DatabaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PlayersHandler {

    public static ArrayList<String> getPlayersFromPosition(String position) {
        String command = """
                SELECT p.nickname as nickname, t.team_shortname as team, p.position as position
                FROM players p, teams t
                WHERE p.team = t.team_name;
                """;
        try {
            Statement statement = DatabaseConnection.getInstance().createStatement();
            ResultSet result = statement.executeQuery(command);
            ArrayList<String> to_return = new ArrayList<>();
            while (result.next()) {
                if (result.getString("position").equals(position))
                    to_return.add(result.getString("team") + " " + result.getString("nickname"));
            }
            return to_return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
