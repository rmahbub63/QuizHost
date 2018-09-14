/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglogictester;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author HASAN
 */
public class ProgLogicMenubar {
    public static MenuBar getMneuBar() {
		MenuBar menuBar = new MenuBar();
		menuBar.setCursor(Cursor.HAND);

		// --- Menu
		Menu menuFile = new Menu("File");
		Menu menuAddData = new Menu("Add Data");
		Menu menuSettings = new Menu("Settings");
		Menu menuAbout = new Menu("About");
		Menu menuHelp = new Menu("Help");
		// --- Menu

		// --- Menu Item
		MenuItem itemLogout = new MenuItem("Logout");
		MenuItem itemExit = new MenuItem("Exit");
		MenuItem itemAdd = new MenuItem("Add Info");
                MenuItem itemTransaction = new MenuItem("New Transaction");
		MenuItem itemTransactionList = new MenuItem("Transaction List");
		MenuItem itemAddCompany = new MenuItem("Add Company");
		MenuItem itemRegistration = new MenuItem("Registration");
		MenuItem itemRolePermission = new MenuItem("Role Permission");
		

		// --- Menu Item

		menuFile.getItems().addAll(itemLogout, itemExit);
                menuAddData.getItems().addAll(itemAdd);
		menuSettings.getItems().addAll(itemAddCompany, itemRegistration, itemRolePermission);

		// --- Menu View
		Label menuLabelHome = new Label("Home");
		menuLabelHome.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
//                            HomeUI homeUI = new HomeUI(NewFXProjectScene.primarySatge);
			}
		});
		Menu menuHomeButton = new Menu();
		menuHomeButton.setGraphic(menuLabelHome);

		itemAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//                            AddDataUI addDataUI = new AddDataUI(NewFXProjectScene.primarySatge);
			}
		});
                
//		menuBar.getMenus().addAll(menuFile, menuHomeButton, menuAddData, menuSettings, menuAbout, menuHelp);
                menuBar.getMenus().addAll(menuFile);

		return menuBar;
	}
}
