/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUILoader;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import proglogictester.ProglogicScene;

/**
 *
 * @author MAHBUB
 */
public class StudentQuizRecordUILoader {

    Stage primaryStage;

    public StudentQuizRecordUILoader(Stage stage) {
        this.primaryStage = stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/ProgLogicUIController/StudentQuizRecordUI.fxml"));
            System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e);
        }
        primaryStage.setScene(ProglogicScene.returnScene(root));
    }
}
