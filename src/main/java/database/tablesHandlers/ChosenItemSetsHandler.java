package database.tablesHandlers;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChosenItemSetsHandler {

    public static void removeItemSet(int rosterId) {
        String command = """
                DELETE FROM chosen_item_sets
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

    public static void addNewItemSet(int rosterId, ArrayList<String> chosenItems) {
        String command = """
            INSERT INTO chosen_item_sets (roster_id, top_item_1, top_item_2, top_item_3,
            jungle_item_1, jungle_item_2, jungle_item_3, middle_item_1, middle_item_2, middle_item_3,
            bottom_item_1, bottom_item_2, bottom_item_3, support_item_1, support_item_2, support_item_3)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
            """;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setInt(1, rosterId);
            for (int i = 0; i < chosenItems.size(); i++) {
                preparedStatement.setString(i + 2, chosenItems.get(i));
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getItemSet(int rosterId) {
        String command = """
            SELECT *
            FROM chosen_item_sets
            WHERE roster_id = ?
            """;
        try {
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setInt(1, rosterId);
            ResultSet result = preparedStatement.executeQuery();
            return result.next() ? result : null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getItemsFromPosition(int rosterId, String position) {
        String command = """
            SELECT *
            FROM chosen_item_sets
            WHERE roster_id = ?
            """;
        try {
            String item_1 = position + "_item_1";
            String item_2 = position + "_item_2";
            String item_3 = position + "_item_3";
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().prepareStatement(command);
            preparedStatement.setInt(1, rosterId);
            ResultSet result = preparedStatement.executeQuery();
            ArrayList<String> items = new ArrayList<>();
            if (result.next()) {
                items.add(result.getString(item_1));
                items.add(result.getString(item_2));
                items.add(result.getString(item_3));
            }
            return items;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
