/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicModel;

/**
 *
 * @author MAHBUB
 */
public class QuizResultModel {

    private String studentId;
    private String quizId;
    private String quizName;
    private int noOfQuestions;
    private int correctAnswer;
    private double scoreInPercent;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(int noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public double getScoreInPercent() {
        return scoreInPercent;
    }

    public void setScoreInPercent(double scoreInPercent) {
        this.scoreInPercent = scoreInPercent;
    }
    
    

}
