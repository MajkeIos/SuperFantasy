package controllers;

import database.tablesHandlers.UsersHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class LoginController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    private Parent root;

    public void login(ActionEvent e) throws IOException, SQLException {
        if (usernameField.getText().equals("")) {
            AlertBoxController.displayAlert("You haven't entered your username!");
        } else if (UsersHandler.getUser(usernameField.getText()) == null) {
            AlertBoxController.displayAlert("User " + usernameField.getText() + " doesn't exist!");
        } else if (passwordField.getText().equals("")) {
            AlertBoxController.displayAlert("You haven't entered your password!");
        } else {
            ResultSet user = UsersHandler.getUser(usernameField.getText());
            if (user == null) return;
            if (!user.getString("password").equals(passwordField.getText())) {
                AlertBoxController.displayAlert("You have entered wrong password!");
                return;
            }
            if (user.getBoolean("is_admin")) {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/AdminScene.fxml")));
            } else {
                ChooseRosterController.currentUser = usernameField.getText();
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/ChooseRosterScene.fxml")));
            }
            loadScene(e);
        }
    }

    public void back(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/MenuScene.fxml")));
        loadScene(e);
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
