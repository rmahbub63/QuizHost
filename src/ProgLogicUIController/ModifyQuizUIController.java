/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.QuizDBController;
import ProgLogicDBController.QuizResultDBController;
import ProgLogicModel.QuizModel;
import ProgLogicUILoader.ModifyQuizUILoader;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import proglogictester.ProglogicScene;
import proglogictester.TeacherHamburgerAndDrawerSet;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class ModifyQuizUIController implements Initializable {

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
    @FXML
    private ComboBox<String> cmbSelectQuiz;

    QuizDBController quizDBController = new QuizDBController();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TeacherHamburgerAndDrawerSet teacherHamburgerAndDrawerSet = new TeacherHamburgerAndDrawerSet(hamburger, drawer);
        loadData();
    }

    public void loadData() {
        ArrayList<QuizModel> quizModels = new ArrayList<QuizModel>();
        quizModels = quizDBController.getAllQuizByTEacherID(ProglogicScene.loginModel.getUsername());

        for (int i = 0; i < quizModels.size(); i++) {
            cmbSelectQuiz.getItems().add(quizModels.get(i).getQuizName());
        }
    }

    @FXML
    private void entryUpdateBtnAction(ActionEvent event) {
        QuizModel quizModel = new QuizModel();
        quizModel.setQuizId(txtQuizName.getText() + ProglogicScene.loginModel.getUsername());
        quizModel.setQuizName(txtQuizName.getText());
        quizModel.setNoOfQuestions(Integer.valueOf(txtNoOfQuestion.getText()));
        quizModel.setTime(Integer.valueOf(txtTime.getText()));
        quizModel.setAccessPass(txtAccessPass.getText());
        quizModel.setAddByUser(ProglogicScene.loginModel.getUsername());
        
        quizDBController.updateQuizModel(quizModel);
        
        ModifyQuizUILoader modifyQuizUILoader = new ModifyQuizUILoader(ProglogicScene.primarySatge);
    }

    @FXML
    private void quizChoiceHandle(ActionEvent event) {
        QuizModel quizModel = new QuizModel();
        quizModel = quizDBController.getQuizByQuizName(cmbSelectQuiz.getValue());
        
        txtQuizName.setText(quizModel.getQuizName());
        txtNoOfQuestion.setText(String.valueOf(quizModel.getNoOfQuestions()));
        txtTime.setText(String.valueOf(quizModel.getTime()));
        txtAccessPass.setText(quizModel.getAccessPass());
    }

}
