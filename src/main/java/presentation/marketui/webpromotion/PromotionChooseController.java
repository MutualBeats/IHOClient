package presentation.marketui.webpromotion;

import java.net.MalformedURLException;
import java.net.URL;

import javax.print.CancelablePrintJob;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class PromotionChooseController {

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
    
    private static URL FIELD_FXML;
    private static URL FIELD_CSS;
    
    private static URL TIME_FXML;
    private static URL TIME_CSS;
    
    
    static{
    	try {
			FIELD_FXML=new URL("file:src/main/resources/ui/marketui/fxml/field_promotion.fxml");
			FIELD_CSS=new URL("file:src/main/resources/ui/marketui/css/field_promotion.css");
	    	
			TIME_FXML=new URL("file:src/main/resources/ui/marketui/fxml/time_promotion.fxml");
			TIME_CSS=new URL("file:src/main/resources/ui/marketui/css/time_promotion.css");
	    	
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
    @FXML
    void create(ActionEvent event) {
    	promotion.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) -> {
    		Window window=WindowGrab.getWindow(event);
    		if (promotion.getSelectedToggle() != null) {
				Toggle toggle = promotion.getSelectedToggle();
				if (toggle == field) {
					WindowGrab.startWindow(window, "新建会员商圈促销策略", FIELD_FXML, FIELD_CSS);
				}
				else {
					WindowGrab.startWindow(window, "新建限时促销策略", TIME_FXML, TIME_CSS);
				
				}
			}
		});
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
}

