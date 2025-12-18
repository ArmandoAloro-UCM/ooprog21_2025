package com.kidsfirstaid;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Controller for the content reading screen
 */
public class ContentController {
    
    @FXML
    private WebView contentWebView;
    
    @FXML
    private Button prevButton;
    
    @FXML
    private Button nextButton;
    
    @FXML
    private Label pageLabel;
    
    private String currentModule;
    private int currentPage = 0;
    private int totalPages = 4;
    
    public void setModule(String moduleName) {
        this.currentModule = moduleName;
        this.currentPage = 0;
        updateContent();
    }
    
    @FXML
    private void initialize() {
        prevButton.setDisable(true);
    }
    
    @FXML
    private void handleBackButton() {
        loadScene("/fxml/modules.fxml");
    }
    
    @FXML
    private void handlePrevButton() {
        if (currentPage > 0) {
            currentPage--;
            updateContent();
        }
    }
    
    @FXML
    private void handleNextButton() {
        if (currentPage < totalPages - 1) {
            currentPage++;
            updateContent();
        } else {
            // Last page - show dialog
            showEndOfModuleDialog();
        }
    }
    
    private void updateContent() {
        String content = getContentForModule(currentModule, currentPage);
        contentWebView.getEngine().loadContent(content);
        
        pageLabel.setText("Page " + (currentPage + 1) + " of " + totalPages);
        prevButton.setDisable(currentPage == 0);
        nextButton.setText(currentPage == totalPages - 1 ? "Finish" : "Next");
    }
    
