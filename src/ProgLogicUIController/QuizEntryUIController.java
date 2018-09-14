/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.QuizDBController;
import ProgLogicModel.QuizModel;
import ProgLogicUILoader.QuestionEntryUILoader;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import proglogictester.ProglogicScene;
import proglogictester.TeacherHamburgerAndDrawerSet;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class QuizEntryUIController implements Initializable {

    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private TextField txtQuizName;
    @FXML
    private TextField txtNoOfQuestion;
    @FXML
    private TextField txtTime;
    @FXML
    private TextField txtAccessPass;

    // 
    QuizDBController quizDBController = new QuizDBController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TeacherHamburgerAndDrawerSet teacherHamburgerAndDrawerSet = new TeacherHamburgerAndDrawerSet(hamburger, drawer);
    }

    @FXML
    private void entryQuestionBtnAction(ActionEvent event) {
        QuizModel quizModel = new QuizModel();
        quizModel.setQuizId(txtQuizName.getText() + ProglogicScene.loginModel.getUsername());
        quizModel.setQuizName(txtQuizName.getText());
        quizModel.setNoOfQuestions(Integer.valueOf(txtNoOfQuestion.getText()));
        quizModel.setTime(Integer.valueOf(txtTime.getText()));
        quizModel.setAccessPass(txtAccessPass.getText());
        quizModel.setAddByUser(ProglogicScene.loginModel.getUsername());
        ProglogicScene.quizModel = quizModel;
        QuestionEntryUILoader questionEntryUILoader = new QuestionEntryUILoader(ProglogicScene.primarySatge);
    }

}
