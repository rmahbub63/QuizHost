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
 * @author HASAN
 */
public class ChangePassUILoader {
    Stage primaryStage;

    public ChangePassUILoader(Stage stage){
        this.primaryStage = stage;
        Parent root = null;
        try {
             root = FXMLLoader.load(getClass().getResource("/ProgLogicUIController/ChangePassUI.fxml"));
             System.out.println("OK");
        } catch (Exception e) {
            System.out.println(e);
        }
        primaryStage.setScene(ProglogicScene.returnScene(root));
        primaryStage.show();
    }
}
