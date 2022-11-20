package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class AlertBoxController {

    @FXML Button closeButton;
    @FXML Text errorMessage;

    @FXML
    void closeButton() {
        Stage alertBox = (Stage) closeButton.getScene().getWindow();
        alertBox.close();
    }

    public static void displayAlert(String msg) throws IOException {
        Stage alertBox = new Stage();
        alertBox.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(AlertBoxController.class.getResource("/scenes/AlertBox.fxml"));
        Parent root = loader.load();

        AlertBoxController alertBoxController = loader.getController();
        alertBoxController.errorMessage.setText(msg);

        alertBox.setScene(new Scene(root));
        alertBox.showAndWait();

        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        alertBox.setX((primScreenBounds.getWidth() - alertBox.getWidth()) / 2);
        alertBox.setY((primScreenBounds.getHeight() - alertBox.getHeight()) / 2);
    }
}