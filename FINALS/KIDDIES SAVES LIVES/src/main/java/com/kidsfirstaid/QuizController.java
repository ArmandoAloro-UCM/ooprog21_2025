package com.kidsfirstaid;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the quiz screen
 */
public class QuizController {
    
    @FXML
    private Label questionLabel;
    
    @FXML
    private Button checkButton;
    
    @FXML
    private Button wrongButton;
    
    @FXML
    private Label feedbackLabel;
    
    @FXML
    private Button nextButton;
    
    private String currentModule;
    private int currentQuestion = 0;
    private int score = 0;
    private List<QuizQuestion> questions;
    private boolean answered = false;
    
    public void setModule(String moduleName) {
        this.currentModule = moduleName;
        this.currentQuestion = 0;
        this.score = 0;
        this.answered = false;
        loadQuestions();
        showQuestion();
    }
    
    @FXML
    private void initialize() {
        questions = new ArrayList<>();
        nextButton.setVisible(false);
    }
    
    @FXML
    private void handleBackButton() {
        loadScene("/fxml/modules.fxml");
    }
    
    @FXML
    private void handleCheckButton() {
        handleAnswer(true);
    }
    
    @FXML
    private void handleWrongButton() {
        handleAnswer(false);
    }
    
    @FXML
    private void handleNextButton() {
        currentQuestion++;
        showQuestion();
    }
    
    private void loadQuestions() {
        questions.clear();
        
        switch (currentModule) {
            case "SPRAINS":
                questions.add(new QuizQuestion("Should you REST the hurt part?", 
                    "Person resting with elevated foot", true));
                questions.add(new QuizQuestion("Should you put ICE directly on skin?", 
                    "Ice pack wrapped in towel", false));
                questions.add(new QuizQuestion("Should you WRAP it too tight?", 
                    "Bandage wrapped snugly", false));
                break;
            case "BURNS":
                questions.add(new QuizQuestion("Should you put BUTTER on a burn?", 
                    "Butter on burn", false));
                questions.add(new QuizQuestion("Should you use COOL WATER on a burn?", 
                    "Running cool water on burn", true));
                questions.add(new QuizQuestion("Should you POP blisters on a burn?", 
                    "Blister on skin", false));
                break;
            case "CPR":
                questions.add(new QuizQuestion("Should you CHECK if person is breathing?", 
                    "Checking breathing", true));
                questions.add(new QuizQuestion("Should you CALL for help first?", 
                    "Person calling 911", true));
                questions.add(new QuizQuestion("Should you push SLOWLY on chest?", 
                    "Chest compressions", false));
                break;
            case "CUTS":
                questions.add(new QuizQuestion("Should you WASH your hands first?", 
                    "Washing hands", true));
                questions.add(new QuizQuestion("Should you use DIRTY cloth to stop bleeding?", 
                    "Dirty cloth", false));
                questions.add(new QuizQuestion("Should you CLEAN the cut with soap and water?", 
                    "Cleaning cut", true));
                break;
        }
    }
    
    private void showQuestion() {
        if (currentQuestion >= questions.size()) {
            showResults();
            return;
        }
        
        QuizQuestion q = questions.get(currentQuestion);
        questionLabel.setText("Question " + (currentQuestion + 1) + ": " + q.getQuestion());
        
        checkButton.setDisable(false);
        wrongButton.setDisable(false);
        
        feedbackLabel.setText("");
        nextButton.setVisible(false);
        answered = false;
    }
    
    private void handleAnswer(boolean selectedAnswer) {
        if (answered) return;
        
        answered = true;
        QuizQuestion q = questions.get(currentQuestion);
        
        checkButton.setDisable(true);
        wrongButton.setDisable(true);
        
        if (selectedAnswer == q.isCorrectAnswer()) {
            score++;
            feedbackLabel.setText("✅ Correct!");
            feedbackLabel.setStyle("-fx-text-fill: #4CAF50; -fx-font-size: 28px; -fx-font-weight: bold;");
        } else {
            feedbackLabel.setText("❌ Wrong!");
            feedbackLabel.setStyle("-fx-text-fill: #F44336; -fx-font-size: 28px; -fx-font-weight: bold;");
        }
        
        nextButton.setVisible(true);
    }
    
    private void showResults() {
        int percentage = (score * 100) / questions.size();
        KidsFirstAidApp.getScoreManager().addScore(currentModule, score, questions.size());
        
        String message = String.format("Quiz Complete!\nScore: %d/%d (%d%%)", score, questions.size(), percentage);
        
        if (percentage >= 80) {
            message += "\n🏆 Excellent! You earned an achievement!";
            KidsFirstAidApp.getScoreManager().addAchievement(currentModule + " Expert");
        } else if (percentage >= 60) {
            message += "\n⭐ Good job! Keep learning!";
        } else {
            message += "\n📚 Keep studying and try again!";
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Quiz Results");
        alert.setHeaderText("Quiz Complete!");
        alert.setContentText(message);
        alert.showAndWait();
        
        loadScene("/fxml/modules.fxml");
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