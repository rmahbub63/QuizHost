/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.QuestionDBController;
import ProgLogicDBController.QuizDBController;
import ProgLogicModel.QuestionModel;
import ProgLogicUILoader.QuizEntryUILoader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import proglogictester.ProglogicScene;

/**
 * FXML Controller class
 *
 * @author HASAN
 */
public class QuestionEntryUIController implements Initializable {

    @FXML
    private TextField txtOptionOne;
    @FXML
    private TextField txtOptionTwo;
    @FXML
    private TextField txtOptionThree;
    @FXML
    private TextField txtOptionFour;
    @FXML
    private TextField txtCorrectAns;
    @FXML
    private TextField txtQuesStatement;
    @FXML
    private Button btnSubmit;
    @FXML
    private Label lblEntryNumber;
    @FXML
    private Label lblEntryQuestion;
    @FXML
    private ProgressBar pbShowSubmit;

    //
    QuizDBController quizDBController = new QuizDBController();
    QuestionDBController questionDBController = new QuestionDBController();
    ArrayList<QuestionModel> questionModelList = new ArrayList<QuestionModel>();
    int countNoOfQuestion = 1;
    int totalNoOfQuestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        totalNoOfQuestion = ProglogicScene.quizModel.getNoOfQuestions();
        lblEntryQuestion.setText("Entry Question for " + ProglogicScene.quizModel.getQuizName());
        lblEntryNumber.setText("1 out of " + totalNoOfQuestion);
        float pbValue = (float) (1.0 / totalNoOfQuestion);
        pbShowSubmit.setProgress(pbValue);
    }

    @FXML
    private void btnSubmitAction(ActionEvent event) {
        String quizId = ProglogicScene.quizModel.getQuizId();
        String quizName = ProglogicScene.quizModel.getQuizName();
        if (countNoOfQuestion <= totalNoOfQuestion) {
            QuestionModel questionModel = new QuestionModel();
            questionModel.setQuestionStatement(txtQuesStatement.getText());
            questionModel.setOptionOne(txtOptionOne.getText());
            questionModel.setOptionTwo(txtOptionTwo.getText());
            questionModel.setOptionThree(txtOptionThree.getText());
            questionModel.setOptionFour(txtOptionFour.getText());
            questionModel.setQuizId(quizId);
            questionModel.setQuizName(quizName);
            questionModel.setAnswer(txtCorrectAns.getText());
            questionModelList.add(questionModel);

            if (countNoOfQuestion == totalNoOfQuestion) {
                if (questionDBController.saveAllQuestion(questionModelList) && quizDBController.saveQuiz(ProglogicScene.quizModel)) {
                    JOptionPane.showMessageDialog(null, "All Question Saved");
                    QuizEntryUILoader quizEntryUILoader = new QuizEntryUILoader(ProglogicScene.primarySatge);
                    ProglogicScene.quizModel = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Sorry Something Wrong");
                }
            } else {
                countNoOfQuestion++;
                lblEntryNumber.setText(String.valueOf(countNoOfQuestion) + " out of " + totalNoOfQuestion);
                float pbValue = (float) (1.0 / totalNoOfQuestion) * countNoOfQuestion;
                pbShowSubmit.setProgress(pbValue);
                clearTextField();
            }

        } else {

        }
    }

    public void clearTextField() {
        txtQuesStatement.setText("");
        txtOptionOne.setText("");
        txtOptionTwo.setText("");
        txtOptionThree.setText("");
        txtOptionFour.setText("");
        txtCorrectAns.setText("");
    }

}
