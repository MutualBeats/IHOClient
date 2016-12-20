package presentation.marketui.webpromotion;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class PromotionChooseController implements Initializable {

	@FXML
	private Button cancel;

	@FXML
	private Button create;

	@FXML
	private ToggleGroup promotion;

	@FXML
	private RadioButton field;

	@FXML
	private RadioButton time;

	private ResourceBundle resourceBundle = null;

	private static URL FIELD_FXML;
	private static URL FIELD_CSS;

	private static URL TIME_FXML;
	private static URL TIME_CSS;

	static {
		try {
			FIELD_FXML = new URL("file:src/main/resources/ui/marketui/fxml/field_promotion.fxml");
			FIELD_CSS = new URL("file:src/main/resources/ui/marketui/css/field_promotion.css");

			TIME_FXML = new URL("file:src/main/resources/ui/marketui/fxml/time_promotion.fxml");
			TIME_CSS = new URL("file:src/main/resources/ui/marketui/css/time_promotion.css");

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@FXML
	void create(ActionEvent event) {
		ResourceBundle bundle = resourceBundle;
		boolean start = true;
		if (promotion.getSelectedToggle() != null) {
			Toggle toggle = promotion.getSelectedToggle();
			if (toggle == field) {
				start = true;
			} else {
				start = false;
			}
		}
		WindowGrab.closeWindow(WindowGrab.getWindow(event));
		Window window = WindowGrab.getWindowByStage(0);
		if (start) {
			WindowGrab.startWindowWithBundle(window, "新建会员商圈促销策略", FIELD_FXML, FIELD_CSS, bundle);
		} else {
			WindowGrab.startWindowWithBundle(window, "新建限时促销策略", TIME_FXML, TIME_CSS, bundle);
		}

	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		resourceBundle = resources;
	}
}
