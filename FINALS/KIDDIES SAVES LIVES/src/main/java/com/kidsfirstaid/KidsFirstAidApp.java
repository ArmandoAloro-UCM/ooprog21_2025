package com.kidsfirstaid;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main application class for Kids First Aid
 * Entry point of the JavaFX application
 */
public class KidsFirstAidApp extends Application {
    
    private static Stage primaryStage;
    private static ScoreManager scoreManager;
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        scoreManager = new ScoreManager();
        
        // Load welcome screen
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/welcome.fxml"));
        Scene scene = new Scene(root, 1000, 800);
        scene.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());
        
        primaryStage.setTitle("Kiddies Save Lives - Kids First Aid");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static ScoreManager getScoreManager() {
        return scoreManager;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}