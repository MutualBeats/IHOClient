package presentation.manageui.addpeople;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import presentation.utilcontroller.RegistCheckController;

public class AddPeopleController extends RegistCheckController implements Initializable {

	@FXML
	private Label addpeople_title;


	// private static URL ADD_PEOPLE_CONFIRM_FXML;
	// private static URL ADD_PEOPLE_CONFIRM_CSS;
	// static{
	// try {
	// ADD_PEOPLE_CONFIRM_FXML = new
	// URL("file:src/main/resources/ui/manageui/fxml/addpeopleconfirm.fxml");
	// ADD_PEOPLE_CONFIRM_CSS = new
	// URL("file:src/main/resources/ui/manageui/css/add_people_confirm.css");
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// }
	// }

	@FXML
	protected void confirm(ActionEvent event) {
		checkInputFormatter();
		// Check the state
		// Window window = WindowGrab.getWindow(event);
		// WindowGrab.startWindow(window, "确认添加",
		// ADD_PEOPLE_CONFIRM_FXML,ADD_PEOPLE_CONFIRM_CSS);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	void addPeople() {

	}

}
