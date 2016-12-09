/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.manageui.check;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilcontroller.LocationBoxController;
import presentation.utilui.WindowGrab;

public class CheckMenuController extends LocationBoxController {

	@FXML
	private Button cancel;

	@FXML
	private Button search;

	@FXML
	private Label check_title;

	@FXML
	private Button check;

	@FXML
	private TableView<?> people;

	@FXML
	private TextField search_text;

	private static URL CHECK_FXML;
	private static URL CHECK_CSS;

	static {
		try {
			CHECK_FXML = new URL("file:src/main/resources/ui/manageui/fxml/informationLookMarketer.fxml");
			CHECK_CSS = new URL("file:src/main/resources/ui/manageui/css/informationLookMarketer.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		super.initialize(location, resources);
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@FXML
	void on_check(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "人员信息", CHECK_FXML, CHECK_CSS);
	}

	@FXML
	void on_search(ActionEvent event) {

	}

}
