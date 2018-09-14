/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicModel.QuizResultModel;
import ProgLogicUILoader.StudentQuizRecordUILoader;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import proglogictester.ProglogicScene;
import proglogictester.StudentHamburgerAndDrawerSet;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class StudentAfterQuizResultUIController implements Initializable {
    
    @FXML
    private Label lblQuizResultName;
    @FXML
    private TextField txtStudentID;
    @FXML
    private TextField txtTotalQuestion;
    @FXML
    private TextField txtCorrectAns;
    @FXML
    private TextField txtScore;
    @FXML
    private Button btnSave;
    
    QuizResultModel quizResultModel = new QuizResultModel();
    @FXML
    private TextField txtStudentName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.quizResultModel = ProglogicScene.quizResultModel;
        loadData();
    }
    
    public void loadData() {
        lblQuizResultName.setText(quizResultModel.getQuizName() + " Quiz Result");
        txtStudentName.setText(ProglogicScene.loginModel.getName());
        txtStudentID.setText(quizResultModel.getStudentId());
        txtTotalQuestion.setText(String.valueOf(quizResultModel.getNoOfQuestions()));
        txtCorrectAns.setText(String.valueOf(quizResultModel.getCorrectAnswer()));
        txtScore.setText(String.valueOf(quizResultModel.getScoreInPercent()));
    }
    
    @FXML
    private void btnSaveHandle(ActionEvent event) {
        StudentQuizRecordUILoader studentQuizRecordUILoader = new StudentQuizRecordUILoader(ProglogicScene.primarySatge);
    }
    
}
