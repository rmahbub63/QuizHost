/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.QuizResultDBController;
import ProgLogicModel.QuizResultModel;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import proglogictester.ProglogicScene;
import proglogictester.StudentHamburgerAndDrawerSet;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class StudentQuizRecordUIController implements Initializable {

    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private TableView<QuizResultModel> tblQuizResult;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmQuizName;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmTotalQues;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmCorrectAns;
    @FXML
    private TableColumn<QuizResultModel, String> tblClmScore;

    QuizResultDBController quizResultDBController = new QuizResultDBController();
    ArrayList<QuizResultModel> questionAnswerList = new ArrayList<QuizResultModel>();
    private ObservableList<QuizResultModel> quizResultModels;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        StudentHamburgerAndDrawerSet studentHamburgerAndDrawerSet = new StudentHamburgerAndDrawerSet(hamburger, drawer);
        questionAnswerList = quizResultDBController.getAllQuizResultByUsername(ProglogicScene.loginModel.getUsername());

        quizResultModels = FXCollections.observableArrayList(questionAnswerList);
        tblClmQuizName.setCellValueFactory(new PropertyValueFactory<>("quizName"));
        tblClmTotalQues.setCellValueFactory(new PropertyValueFactory<>("noOfQuestions"));
        tblClmCorrectAns.setCellValueFactory(new PropertyValueFactory<>("correctAnswer"));
        tblClmScore.setCellValueFactory(new PropertyValueFactory<>("scoreInPercent"));
        tblQuizResult.setItems(quizResultModels);
    }

}
