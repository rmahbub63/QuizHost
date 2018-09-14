/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglogictester;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 *
 * @author MAHBUB
 */
public class StudentHamburgerAndDrawerSet {

    private JFXHamburger hamburger;
    private JFXDrawer drawer;

    public StudentHamburgerAndDrawerSet(JFXHamburger hamburger, JFXDrawer drawer) {
        try {
            VBox box = FXMLLoader.load(getClass().getResource("/ProgLogicUIController/StudentSidePanelContent.fxml"));
            drawer.setSidePane(box);
            drawer.setMaxHeight(box.getHeight());
            drawer.setOverLayVisible(false);
        } catch (IOException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();
            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
            }
        });
    }
}
