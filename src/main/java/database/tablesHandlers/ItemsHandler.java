package database.tablesHandlers;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ItemsHandler {

    public static String getItemDescription(String itemName) {
        String command = """
                SELECT item_description
                FROM items
                WHERE item_name = ?
                """;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setString(1, itemName);
            ResultSet result = preparedStatement.executeQuery();
            return result.next() ? result.getString("item_description") : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<String> getItems(String type) {
        String command = """
                SELECT *
                FROM items
                WHERE type = ?
                """;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setString(1, type);
            ResultSet result = preparedStatement.executeQuery();
            ArrayList<String> to_return = new ArrayList<>();
            while (result.next()) {
                to_return.add(result.getString("item_name"));
            }
            return to_return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Map<String, Integer> getItemsWithCost() {
        String command = """
                SELECT item_name, cost
                FROM items
                """;
        Map<String, Integer> to_return = new HashMap<>();
        try {
            Statement statement = DatabaseConnection.getInstance().createStatement();
            ResultSet result = statement.executeQuery(command);
            while (result.next()) {
                to_return.put(result.getString("item_name"), result.getInt("cost"));
            }
            return to_return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
