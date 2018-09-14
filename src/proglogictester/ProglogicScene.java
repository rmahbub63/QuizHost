/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglogictester;

import ProgLogicModel.LoginModel;
import ProgLogicModel.QuizModel;
import ProgLogicModel.QuizResultModel;
import ProgLogicModel.TestModel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author HASAN
 */
public class ProglogicScene {

    public static Scene returnScene(Parent parent) {
        BorderPane borderPane = new BorderPane();
//        borderPane.setTop(ProgLogicMenubar.getMneuBar());
        borderPane.setCenter(parent);
        Scene scene = new Scene(borderPane, 610, 400);
//		scene.getStylesheets().add(ProglogicScene.class.getResource("style.css").toExternalForm());
        return scene;
    }
    public static Stage primarySatge;
    public static LoginModel loginModel;
    public static QuizModel quizModel;
    public static TestModel testModel;
    public static QuizResultModel quizResultModel; 
}
