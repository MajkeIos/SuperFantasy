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
import java.util.Objects;

public class RegisterController {

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;

    public void register(ActionEvent e) throws IOException {
        if (usernameField.getText().equals("")) {
            AlertBoxController.displayAlert("You haven't chosen username!");
        } else if (UsersHandler.getUser(usernameField.getText()) != null) {
            AlertBoxController.displayAlert("User " + usernameField.getText() + " already exists!");
        } else if (passwordField.getText().equals("")) {
            AlertBoxController.displayAlert("You haven't chosen password!");
        } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            AlertBoxController.displayAlert("Your given passwords don't match");
        }  else {
            UsersHandler.addUser(usernameField.getText(), passwordField.getText());
            AlertBoxController.displayAlert("You have successfully registered!");
            clearData();
        }
    }

    public void back(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/MenuScene.fxml")));
        loadScene(e, root);
    }

    private void clearData() {
        usernameField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    private void loadScene(ActionEvent e, Parent root) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
    }
}
