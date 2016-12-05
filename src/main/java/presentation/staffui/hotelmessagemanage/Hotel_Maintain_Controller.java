package presentation.staffui.hotelmessagemanage;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class Hotel_Maintain_Controller {

	 @FXML
	    private Button cancel;

	    @FXML
	    private TextField hotel_star;

	    @FXML
	    private TextField hotel_id;

	    @FXML
	    private Button update;

	    @FXML
	    private ComboBox<String> hotel_field;

	    @FXML
	    private Label address_warning;

	    @FXML
	    private TextArea hotel_address;

	    @FXML
	    private TextField hotel_name;

	    @FXML
	    private ComboBox<String> hotel_province;

	    @FXML
	    private Label hotel_maintain_title;

	    @FXML
	    private TextField hotel_score;

	    @FXML
	    private Label name_warning;

	    @FXML
	    private Label star_warning;

    private static URL CONFIRM_FXML;
    private static URL CONFIRM_CSS;
    static{
    	try {
    		CONFIRM_FXML = new URL("file:src/main/resources/ui/staffui/fxml/hotel_maintain_confirm.fxml");
    		CONFIRM_CSS = new URL("file:src/main/resources/ui/staffui/css/hotel_maintain_confirm.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void update(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window,"确认", CONFIRM_FXML,CONFIRM_CSS);
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }


}
