/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.hotelpromotion;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class HotelPromotionController {

    @FXML
    private Button cancel;

    @FXML
    private Label promotion_title;

    @FXML
    private Button change;

    @FXML
    private Button create;

    @FXML
    private Button check;


    private static URL HOTEL_PROMOTION_CREATE_FXML;
    private static URL HOTEL_PROMOTION_CREATE_CSS;
    private static URL HOTEL_PROMOTION_LOOK_FXML;
    private static URL HOTEL_PROMOTION_LOOK_CSS;
    private static URL HOTEL_PROMOTION_CHANGE_FXML;
    private static URL HOTEL_PROMOTION_CHANGE_CSS;
    
    static{
    	try {
    		HOTEL_PROMOTION_CREATE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion_create.fxml");
    		HOTEL_PROMOTION_CREATE_CSS = new URL("file:src/main/resources/ui/staffui/css/hotel_promotion_create.css");
    		HOTEL_PROMOTION_LOOK_FXML = new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion_check.fxml");
    		HOTEL_PROMOTION_LOOK_CSS = new URL("file:src/main/resources/ui/staffui/css/hotel_promotion_check.css");
    		HOTEL_PROMOTION_CHANGE_FXML = new URL("file:src/main/resources/ui/staffui/fxml/hotel_promotion_change.fxml");
    		HOTEL_PROMOTION_CHANGE_CSS = new URL("file:src/main/resources/ui/staffui/css/hotel_promotion_change.css");
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    @FXML
    void change(ActionEvent event) {	
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "修改促销策略",HOTEL_PROMOTION_CHANGE_FXML,HOTEL_PROMOTION_CHANGE_CSS);   
	   }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "查看促销策略",HOTEL_PROMOTION_LOOK_FXML,HOTEL_PROMOTION_LOOK_CSS);   
    }

    @FXML
    void create(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "新建促销策略",HOTEL_PROMOTION_CREATE_FXML,HOTEL_PROMOTION_CREATE_CSS);   
    }

}

