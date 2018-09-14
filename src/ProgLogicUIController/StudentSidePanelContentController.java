/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicUILoader.LoginUILoad;
import ProgLogicUILoader.QuizEntryUILoader;
import ProgLogicUILoader.ResultUILoader;
import ProgLogicUILoader.StudentLearnUILoader;
import ProgLogicUILoader.StudentQuizRecordUILoader;
import ProgLogicUILoader.StudentSettingsUILoader;
import ProgLogicUILoader.StudentShareLSUILoader;
import ProgLogicUILoader.TestChoiceUILoad;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import proglogictester.ProglogicScene;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class StudentSidePanelContentController implements Initializable {

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton b11;
    @FXML
    private JFXButton b111;
    @FXML
    private JFXButton b112;
    @FXML
    private JFXButton btnMain;

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
            case "Attend On Quiz":
                TestChoiceUILoad testChoiceUILoad = new TestChoiceUILoad(ProglogicScene.primarySatge);
                break;
            case "Quiz Record":
                StudentQuizRecordUILoader studentQuizRecordUILoader = new StudentQuizRecordUILoader(ProglogicScene.primarySatge);
                break;
            case "Learn":
                StudentLearnUILoader studentLearnUILoader = new StudentLearnUILoader(ProglogicScene.primarySatge);
                break;
            case "Share Learning Source":
                StudentShareLSUILoader shareLSUILoader = new StudentShareLSUILoader(ProglogicScene.primarySatge);
                break;
            case "Settings":
                StudentSettingsUILoader settingsUILoader = new StudentSettingsUILoader(ProglogicScene.primarySatge);
                break;
            case "Log Out":
                ProglogicScene.loginModel = null;
                LoginUILoad loginUILoad = new LoginUILoad(ProglogicScene.primarySatge);
                break;
        }
    }

}
