package controllers;

import database.tablesHandlers.ChosenItemSetsHandler;
import database.tablesHandlers.ChosenRostersHandler;
import database.tablesHandlers.SettingsHandler;
import database.tablesHandlers.UsersHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Game;
import models.player.Player;
import utils.ItemsHandler;
import utils.WeeksHandler;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class AdminController {

    @FXML
    private TextField rosterCostField;
    @FXML
    private TextField gamesPathField;

    private Parent root;

    public void getRostersPoints(ActionEvent e) throws SQLException, IOException {
        ResultSet rosters = ChosenRostersHandler.getAllRosters();
        if (rosters == null) {
            AlertBoxController.displayAlert("There are no rosters to calculate!");
            return;
        }
        WeeksHandler weeksHandler = new WeeksHandler(gamesPathField.getText());
        List<Game> gamesPlayed = weeksHandler.getGames();
        do {
            int rosterPoints = getRosterPoints(rosters, gamesPlayed);
            UsersHandler.addPointsToUser(rosters.getString("username"), rosterPoints);
            ChosenItemSetsHandler.removeItemSet(rosters.getInt("roster_id"));
            ChosenRostersHandler.removeRoster(rosters.getInt("roster_id"));
        } while (rosters.next());
        gamesPathField.setText("");
        AlertBoxController.displayAlert("Roster points successfully calculated!");
    }

    public void updateRostersCost(ActionEvent e) throws IOException {
        int newRosterCost = Integer.parseInt(rosterCostField.getText());
        SettingsHandler.updateRosterCost(newRosterCost);
        rosterCostField.setText("");
        AlertBoxController.displayAlert("Roster cost successfully changed!");
    }

    public void logout(ActionEvent e) throws Exception {
        Alert quitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        quitAlert.setTitle("Logout");
        quitAlert.setHeaderText("Are you sure you want to logout?");

        if (quitAlert.showAndWait().get() == ButtonType.OK) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/MenuScene.fxml")));
            loadScene(e);
        }
    }

    private void loadScene(ActionEvent e) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

    private int getRosterPoints(ResultSet roster, List<Game> gamesPlayed) throws SQLException {
        AtomicInteger rosterPoints = new AtomicInteger();
        int rosterId = roster.getInt("roster_id");
        Map<Integer, String> positionMap = Map.ofEntries(
                Map.entry(0, "top"),
                Map.entry(1, "jungle"),
                Map.entry(2, "middle"),
                Map.entry(3, "bottom"),
                Map.entry(4, "support")
        );
        List<String> rosterPlayers = new ArrayList<>();
        rosterPlayers.add(0, roster.getString(positionMap.get(0)));
        rosterPlayers.add(1, roster.getString(positionMap.get(1)));
        rosterPlayers.add(2, roster.getString(positionMap.get(2)));
        rosterPlayers.add(3, roster.getString(positionMap.get(3)));
        rosterPlayers.add(4, roster.getString(positionMap.get(4)));
        Map<String, List<String>> playersItems = new HashMap<>();
        rosterPlayers.forEach(player ->
            playersItems.put(player, ChosenItemSetsHandler.getItemsFromPosition(rosterId, positionMap.get(rosterPlayers.indexOf(player)))));
        for (String nickname : rosterPlayers) {
            for (Game game : gamesPlayed) {
                if (game.hasPlayer(nickname)) {
                    Player player = game.getPlayer(nickname);
                    rosterPoints.addAndGet(player.getPlayerPoints());
                    List<String> items = playersItems.get(nickname);
                    items.forEach(item -> {
                        int gathered = ItemsHandler.getItemPointsFromGame(item, nickname, game);
                        rosterPoints.addAndGet(gathered);
                    });
                    break;
                }
            }
        }
        return rosterPoints.get();
    }
}
