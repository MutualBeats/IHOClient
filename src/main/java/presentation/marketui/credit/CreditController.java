package presentation.marketui.credit;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class CreditController {


	    @FXML
	    private Button cancel;

	    @FXML
	    private Button search;

	    @FXML
	    private Button excute;

	    @FXML
	    private Label credit_title;


	    private static URL CREDIT_EXCUTE_FXML;
	    private static URL CREDIT_EXCUTE_CSS;
	    
	    static{
	    	try {
	    		
	    		CREDIT_EXCUTE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/credit_excute.fxml");
	    		CREDIT_EXCUTE_CSS=new URL("file:src/main/resources/ui/marketui/css/credit_excute.css");
	    		
	    	} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	    	
	    }
	    
	    @FXML
	    void cancel(ActionEvent event) {
	    	WindowGrab.closeWindow(event);
	    }

	    @FXML
	    void excute(ActionEvent event) {
	    	Window window = WindowGrab.getWindow(event);
	    	WindowGrab.startWindow(window, "信用充值", CREDIT_EXCUTE_FXML,CREDIT_EXCUTE_CSS);
	   
	    }


	    @FXML
	    void search(ActionEvent event) {

	    }


	}