    private void showEndOfModuleDialog() {
        if (currentModule.equals("HOTLINE")) {
            // No quiz for HOTLINE
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Module Complete");
            alert.setHeaderText("You've finished the " + currentModule + " module!");
            alert.setContentText("Click OK to return to the menu.");
            alert.showAndWait();
            loadScene("/fxml/modules.fxml");
        } else {
            // Show quiz or menu options
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Module Complete");
            alert.setHeaderText("You've finished reading the " + currentModule + " module!");
            alert.setContentText("What would you like to do?");
            
            ButtonType quizButton = new ButtonType("Take Quiz");
            ButtonType menuButton = new ButtonType("Back to Menu");
            
            alert.getButtonTypes().setAll(quizButton, menuButton);
            
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == quizButton) {
                loadQuizScene();
            } else {
                loadScene("/fxml/modules.fxml");
            }
        }
    }
    
    private void loadQuizScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/quiz.fxml"));
            Parent root = loader.load();
            
            QuizController controller = loader.getController();
            controller.setModule(currentModule);
            
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
    
    private String getContentForModule(String module, int page) {
        String baseStyle = "<style>" +
            "body { font-family: Arial, sans-serif; padding: 20px; background-color: white; }" +
            "h2 { color: #F4A261; font-size: 28px; margin-bottom: 15px; }" +
            "p { font-size: 18px; line-height: 1.6; margin: 10px 0; }" +
            "b { color: #00008B; }" +
            "ul { margin: 10px 0; padding-left: 30px; }" +
            "li { margin: 8px 0; font-size: 18px; }" +
            "</style>";
        
        String content = baseStyle;
        
        switch (module) {
            case "CPR":
                switch (page) {
                    case 0:
                        content += "<h2>CPR - Step 1: Check (A, B, C)</h2>" +
                                   "<p><b>Airways, Breathing, Circulation:</b></p>" +
                                   "<ul><li><b>Airways:</b> Make sure nothing is blocking the person's mouth or nose.</li>" +
                                   "<li><b>Breathing:</b> Look to see if their chest is moving up and down. Listen for breathing sounds.</li>" +
                                   "<li><b>Circulation:</b> Check for any signs of life like movement or coughing.</li></ul>";
                        break;
                    case 1:
                        content += "<h2>CPR - Step 2: Call for Help</h2>" +
                                   "<ul><li>Ask someone nearby to call for help. Tell them it's an emergency.</li>" +
                                   "<li>If you're alone, try to call for help yourself before starting CPR.</li></ul>";
                        break;
                    case 2:
                        content += "<h2>CPR - Step 3: Push Hard and Fast</h2>" +
                                   "<p><b>30 Compressions and 2 Rescue Breaths:</b></p>" +
                                   "<ul><li>Place your hands in the middle of the person's chest.</li>" +
                                   "<li>Push down hard about 2 inches (5 cm) and fast (about 100-120 pushes per minute).</li>" +
                                   "<li>After 30 pushes, give 2 rescue breaths: tilt their head back, pinch their nose, and blow into their mouth to make their chest rise.</li></ul>";
                        break;
                    case 3:
                        content += "<h2>CPR - Step 4: Keep Going</h2>" +
                                   "<ul><li>Keep doing this (30 compressions and 2 breaths) until help arrives.</li>" +
                                   "<li><b>Remember:</b> Only trained people should do CPR, but it's good to know the steps!</li></ul>";
                        break;
                }
                break;
            case "BURNS":
                switch (page) {
                    case 0:
                        content += "<h2>Burns - Step 1: Cool the Burn</h2>" +
                                   "<ul><li>Put the burn under cool (not cold) running water for about 10-20 minutes.</li>" +
                                   "<li>This helps stop the burning and eases the pain.</li></ul>";
                        break;
                    case 1:
                        content += "<h2>Burns - Step 2: Cover It</h2>" +
                                   "<ul><li>Put a clean, dry bandage or cloth over the burn to protect it.</li></ul>";
                        break;
                    case 2:
                        content += "<h2>Burns - Step 3: Don't Touch</h2>" +
                                   "<ul><li>Don't put any cream, ointment, or butter on the burn.</li>" +
                                   "<li>Let a grown-up decide what to do next because some burns need special care.</li></ul>";
                        break;
                    case 3:
                        content += "<h2>Burns - Important Reminders</h2>" +
                                   "<ul><li>Never pop blisters on a burn</li>" +
                                   "<li>Always get adult help for serious burns</li>" +
                                   "<li>Keep the burn clean and covered</li></ul>";
                        break;
                }
                break;
            case "CUTS":
                switch (page) {
                    case 0:
                        content += "<h2>Cuts - Step 1: Wash Your Hands or Wear Gloves</h2>" +
                                   "<ul><li>Make sure your hands are clean to keep germs away from the cut.</li>" +
                                   "<li>If you have gloves, wear them.</li></ul>";
                        break;
                    case 1:
                        content += "<h2>Cuts - Step 2: Stop the Bleeding</h2>" +
                                   "<ul><li>Put a clean cloth on the cut and press gently.</li>" +
                                   "<li>Keep pressing until the bleeding stops.</li></ul>";
                        break;
                    case 2:
                        content += "<h2>Cuts - Step 3: Clean the Cut</h2>" +
                                   "<ul><li>Wash the cut with soap and water to clean out any dirt or germs.</li></ul>";
                        break;
                    case 3:
                        content += "<h2>Cuts - Step 4: Cover It</h2>" +
                                   "<ul><li>Put a bandage on the cut to keep it clean and help it heal.</li>" +
                                   "<li><b>Remember:</b> If the cut is big or won't stop bleeding, get adult help immediately!</li></ul>";
                        break;
                }
                break;
            case "SPRAINS":
                switch (page) {
                    case 0:
                        content += "<h2>Sprains - Step 1: Rest</h2>" +
                                   "<ul><li>Stop using the hurt part (like your ankle or wrist).</li>" +
                                   "<li>Don't walk on it or move it too much.</li></ul>";
                        break;
                    case 1:
                        content += "<h2>Sprains - Step 2: Ice</h2>" +
                                   "<ul><li>Put ice wrapped in a cloth on the hurt part for about 20 minutes at a time.</li>" +
                                   "<li>This helps with the swelling and pain.</li></ul>";
                        break;
                    case 2:
                        content += "<h2>Sprains - Step 3: Wrap It</h2>" +
                                   "<ul><li>Wrap the hurt part with a bandage, but not too tight.</li>" +
                                   "<li>It should feel snug, not like it's cutting off your circulation.</li></ul>";
                        break;
                    case 3:
                        content += "<h2>Sprains - Step 4: Lift It Up</h2>" +
                                   "<ul><li>Keep the hurt part lifted up on a pillow or something to help reduce swelling.</li>" +
                                   "<li><b>Remember RICE:</b> Rest, Ice, Compression, Elevation</li></ul>";
                        break;
                }
                break;
            case "HOTLINE":
                switch (page) {
                    case 0:
                        content += "<h2>Emergency Hotlines</h2>" +
                                   "<p style='font-size: 24px; color: #00008B;'><b>General Hotline: 911</b></p>" +
                                   "<p><b>Cebu City Fire Station:</b></p>" +
                                   "<ul><li>09427907907</li><li>(032) 256-0541</li><li>(032) 256-0542</li></ul>" +
                                   "<p><b>Luz Ambulance:</b> 09276228370</p>";
                        break;
                    case 1:
                        content += "<h2>When to Call the Hotline</h2>" +
                                   "<p>Call 911 or emergency numbers when:</p>" +
                                   "<ul><li>Someone is badly hurt</li><li>There's a fire</li>" +
                                   "<li>Someone can't breathe</li><li>Someone won't wake up</li></ul>";
                        break;
                    case 2:
                        content += "<h2>How to Call for Help</h2>" +
                                   "<ul><li>Stay calm and speak clearly</li><li>Tell them your location</li>" +
                                   "<li>Explain what happened</li><li>Answer their questions</li>" +
                                   "<li>Don't hang up until they tell you to</li></ul>";
                        break;
                    case 3:
                        content += "<h2>Important Reminders</h2>" +
                                   "<ul><li>Only call for real emergencies</li>" +
                                   "<li>Keep emergency numbers where you can see them</li>" +
                                   "<li>Know your home address</li>" +
                                   "<li>Practice what to say in an emergency</li></ul>";
                        break;
                }
                break;
        }
        
        return content;
    }
}