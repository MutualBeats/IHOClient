package presentation.manageui.addhotel;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class AddHotelController_two {

	@FXML
	private Label phone_warning;

	@FXML
	private AnchorPane second_pane;

	@FXML
	private PasswordField ps;

	@FXML
	private Label ps_warning;

	@FXML
	private TextField phone;

	@FXML
	private TextField user_name;

	@FXML
	private PasswordField ps_again;

	@FXML
	private Button second_cancel;

	@FXML
	private TextField name;

	@FXML
	private Label user_name_warning;

	@FXML
	private Button second_confirm;

	@FXML
	private Label name_warning;

	private static URL ADD_HOTEL_THREE_FXML;
	private static URL ADD_HOTEL_THREE_CSS;
	static {
		try {
			ADD_HOTEL_THREE_FXML = new URL("file:src/main/resources/ui/manageui/fxml/addhotel_three.fxml");
			ADD_HOTEL_THREE_CSS = new URL("file:src/main/resources/ui/manageui/css/addhotel_three.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void second_confirm(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "确认", ADD_HOTEL_THREE_FXML, ADD_HOTEL_THREE_CSS);
	}

	@FXML
	void second_cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

}
