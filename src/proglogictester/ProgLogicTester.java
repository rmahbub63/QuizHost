/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglogictester;

import ProgLogicUILoader.LoginUILoad;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author HASAN
 */
public class ProgLogicTester extends Application {
    
     private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        ProglogicScene.primarySatge = primaryStage;

        primaryStage.setTitle("Quiz Host");
        primaryStage.setResizable(false);
        LoginUILoad loginUILoad = new LoginUILoad(primaryStage);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
