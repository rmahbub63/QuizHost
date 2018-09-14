/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.LoginDBController;
import ProgLogicModel.LoginModel;
import ProgLogicUILoader.LoginUILoad;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import proglogictester.ProglogicScene;
import proglogictester.StudentHamburgerAndDrawerSet;

/**
 * FXML Controller class
 *
 * @author MAHBUB
 */
public class StudentSettingsUIController implements Initializable {

    @FXML
    private JFXDrawer drawer;
    @FXML
    private JFXHamburger hamburger;
    @FXML
    private TextField txtName;
    @FXML
    private PasswordField txtNewPassword;
    @FXML
    private PasswordField txtConfirmPass;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtOldPassword;
    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnClear;
    
    LoginModel loginModel = new LoginModel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        StudentHamburgerAndDrawerSet studentHamburgerAndDrawerSet = new StudentHamburgerAndDrawerSet(hamburger, drawer);
        this.loginModel = ProglogicScene.loginModel;
        
        txtName.setText(loginModel.getName());
        txtUsername.setText(loginModel.getUsername());
    }

    @FXML
    private void btnUpdateHandle(ActionEvent event) {
        LoginDBController loginDBController = new LoginDBController();
        LoginModel loginModel = new LoginModel();
        String name = txtName.getText();
        String username = txtUsername.getText();
//        String oldPassword = txtOldPassword.getText();
        String newPassword = txtNewPassword.getText();
//        String confirmpass = txtConfirmPass.getText();

        if (valid()) {
            loginModel.setName(name);
            loginModel.setUsername(username);
            loginModel.setPassword(newPassword);
            loginDBController.updateUser(loginModel);
            LoginUILoad loginUILoad = new LoginUILoad(ProglogicScene.primarySatge);
        }
    }

    public boolean valid() {
        boolean value = true;
        if (txtName.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Insert Username");
            alert.showAndWait();
            return value;
        }
        if (txtUsername.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Insert Username");
            alert.showAndWait();
            return value;
        }
        if (txtOldPassword.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Insert Password");
            alert.showAndWait();
            return value;
        }
        if (txtNewPassword.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Insert Password");
            alert.showAndWait();
            return value;
        }
        if (txtConfirmPass.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Confirm Password");
            alert.showAndWait();
            return value;
        }
        if (!txtOldPassword.getText().equals(ProglogicScene.loginModel.getPassword())) {
            value = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Don't match");
            alert.setContentText("Current Pass Don't match");
            alert.showAndWait();
            txtConfirmPass.setText("");
            return value;
        }
        if (!txtNewPassword.getText().equals(txtConfirmPass.getText())) {
            value = false;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Don't match");
            alert.setContentText("Don't match");
            alert.showAndWait();
            txtConfirmPass.setText("");
            return value;
        }
        return value;
    }

    @FXML
    private void btnClearHandle(ActionEvent event) {
    }

}
