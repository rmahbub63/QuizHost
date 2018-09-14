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
public class TestModel {
    
    private int testNo;
    private String testName;
    private int time;
    private int totalQuestion;
    private String accessPass;
    private String examineePass;
    
    public TestModel(){
    }

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTotalQuestion() {
        return totalQuestion;
    }

    public void setTotalQuestion(int totalQuestion) {
        this.totalQuestion = totalQuestion;
    }

    public String getAccessPass() {
        return accessPass;
    }

    public void setAccessPass(String accessPass) {
        this.accessPass = accessPass;
    }

    public String getExamineePass() {
        return examineePass;
    }

    public void setExamineePass(String examineePass) {
        this.examineePass = examineePass;
    }
    
    
}
