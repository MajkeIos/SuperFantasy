package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utils.ItemsHandler;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChooseItemController implements Initializable {

    @FXML
    private Text chooseItemText;
    @FXML
    private Text itemDescriptionText;
    @FXML
    private ChoiceBox<String> itemTypeChoiceBox;
    @FXML
    private ChoiceBox<String> itemChoiceBox;
    @FXML
    private Label itemDescriptionLabel;
    @FXML
    private Button saveButton;

    public Button clickedButton;
    public ChooseRosterController chooseRosterController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemTypeChoiceBox.getItems().addAll(ItemsHandler.itemTypes);
        itemTypeChoiceBox.setOnAction(this::itemTypeChosen);
        itemChoiceBox.setOnAction(this::itemChosen);
        itemTypeNotChosen();
    }

    public void save(ActionEvent e) throws IOException {
        clickedButton.setText(itemChoiceBox.getValue());
        chooseRosterController.updateCost();
        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }

    private void itemTypeChosen(ActionEvent e) {
        itemChoiceBox.getItems().removeAll(itemChoiceBox.getItems());
        itemChoiceBox.getItems().addAll(Objects.requireNonNull(database.tablesHandlers.ItemsHandler.getItems(itemTypeChoiceBox.getValue())));
        chooseItemText.setVisible(true);
        itemChoiceBox.setVisible(true);
        itemNotChosen();
    }

    private void itemChosen(ActionEvent e) {
        itemDescriptionLabel.setText(database.tablesHandlers.ItemsHandler.getItemDescription(itemChoiceBox.getValue()));
        saveButton.setVisible(true);
        itemDescriptionText.setVisible(true);
        itemDescriptionLabel.setVisible(true);
    }

    private void itemNotChosen() {
        itemDescriptionText.setVisible(false);
        itemDescriptionLabel.setVisible(false);
        saveButton.setVisible(false);
    }

    private void itemTypeNotChosen() {
        itemTypeChoiceBox.setValue("");
        chooseItemText.setVisible(false);
        itemChoiceBox.setVisible(false);
        itemNotChosen();
    }

}
