/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.QuestionDBController;
import ProgLogicDBController.QuizDBController;
import ProgLogicModel.QuestionModel;
import ProgLogicModel.QuizModel;
import ProgLogicUILoader.SolvingProblemsUILoad;
import ProgLogicUILoader.TestChoiceUILoad;
import ProgLogicUILoader.TestQuestionAppearUILoader;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import proglogictester.ProglogicScene;
import proglogictester.StudentHamburgerAndDrawerSet;

/**
 * FXML Controller class
 *
 * @author Sayem Zaman
 */
public class TestChoiceUIController implements Initializable {

    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private ComboBox<String> cmbTestChoice;
    QuizDBController quizDBController = new QuizDBController();
    @FXML
    private PasswordField txtAccessPass;
    @FXML
    private Button btnAttendOnQuiz;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
        StudentHamburgerAndDrawerSet studentHamburgerAndDrawerSet = new StudentHamburgerAndDrawerSet(hamburger, drawer);
        loadData();
    }

    public void loadData() {

        ArrayList<QuizModel> quizModels = new ArrayList<QuizModel>();
        quizModels = quizDBController.getAllQuiz();

        for (int i = 0; i < quizModels.size(); i++) {
            cmbTestChoice.getItems().add(quizModels.get(i).getQuizName());
        }
    }

    private void btnSolveProbHandle(ActionEvent event) {
        SolvingProblemsUILoad solvingProblemsUILoad = new SolvingProblemsUILoad(ProglogicScene.primarySatge);
    }

    @FXML
    private void quizChoiceHandle(ActionEvent event) {
        QuizModel quizModel = new QuizModel();
        quizModel = quizDBController.getQuizByQuizName(cmbTestChoice.getValue());
        ProglogicScene.quizModel = quizModel;

        QuestionDBController questionDBController = new QuestionDBController();
        ArrayList<QuestionModel> questionModelList = new ArrayList<QuestionModel>();
        questionModelList = questionDBController.getAllQuestionByQuizIdAndQuizName(quizModel.getQuizId(), quizModel.getQuizName());

        String pass = txtAccessPass.getText();
        if (questionModelList.size() > 0 && quizModel.getAccessPass().equals(pass)) {
            TestQuestionAppearUILoader testQuestionAppearUILoader = new TestQuestionAppearUILoader(ProglogicScene.primarySatge);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect");
            alert.setHeaderText("");
            alert.setContentText("Access Pass Incorrect");
            alert.showAndWait();
            TestChoiceUILoad testChoiceUILoad = new TestChoiceUILoad(ProglogicScene.primarySatge);
        }
    }

}
