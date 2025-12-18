package com.kidsfirstaid;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controller for the modules menu screen
 */
public class ModulesController {
    
    @FXML
    private void handleBackButton() {
        loadScene("/fxml/welcome.fxml");
    }
    
    @FXML
    private void handleSprainsButton() {
        loadContentScene("SPRAINS");
    }
    
    @FXML
    private void handleBurnsButton() {
        loadContentScene("BURNS");
    }
    
    @FXML
    private void handleCPRButton() {
        loadContentScene("CPR");
    }
    
    @FXML
    private void handleCutsButton() {
        loadContentScene("CUTS");
    }
    
    @FXML
    private void handleHotlineButton() {
        loadContentScene("HOTLINE");
    }
    
    @FXML
    private void handleAboutUsButton() {
        loadScene("/fxml/aboutus.fxml");
    }
    
    private void loadContentScene(String moduleName) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/content.fxml"));
            Parent root = loader.load();
            
            ContentController controller = loader.getController();
            controller.setModule(moduleName);
            
            Scene scene = new Scene(root, 1000, 800);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
            
            Stage stage = KidsFirstAidApp.getPrimaryStage();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void loadScene(String fxmlPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Scene scene = new Scene(root, 1000, 800);
            scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
            
            Stage stage = KidsFirstAidApp.getPrimaryStage();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}