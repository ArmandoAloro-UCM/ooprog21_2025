package com.kidsfirstaid;

/**
 * Quiz question class for True/False questions
 */
public class QuizQuestion {
    private String question;
    private String imageDescription;
    private boolean correctAnswer; // true = correct, false = wrong
    
    public QuizQuestion(String question, String imageDescription, boolean correctAnswer) {
        this.question = question;
        this.imageDescription = imageDescription;
        this.correctAnswer = correctAnswer;
    }
    
    public String getQuestion() {
        return question;
    }
    
    public String getImageDescription() {
        return imageDescription;
    }
    
    public boolean isCorrectAnswer() {
        return correctAnswer;
    }
}