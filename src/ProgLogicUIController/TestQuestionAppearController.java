/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.McqQuestionDBController;
import ProgLogicDBController.QuestionAnswerDBController;
import ProgLogicDBController.QuestionDBController;
import ProgLogicDBController.QuizResultDBController;
import ProgLogicModel.LoginModel;
import ProgLogicModel.McqQuestionModel;
import ProgLogicModel.QuestionAnswerModel;
import ProgLogicModel.QuestionModel;
import ProgLogicModel.QuizModel;
import ProgLogicModel.QuizResultModel;
import ProgLogicModel.TestModel;
import ProgLogicUILoader.StudentAfterQuizResultUILoader;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javax.swing.JOptionPane;
import proglogictester.ProglogicScene;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class TestQuestionAppearController implements Initializable {

    @FXML
    private StackPane mcqStackPane;
    @FXML
    private Label lblQuestion;
    @FXML
    private CheckBox checkOptionOne;
    @FXML
    private CheckBox checkOptionTwo;
    @FXML
    private CheckBox checkOptionThree;
    @FXML
    private CheckBox checkOptionFour;

    /**
     * Initializes the controller class.
     */
    QuestionDBController questionDBController = new QuestionDBController();
    ArrayList<QuestionModel> questionModelList = new ArrayList<QuestionModel>();
    ArrayList<QuestionAnswerModel> questionAnswerModelList = new ArrayList<QuestionAnswerModel>();
    @FXML
    private Button btnSubmit;
    @FXML
    private Label lblTotalQuestion;
    @FXML
    private Label lblTimeShow;
    @FXML
    private Label lblTestName;

    private int currentQuestionNO = 0;
    QuizModel quizModel = new QuizModel();
    LoginModel loginModel = new LoginModel();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.loginModel = ProglogicScene.loginModel;
        this.quizModel = ProglogicScene.quizModel;
        questionModelList = questionDBController.getAllQuestionByQuizIdAndQuizName(quizModel.getQuizId(), quizModel.getQuizName());
        nextQuestionUpload(currentQuestionNO);
        loadData();
    }

    public void loadData() {
        lblTestName.setText(quizModel.getQuizName());
        lblTotalQuestion.setText(String.valueOf(quizModel.getNoOfQuestions()));
        lblTimeShow.setText(String.valueOf(quizModel.getTime()));
        String userName = loginModel.getUsername();
        String quizId = quizModel.getQuizId();
        for (int i = 0; i < questionModelList.size(); i++) {
            QuestionAnswerModel questionAnswerModel = new QuestionAnswerModel();
            questionAnswerModel.setStudentId(userName);
            questionAnswerModel.setQuizId(quizId);
            questionAnswerModel.setQuestionNo(questionModelList.get(i).getQuestionNo());
            questionAnswerModel.setAnswer(questionModelList.get(i).getAnswer());
            questionAnswerModel.setStudentAnswer("");
            questionAnswerModel.setAnswerYet("No");
            questionAnswerModelList.add(questionAnswerModel);
        }
    }

    @FXML
    private void handleCheckOptionOne() {
        if (checkOptionOne.isSelected()) {
            checkOptionTwo.setSelected(false);
            checkOptionThree.setSelected(false);
            checkOptionFour.setSelected(false);
        }
    }

    @FXML
    private void handleCheckOptionTwo() {
        if (checkOptionTwo.isSelected()) {
            checkOptionOne.setSelected(false);
            checkOptionThree.setSelected(false);
            checkOptionFour.setSelected(false);
        }
    }

    @FXML
    private void handleCheckOptionThree() {
        if (checkOptionThree.isSelected()) {
            checkOptionOne.setSelected(false);
            checkOptionTwo.setSelected(false);
            checkOptionFour.setSelected(false);
        }
    }

    @FXML
    private void handleCheckOptionFour() {
        if (checkOptionFour.isSelected()) {
            checkOptionOne.setSelected(false);
            checkOptionThree.setSelected(false);
            checkOptionTwo.setSelected(false);
        }
    }

    @FXML
    private void handleSubmitButton() {
        String reply = "";
        if (checkOptionOne.isSelected()) {
            reply = checkOptionOne.getText();
        } else if (checkOptionTwo.isSelected()) {
            reply = checkOptionTwo.getText();
        } else if (checkOptionThree.isSelected()) {
            reply = checkOptionThree.getText();
        } else if (checkOptionFour.isSelected()) {
            reply = checkOptionFour.getText();
        } else {
            JOptionPane.showMessageDialog(null, "Select an option");
            reply = "";
        }
        if (!reply.equals("")) {
            questionAnswerModelList.get(currentQuestionNO).setStudentAnswer(reply);
            questionAnswerModelList.get(currentQuestionNO).setAnswerYet("Yes");

            currentQuestionNO++;
            nextQuestionUpload(currentQuestionNO);
        }

    }

    public void nextQuestionUpload(int i) {
        if (i < questionModelList.size()) {
//            System.out.println(i + "  " + questionModelList.size());
            uncheckallbox();
            lblQuestion.setText(questionModelList.get(i).getQuestionStatement());
            checkOptionOne.setText(questionModelList.get(i).getOptionOne());
            checkOptionTwo.setText(questionModelList.get(i).getOptionTwo());
            checkOptionThree.setText(questionModelList.get(i).getOptionThree());
            checkOptionFour.setText(questionModelList.get(i).getOptionFour());
        } else {
            int correct = 0;
            for (int j = 0; j < questionAnswerModelList.size(); j++) {
                if (questionAnswerModelList.get(j).getStudentAnswer().equals(questionAnswerModelList.get(j).getAnswer())) {
                    correct++;
                }
            }

            double scoreParcentage = (correct * 100) / Double.valueOf(quizModel.getNoOfQuestions());
            DecimalFormat df = new DecimalFormat(".##");

            QuizResultModel quizResultModel = new QuizResultModel();
            quizResultModel.setStudentId(loginModel.getUsername());
            quizResultModel.setQuizId(quizModel.getQuizId());
            quizResultModel.setQuizName(quizModel.getQuizName());
            quizResultModel.setNoOfQuestions(quizModel.getNoOfQuestions());
            quizResultModel.setCorrectAnswer(correct);
            quizResultModel.setScoreInPercent(Double.valueOf(df.format(scoreParcentage)));

            QuizResultDBController quizResultDBController = new QuizResultDBController();
            quizResultDBController.saveQuizResult(quizResultModel);
            ProglogicScene.quizResultModel = quizResultModel;
            QuestionAnswerDBController questionAnswerDBController = new QuestionAnswerDBController();
            questionAnswerDBController.saveAllQuestionAnswer(questionAnswerModelList);
            StudentAfterQuizResultUILoader studentAfterQuizResultUILoader = new StudentAfterQuizResultUILoader(ProglogicScene.primarySatge);
//            JOptionPane.showMessageDialog(null, "Done and correct " + correct + " percentage " + df.format(scoreParcentage));
        }
    }

    public void uncheckallbox() {
        checkOptionOne.setSelected(false);
        checkOptionTwo.setSelected(false);
        checkOptionThree.setSelected(false);
        checkOptionFour.setSelected(false);
    }
}
