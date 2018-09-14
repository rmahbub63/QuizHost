/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.QuizDBController;
import ProgLogicDBController.QuizResultDBController;
import ProgLogicModel.QuizModel;
import ProgLogicModel.QuizResultModel;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import proglogictester.ProglogicScene;
import proglogictester.TeacherHamburgerAndDrawerSet;

/**
 * FXML Controller class
 *
 * @author Sayem Zaman
 */
public class ResultUIController implements Initializable {

    @FXML
    private ComboBox<String> cmbSelectQuiz;
    @FXML
    private TableView<QuizResultModel> tblQuizResult;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmID;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmTotalQues;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmCorrectAns;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmScore;
    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;

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
    private void quizChoiceHandle(ActionEvent event) {
        QuizModel quizModel = new QuizModel();
        quizModel = quizDBController.getQuizByQuizName(cmbSelectQuiz.getValue());

        QuizResultDBController quizResultDBController = new QuizResultDBController();
        ArrayList<QuizResultModel> questionAnswerList = new ArrayList<QuizResultModel>();
        ObservableList<QuizResultModel> quizResultModels;

        questionAnswerList = quizResultDBController.getAllQuizResultByQuizID(quizModel.getQuizId());

        quizResultModels = FXCollections.observableArrayList(questionAnswerList);
        tblClmID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblClmTotalQues.setCellValueFactory(new PropertyValueFactory<>("noOfQuestions"));
        tblClmCorrectAns.setCellValueFactory(new PropertyValueFactory<>("correctAnswer"));
        tblClmScore.setCellValueFactory(new PropertyValueFactory<>("scoreInPercent"));
        tblQuizResult.setItems(quizResultModels);
    }

}
