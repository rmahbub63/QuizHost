/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicUILoader.LoginUILoad;
import ProgLogicUILoader.ModifyQuizUILoader;
import ProgLogicUILoader.QuestionEntryUILoader;
import ProgLogicUILoader.QuizEntryUILoader;
import ProgLogicUILoader.QuizResultTeacherUILoader;
import ProgLogicUILoader.ResultUILoader;
import ProgLogicUILoader.StudentSettingsUILoader;
import ProgLogicUILoader.TeacherSettingsUILoader;
import ProgLogicUILoader.TeacherShareLSUILoader;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import proglogictester.ProglogicScene;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class TeacherSidePanelContentController implements Initializable {

    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;
    @FXML
    private JFXButton b11;
    @FXML
    private JFXButton b111;
    @FXML
    private JFXButton btnMain;
    @FXML
    private JFXButton b121;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnMain.setText(ProglogicScene.loginModel.getName() + "\n(" + ProglogicScene.loginModel.getUsername() + ")");

    }

    @FXML
    private void menuChoice(ActionEvent event) {
        JFXButton btn = (JFXButton) event.getSource();
//        System.out.println(btn.getText());
        switch (btn.getText()) {
            case "Quiz Entry":
                QuizEntryUILoader quizEntryUILoader = new QuizEntryUILoader(ProglogicScene.primarySatge);
                break;
            case "Quiz Result":
                ResultUILoader resultUI = new ResultUILoader(ProglogicScene.primarySatge);
                break;
            case "Modify Quiz":
                ModifyQuizUILoader modifyQuizUILoader = new ModifyQuizUILoader(ProglogicScene.primarySatge);
                break;
            case "Settings":
                TeacherSettingsUILoader teacherSettingsUILoader = new TeacherSettingsUILoader(ProglogicScene.primarySatge);
                break;
            case "Share Learning Source":
                TeacherShareLSUILoader teacherShareLSUILoader = new TeacherShareLSUILoader(ProglogicScene.primarySatge);
                break;
            case "Log Out":
                ProglogicScene.loginModel = null;
                LoginUILoad loginUILoad = new LoginUILoad(ProglogicScene.primarySatge);
                break;
        }
    }

}
