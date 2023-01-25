package controllers;

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
import models.Roster;
import models.player.Player;
import utils.*;

import java.io.IOException;
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
        Map<String, Roster> rosters = RostersHandler.getInstance().getRosters();
        if (rosters == null) {
            AlertBoxController.displayAlert("There are no rosters to calculate!");
            return;
        }
        WeeksHandler weeksHandler = new WeeksHandler(gamesPathField.getText());
        List<Game> gamesPlayed = weeksHandler.getGames();
        rosters.forEach((rosterOwner, roster) -> {
            int rosterPoints = getRosterPoints(roster, gamesPlayed);
            UsersHandler.getInstance().addPointsToUser(rosterOwner, rosterPoints);
            RostersHandler.getInstance().removeRoster(rosterOwner);
        });
        gamesPathField.setText("");
        AlertBoxController.displayAlert("Roster points successfully calculated!");
    }

    public void updateRostersCost(ActionEvent e) throws IOException {
        int newRosterCost = Integer.parseInt(rosterCostField.getText());
        SettingsHandler.getInstance().updateRosterCost(newRosterCost);
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

    private int getRosterPoints(Roster roster, List<Game> gamesPlayed) {
        AtomicInteger rosterPoints = new AtomicInteger();
        Map<String, String> players = roster.getPlayers();
        Map<String, List<String>> playersItems = roster.getPlayersItems();
        for (String position : players.keySet()) {
            for (Game game : gamesPlayed) {
                String nickname = players.get(position);
                if (game.hasPlayer(nickname)) {
                    Player player = game.getPlayer(nickname);
                    rosterPoints.addAndGet(player.getPlayerPoints());
                    List<String> items = playersItems.get(position);
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
