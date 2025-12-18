package com.kidsfirstaid;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for the welcome screen
 */
public class WelcomeController {
    
    @FXML
    private void handleStartButton() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/modules.fxml"));
            Scene scene = new Scene(root, 1000, 800);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
            
            Stage stage = KidsFirstAidApp.getPrimaryStage();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}