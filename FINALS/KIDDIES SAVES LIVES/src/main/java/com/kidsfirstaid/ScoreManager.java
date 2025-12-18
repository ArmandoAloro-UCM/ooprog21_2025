package com.kidsfirstaid;

import java.io.*;
import java.util.*;

/**
 * Score manager - handles scores and achievements
 * Saves to file for persistence
 */
public class ScoreManager {
    private Map<String, Integer> moduleScores;
    private Map<String, Integer> moduleTotalQuestions;
    private Set<String> achievements;
    private int totalScore;
    private String saveFile = "scores.dat";
    
    public ScoreManager() {
        moduleScores = new HashMap<>();
        moduleTotalQuestions = new HashMap<>();
        achievements = new HashSet<>();
        totalScore = 0;
        loadScores();
    }
    
    public void addScore(String module, int score, int totalQuestions) {
        moduleScores.put(module, score);
        moduleTotalQuestions.put(module, totalQuestions);
        calculateTotalScore();
        saveScores();
        checkAchievements(module, score, totalQuestions);
    }
    
    public void addAchievement(String achievement) {
        if (achievements.add(achievement)) {
            saveScores();
            System.out.println("New achievement unlocked: " + achievement);
        }
    }
    
    public int getModuleScore(String module) {
        return moduleScores.getOrDefault(module, 0);
    }
    
    public int getTotalScore() {
        return totalScore;
    }
    
    public Set<String> getAchievements() {
        return new HashSet<>(achievements);
    }
    
    public String getScoreSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SCORE SUMMARY ===\n");
        sb.append("Total Score: ").append(totalScore).append("\n\n");
        
        sb.append("Module Scores:\n");
        for (String module : moduleScores.keySet()) {
            int score = moduleScores.get(module);
            int total = moduleTotalQuestions.get(module);
            int percentage = (score * 100) / total;
            sb.append(module).append(": ").append(score).append("/").append(total)
              .append(" (").append(percentage).append("%)\n");
        }
        
        sb.append("\nAchievements (").append(achievements.size()).append("):\n");
        for (String achievement : achievements) {
            sb.append("🏆 ").append(achievement).append("\n");
        }
        
        return sb.toString();
    }
    
    private void calculateTotalScore() {
        totalScore = moduleScores.values().stream().mapToInt(Integer::intValue).sum();
    }
    
    private void checkAchievements(String module, int score, int totalQuestions) {
        int percentage = (score * 100) / totalQuestions;
        
        if (score == totalQuestions) {
            addAchievement(module + " Perfect Score");
        }
        
        if (percentage >= 60) {
            addAchievement(module + " Completed");
        }
        
        if (percentage >= 80) {
            addAchievement(module + " Expert");
        }
        
        checkOverallAchievements();
    }
    
    private void checkOverallAchievements() {
        if (moduleScores.size() >= 4) {
            addAchievement("First Aid Hero");
        }
        
        if (totalScore >= 10) {
            addAchievement("Knowledge Seeker");
        }
        
        if (totalScore >= 15) {
            addAchievement("First Aid Master");
        }
        
        boolean allPerfect = true;
        for (String module : moduleScores.keySet()) {
            int score = moduleScores.get(module);
            int total = moduleTotalQuestions.get(module);
            if (score != total) {
                allPerfect = false;
                break;
            }
        }
        
        if (allPerfect && moduleScores.size() >= 4) {
            addAchievement("Perfect Student");
        }
    }
    
    private void saveScores() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            oos.writeObject(moduleScores);
            oos.writeObject(moduleTotalQuestions);
            oos.writeObject(achievements);
            oos.writeInt(totalScore);
        } catch (IOException e) {
            System.out.println("Could not save scores: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadScores() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveFile))) {
            moduleScores = (Map<String, Integer>) ois.readObject();
            moduleTotalQuestions = (Map<String, Integer>) ois.readObject();
            achievements = (Set<String>) ois.readObject();
            totalScore = ois.readInt();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Starting with fresh scores");
        }
    }
    
    public void resetAllScores() {
        moduleScores.clear();
        moduleTotalQuestions.clear();
        achievements.clear();
        totalScore = 0;
        
        File file = new File(saveFile);
        if (file.exists()) {
            file.delete();
        }
        
        System.out.println("All scores reset!");
    }
}