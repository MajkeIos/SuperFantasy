package controllers;

import database.UsersHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
        if (usernameField.getText().equals("") || passwordField.getText().equals("")
                || confirmPasswordField.getText().equals("")) {
            System.out.println("Some field is empty");
            //TODO
        } else if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            System.out.println("Different passwords");
            //TODO
        } else if (UsersHandler.checkIfUserExists(usernameField.getText())) {
            System.out.println("User already exists!");
            //TODO
        } else {
            UsersHandler.addUser(usernameField.getText(), passwordField.getText());
            usernameField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
        }
    }

    public void back(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/scenes/MenuScene.fxml")));
        loadScene(e, root);
    }

    private void loadScene(ActionEvent e, Parent root) {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
