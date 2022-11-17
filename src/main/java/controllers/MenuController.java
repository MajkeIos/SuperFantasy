package controllers;

import database.ConnectionHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MenuController {

    @FXML
    private Button quitButton;
    @FXML
    private AnchorPane scenePane;

    public void login(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/LoginScene.fxml")));
        loadScene(e, root);
    }

    public void register(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/RegisterScene.fxml")));
        loadScene(e, root);
    }

    public void quit(ActionEvent e) throws Exception {
        Alert quitAlert = new Alert(Alert.AlertType.CONFIRMATION);
        quitAlert.setTitle("Logout");
        quitAlert.setHeaderText("Are you sure you want to quit?");

        if (quitAlert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) scenePane.getScene().getWindow();
            ConnectionHandler.disconnect();
            stage.close();
        }
    }

    private void loadScene(ActionEvent e, Parent root) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
