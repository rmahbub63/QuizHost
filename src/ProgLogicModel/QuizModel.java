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
public class QuizModel {

    private int quizNo;
    private String quizId;
    private String quizName;
    private int noOfQuestions;
    private int time;
    private String accessPass;
    private String addByUser;

    public int getQuizNo() {
        return quizNo;
    }

    public void setQuizNo(int quizNo) {
        this.quizNo = quizNo;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getAccessPass() {
        return accessPass;
    }

    public void setAccessPass(String accessPass) {
        this.accessPass = accessPass;
    }

    public String getAddByUser() {
        return addByUser;
    }

    public void setAddByUser(String addByUser) {
        this.addByUser = addByUser;
    }
}
