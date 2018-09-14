/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.LoginDBController;
import ProgLogicModel.LoginModel;
import ProgLogicUILoader.NewAccountUILoad;
import ProgLogicUILoader.QuizEntryUILoader;
import ProgLogicUILoader.TestChoiceUILoad;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import proglogictester.ProglogicScene;

/**
 * FXML Controller class
 *
 * @author HASAN
 */
public class HomeLoginController implements Initializable {

    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnNewAccount;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtUsername.setText("mahbub");
        txtPassword.setText("q");
    }

    @FXML
    private void btnLogin(ActionEvent event) {
        LoginModel loginModel = new LoginModel();
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        LoginDBController loginDBController = new LoginDBController();

        loginModel = loginDBController.getLoginInfoByUserName(username);
        if (loginModel.getUsername() != null && loginModel.getUsername() != "") {
            if (loginModel.getPassword().equals(password)) {
                ProglogicScene.loginModel = loginModel;
                System.out.println(loginModel.getRole());
                if (loginModel.getRole().equals("Teacher")) {
                    QuizEntryUILoader quizEntryUILoader = new QuizEntryUILoader(ProglogicScene.primarySatge);
                } else if (loginModel.getRole().equals("Student")) {
                    TestChoiceUILoad testChoiceUILoad = new TestChoiceUILoad(ProglogicScene.primarySatge);
                } else {
                    JOptionPane.showMessageDialog(null, "No Option For Admin");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No ID");
        }
    }

    @FXML
    private void btnNewAccount(ActionEvent event) {
        NewAccountUILoad newAccountUILoad = new NewAccountUILoad(ProglogicScene.primarySatge);
    }

}
