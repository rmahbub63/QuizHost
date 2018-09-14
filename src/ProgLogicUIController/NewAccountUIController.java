/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUIController;

import ProgLogicDBController.LoginDBController;
import ProgLogicModel.LoginModel;
import ProgLogicUILoader.LoginUILoad;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import proglogictester.ProglogicScene;

/**
 * FXML Controller class
 *
 * @author Sayem Zaman
 */
public class NewAccountUIController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPass;
    @FXML
    private Button btnSignUp;
    @FXML
    private ComboBox<String> cmbRole;
    @FXML
    private TextField txtName;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnBack;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cmbRole.getItems().add("Student");
        cmbRole.getItems().add("Teacher");
    }

    @FXML
    private void btnSignUpHandle(ActionEvent event) {
        LoginDBController loginDBController = new LoginDBController();
        LoginModel loginModel = new LoginModel();
        String name = txtName.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String confirmpass = txtConfirmPass.getText();
        String role = cmbRole.getValue();

        if (valid()) {
            loginModel.setName(name);
            loginModel.setUsername(username);
            loginModel.setPassword(password);
            loginModel.setRole(role);
            loginDBController.saveUser(loginModel);
            LoginUILoad loginUILoad = new LoginUILoad(ProglogicScene.primarySatge);
        }
    }

    public boolean valid() {
        boolean value = true;
        if (txtName.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Insert Username");
            alert.showAndWait();
            return value;
        }
        if (txtUsername.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Insert Username");
            alert.showAndWait();
            return value;
        }
        if (txtPassword.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Insert Password");
            alert.showAndWait();
            return value;
        }
        if (txtConfirmPass.getText().isEmpty()) {
            value = false;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Confirm Password");
            alert.showAndWait();
            return value;
        }
        if (cmbRole.getValue().equals("")) {
            value = false;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Please Select Role");
            alert.showAndWait();
            return value;
        }
        if (!txtPassword.getText().equals(txtConfirmPass.getText())) {
            value = false;
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText("Field Empty");
            alert.setContentText("Don't match");
            alert.showAndWait();
            txtConfirmPass.setText("");
            return value;
        }
        return value;
    }

    @FXML
    private void btnBackHandle(ActionEvent event) {
        LoginUILoad loginUILoad = new LoginUILoad(ProglogicScene.primarySatge);
    }

    @FXML
    private void btnClearHandle(ActionEvent event) {
        txtName.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirmPass.setText("");
        cmbRole.getSelectionModel().clearSelection();
    }
}
