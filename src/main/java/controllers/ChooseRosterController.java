package controllers;

import database.tablesHandlers.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ChooseRosterController implements Initializable {

    @FXML
    private ChoiceBox<String> topChoiceBox;
    @FXML
    private ChoiceBox<String> jungleChoiceBox;
    @FXML
    private ChoiceBox<String> middleChoiceBox;
    @FXML
    private ChoiceBox<String> bottomChoiceBox;
    @FXML
    private ChoiceBox<String> supportChoiceBox;
    @FXML
    private Text costText;
    @FXML
    private ProgressBar costBar;
    @FXML
    private Label pointsLabel;
    @FXML
    private Button player1item1Button;
    @FXML
    private Button player1item2Button;
    @FXML
    private Button player1item3Button;
    @FXML
    private Button player2item1Button;
    @FXML
    private Button player2item2Button;
    @FXML
    private Button player2item3Button;
    @FXML
    private Button player3item1Button;
    @FXML
    private Button player3item2Button;
    @FXML
    private Button player3item3Button;
    @FXML
    private Button player4item1Button;
    @FXML
    private Button player4item2Button;
    @FXML
    private Button player4item3Button;
    @FXML
    private Button player5item1Button;
    @FXML
    private Button player5item2Button;
    @FXML
    private Button player5item3Button;

    public static String currentUser;
    private Parent root;
    private int rosterCost;
    private int maxRosterCost;
    private int maxSameTeamPlayers;
    private int maxPlayerItemCopies;
    private int minPlayersChosen;
    private final ArrayList<ArrayList<Button>> itemsGrid = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ResultSet resultSet = SettingsHandler.getSettings();
        try {
            assert resultSet != null;
            maxRosterCost = resultSet.getInt("max_roster_cost");
            maxSameTeamPlayers = resultSet.getInt("max_same_team_players");
            maxPlayerItemCopies = resultSet.getInt("max_player_item_copies");
            minPlayersChosen = resultSet.getInt("min_players_chosen");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rosterCost = 0;
        initChoiceBoxes();
        initItemButtons();
        ResultSet currentRoster = ChosenRostersHandler.getUserRoster(currentUser);
        if (currentRoster != null) {
            initRoster(currentRoster);
            updateCost();
        }
        pointsLabel.setText(Objects.requireNonNull(UsersHandler.getUserPoints(currentUser)).toString());
        costText.setText(rosterCost + " of " + maxRosterCost);
    }

    public void chooseItem(ActionEvent e) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/ChooseItemScene.fxml"));
        Parent temp_root = loader.load();

        ChooseItemController chooseItemController = loader.getController();
        chooseItemController.clickedButton = (Button) e.getSource();
        chooseItemController.chooseRosterController = this;

        Scene scene = new Scene(temp_root);
        stage.setScene(scene);
        stage.showAndWait();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }

    public void saveRoster(ActionEvent e) throws IOException, SQLException {
        ArrayList<String> chosenPlayers = getChosenPlayers();
        ArrayList<String> chosenItems = getChosenItems();
        if (chosenPlayers.size() < minPlayersChosen) {
            AlertBoxController.displayAlert("You haven't chosen enough players!");
        } else if (chosenItems.size() <  minPlayersChosen * itemsGrid.get(0).size()){
            AlertBoxController.displayAlert("You haven't chosen item for every player!");
        } else if (getChosenPlayers().size() < minPlayersChosen) {
            AlertBoxController.displayAlert("You haven't chosen enough players!");
        } else if (rosterCost > maxRosterCost) {
            AlertBoxController.displayAlert("Your roster is too expensive!");
        } else if (!checkSameTeamPlayers(chosenPlayers)) {
            AlertBoxController.displayAlert("Your can have only " + maxSameTeamPlayers + " players from the same team!");
        } else if (!checkPlayerItemCopies()) {
            AlertBoxController.displayAlert("Your can have only " + maxPlayerItemCopies + " item copies per player!");
        } else {
            removePreviousRoster();
            ChosenRostersHandler.addNewRoster(currentUser, chosenPlayers);
            int rosterId = Objects.requireNonNull(ChosenRostersHandler.getUserRoster(currentUser)).getInt("roster_id");
            ChosenItemSetsHandler.addNewItemSet(rosterId, chosenItems);
            AlertBoxController.displayAlert("Roster successfully saved!");
        }
    }

    public void updateCost() {
        ArrayList<String> items = getChosenItems();
        Map<String, Integer> itemCosts = ItemsHandler.getItemsWithCost();
        rosterCost = 0;
        items.forEach(item -> {
            assert itemCosts != null;
            rosterCost += itemCosts.get(item);
        });
        costBar.setProgress((double) rosterCost / maxRosterCost);
        costBar.setStyle((rosterCost <= maxRosterCost) ? "-fx-accent: green" : "-fx-accent: red");
        costText.setText(rosterCost + " of " + maxRosterCost);
    }

    public void logout(ActionEvent e) throws Exception {
        Alert quitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        quitAlert.setTitle("Logout");
        quitAlert.setContentText("If you haven't saved your roster it will be lost");
        quitAlert.setHeaderText("Are you sure you want to logout?");

        if (quitAlert.showAndWait().get() == ButtonType.OK) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/MenuScene.fxml")));
            loadScene(e);
        }
    }

    private void initChoiceBoxes() {
        topChoiceBox.getItems().addAll(Objects.requireNonNull(PlayersHandler.getPlayersFromPosition("top")));
        jungleChoiceBox.getItems().addAll(Objects.requireNonNull(PlayersHandler.getPlayersFromPosition("jungle")));
        middleChoiceBox.getItems().addAll(Objects.requireNonNull(PlayersHandler.getPlayersFromPosition("middle")));
        bottomChoiceBox.getItems().addAll(Objects.requireNonNull(PlayersHandler.getPlayersFromPosition("bottom")));
        supportChoiceBox.getItems().addAll(Objects.requireNonNull(PlayersHandler.getPlayersFromPosition("support")));
    }

    private void initItemButtons() {
        for(int i = 0; i < 5; i++) itemsGrid.add(new ArrayList<>());
        itemsGrid.get(0).add(player1item1Button);
        itemsGrid.get(0).add(player1item2Button);
        itemsGrid.get(0).add(player1item3Button);
        itemsGrid.get(1).add(player2item1Button);
        itemsGrid.get(1).add(player2item2Button);
        itemsGrid.get(1).add(player2item3Button);
        itemsGrid.get(2).add(player3item1Button);
        itemsGrid.get(2).add(player3item2Button);
        itemsGrid.get(2).add(player3item3Button);
        itemsGrid.get(3).add(player4item1Button);
        itemsGrid.get(3).add(player4item2Button);
        itemsGrid.get(3).add(player4item3Button);
        itemsGrid.get(4).add(player5item1Button);
        itemsGrid.get(4).add(player5item2Button);
        itemsGrid.get(4).add(player5item3Button);
    }

    private void initRoster(ResultSet currentRoster) {
        try {
            int rosterId = currentRoster.getInt("roster_id");
            topChoiceBox.setValue(currentRoster.getString("top"));
            jungleChoiceBox.setValue(currentRoster.getString("jungle"));
            middleChoiceBox.setValue(currentRoster.getString("middle"));
            bottomChoiceBox.setValue(currentRoster.getString("bottom"));
            supportChoiceBox.setValue(currentRoster.getString("support"));
            initItemsFromRoster(rosterId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initItemsFromRoster(int rosterId) {
        ResultSet currentItemSet = ChosenItemSetsHandler.getItemSet(rosterId);
        try {
            assert currentItemSet != null;
            player1item1Button.setText(currentItemSet.getString("top_item_1"));
            player1item2Button.setText(currentItemSet.getString("top_item_2"));
            player1item3Button.setText(currentItemSet.getString("top_item_3"));
            player2item1Button.setText(currentItemSet.getString("jungle_item_1"));
            player2item2Button.setText(currentItemSet.getString("jungle_item_2"));
            player2item3Button.setText(currentItemSet.getString("jungle_item_3"));
            player3item1Button.setText(currentItemSet.getString("middle_item_1"));
            player3item2Button.setText(currentItemSet.getString("middle_item_2"));
            player3item3Button.setText(currentItemSet.getString("middle_item_3"));
            player4item1Button.setText(currentItemSet.getString("bottom_item_1"));
            player4item2Button.setText(currentItemSet.getString("bottom_item_2"));
            player4item3Button.setText(currentItemSet.getString("bottom_item_3"));
            player5item1Button.setText(currentItemSet.getString("support_item_1"));
            player5item2Button.setText(currentItemSet.getString("support_item_2"));
            player5item3Button.setText(currentItemSet.getString("support_item_3"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArrayList<String> getChosenItems() {
        ArrayList<String> items = new ArrayList<>();
        itemsGrid.forEach(buttons -> buttons.forEach(button -> {
            if (!Objects.equals(button.getText(), "Choose item")) {
                items.add(button.getText());
            }
        }));
        return items;
    }

    private ArrayList<String> getChosenPlayers() {
        ArrayList<String> chosenPlayers = new ArrayList<>();
        if (topChoiceBox.getValue() != null) chosenPlayers.add(topChoiceBox.getValue());
        if (jungleChoiceBox.getValue() != null) chosenPlayers.add(jungleChoiceBox.getValue());
        if (middleChoiceBox.getValue() != null) chosenPlayers.add(middleChoiceBox.getValue());
        if (bottomChoiceBox.getValue() != null) chosenPlayers.add(bottomChoiceBox.getValue());
        if (supportChoiceBox.getValue() != null) chosenPlayers.add(supportChoiceBox.getValue());
        return chosenPlayers;
    }

    private boolean checkSameTeamPlayers(ArrayList<String> chosenPlayers) {
        Map<String, Integer> playersPerTeam = new HashMap<>();
        for (String player : chosenPlayers) {
            String team = player.substring(0, player.indexOf(" "));
            if (playersPerTeam.containsKey(team)) {
                playersPerTeam.put(team, playersPerTeam.get(team) + 1);
                if (playersPerTeam.get(team) > maxSameTeamPlayers) return false;
            } else {
                playersPerTeam.put(team, 1);
            }
        }
        return true;
    }

    private boolean checkPlayerItemCopies() {
        for (ArrayList<Button> buttons : itemsGrid) {
            Map<String, Integer> itemsPerPlayer = new HashMap<>();
            for (Button button : buttons) {
                String item = button.getText();
                if (itemsPerPlayer.containsKey(item)) {
                    itemsPerPlayer.put(item, itemsPerPlayer.get(item) + 1);
                    if (itemsPerPlayer.get(item) > maxPlayerItemCopies) {
                        return false;
                    }
                } else {
                    itemsPerPlayer.put(item, 1);
                }
            }
        }
        return true;
    }

    private void removePreviousRoster() {
        ResultSet previousRoster = ChosenRostersHandler.getUserRoster(currentUser);
        if (previousRoster == null) return;
        try {
            int rosterId = previousRoster.getInt("roster_id");
            ChosenItemSetsHandler.removeItemSet(rosterId);
            ChosenRostersHandler.removeRoster(rosterId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
}
