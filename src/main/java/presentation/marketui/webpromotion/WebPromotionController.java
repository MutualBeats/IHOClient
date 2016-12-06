/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.marketui.webpromotion;


import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class WebPromotionController {

    @FXML
    private Button cancel;

    @FXML
    private Button update;

    @FXML
    private Button create;

    private static URL WEB_PROMOTION_CREATE_FXML;
    private static URL WEB_PROMOTION_CREATE_CSS;
    
    private static URL WEB_PROMOTION_UPDATE_FXML;
    private static URL WEB_PROMOTION_UPDATE_CSS;
    
    static{
    	try {
    		
    		WEB_PROMOTION_CREATE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion_create.fxml");
    		WEB_PROMOTION_CREATE_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion_create.css");
    		
    		WEB_PROMOTION_UPDATE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion_update.fxml");
    		WEB_PROMOTION_UPDATE_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion_update.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void update(ActionEvent event) {
     	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "网站促销策略", WEB_PROMOTION_UPDATE_FXML,WEB_PROMOTION_UPDATE_CSS);
    }

    @FXML
    void create(ActionEvent event) {
     	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "网站促销策略", WEB_PROMOTION_CREATE_FXML,WEB_PROMOTION_CREATE_CSS);
   
    }

}

