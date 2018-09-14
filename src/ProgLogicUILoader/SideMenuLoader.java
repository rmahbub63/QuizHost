/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgLogicUILoader;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

/**
 *
 * @author MAHBUB
 */
public class SideMenuLoader {

    public VBox getSideMenu() {
        VBox box = null;
        try {
            box = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));
            return box;
        } catch (IOException ex) {
//            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return box;
    }

}
