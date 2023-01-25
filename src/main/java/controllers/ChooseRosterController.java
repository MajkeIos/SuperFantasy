package controllers;

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
import models.Roster;
import models.items.Item;
import utils.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

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
    private final Map<Integer, String> indexToPosition = new HashMap<>() {{
       put(0, "top"); put(1, "jungle"); put(2, "middle"); put(3, "bottom"); put(4, "support");
    }};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SettingsHandler settingsHandler = SettingsHandler.getInstance();
        maxRosterCost = settingsHandler.getMaxRosterCost();
        maxSameTeamPlayers = settingsHandler.getMaxSameTeamPlayers();
        maxPlayerItemCopies = settingsHandler.getMaxPlayerItemCopies();
        minPlayersChosen = settingsHandler.getMinPlayersChosen();
        rosterCost = 0;
        initChoiceBoxes();
        initItemButtons();
        Roster roster = RostersHandler.getInstance().getRosters().get(currentUser);
        if (roster != null) {
            initRoster(roster);
            updateCost();
        }
        pointsLabel.setText(Integer.valueOf(UsersHandler.getInstance().getUser(currentUser).getPoints()).toString());
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
        Map<String, String> chosenPlayers = getChosenPlayers();
        Map<String, List<String>> chosenItems = getChosenItems();
        AtomicInteger chosenItemsSize = new AtomicInteger();
        chosenItems.values().forEach(list -> chosenItemsSize.addAndGet(list.size()));
        if (chosenPlayers.size() < minPlayersChosen) {
            AlertBoxController.displayAlert("You haven't chosen enough players!");
        } else if (chosenItemsSize.get() <  minPlayersChosen * itemsGrid.get(0).size()){
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
            RostersHandler.getInstance().removeRoster(currentUser);
            RostersHandler.getInstance().addRoster(currentUser, new Roster(chosenPlayers, chosenItems));
            AlertBoxController.displayAlert("Roster successfully saved!");
        }
    }

    public void updateCost() {
        Map<String, List<String>> items = getChosenItems();
        HashMap<String, ? extends Item> allItems = ItemsHandler.getAllItems();
        rosterCost = 0;
        items.values().forEach(itemList -> itemList.forEach(item -> rosterCost += allItems.get(item).getItemCost()));
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

    private void initRoster(Roster roster) {
        Map<String, String> players = roster.getPlayers();
        topChoiceBox.setValue(players.get("top"));
        jungleChoiceBox.setValue(players.get("jungle"));
        middleChoiceBox.setValue(players.get("middle"));
        bottomChoiceBox.setValue(players.get("bottom"));
        supportChoiceBox.setValue(players.get("support"));
        initItemsFromRoster(roster.getPlayersItems());
    }

    private void initItemsFromRoster(Map<String, List<String>> items) {
        for (int i = 0; i < itemsGrid.size(); i++) {
            List<String> itemsOnPosition = items.get(indexToPosition.get(i));
            for (int j = 0; j < itemsGrid.get(i).size(); j++) {
                Button currentButton = itemsGrid.get(i).get(j);
                currentButton.setText(itemsOnPosition.get(j));
            }
        }
    }

    private Map<String, List<String>> getChosenItems() {
        Map<String, List<String>> items = new HashMap<>();
        for (int i = 0; i < itemsGrid.size(); i++) {
            items.put(indexToPosition.get(i), new ArrayList<>());
            for (Button button : itemsGrid.get(i)) {
                if (!Objects.equals(button.getText(), "Choose item")) {
                    items.get(indexToPosition.get(i)).add(button.getText());
                }
            }
        }
        return items;
    }

    private Map<String, String> getChosenPlayers() {
        Map<String, String> chosenPlayers = new HashMap<>();
        if (topChoiceBox.getValue() != null) chosenPlayers.put("top", topChoiceBox.getValue());
        if (jungleChoiceBox.getValue() != null) chosenPlayers.put("jungle", jungleChoiceBox.getValue());
        if (middleChoiceBox.getValue() != null) chosenPlayers.put("middle", middleChoiceBox.getValue());
        if (bottomChoiceBox.getValue() != null) chosenPlayers.put("bottom", bottomChoiceBox.getValue());
        if (supportChoiceBox.getValue() != null) chosenPlayers.put("support", supportChoiceBox.getValue());
        return chosenPlayers;
    }

    private boolean checkSameTeamPlayers(Map<String, String> chosenPlayers) {
        Map<String, Integer> playersPerTeam = new HashMap<>();
        AtomicBoolean goodTeam = new AtomicBoolean(true);
        chosenPlayers.values().forEach(player -> {
            String team = player.substring(0, player.indexOf(" "));
            if (playersPerTeam.containsKey(team)) {
                playersPerTeam.put(team, playersPerTeam.get(team) + 1);
                if (playersPerTeam.get(team) > maxSameTeamPlayers) {
                    goodTeam.set(false);
                }
            } else {
                playersPerTeam.put(team, 1);
            }
        });
        return goodTeam.get();
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
