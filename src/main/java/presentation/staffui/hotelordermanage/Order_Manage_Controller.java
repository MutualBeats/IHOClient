/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.staffui.hotelordermanage;

import java.net.MalformedURLException;
import java.net.URL;

import config.urlconfig.StaffUIURLConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;

public class Order_Manage_Controller {

    @FXML
    private Button cancel;

    @FXML
    private Label order_manage_title;

    @FXML
    private Button check;

    private static URL ORDER_CHECK_FXML;
    private static URL ORDER_CHECK_CSS;
	static {
		ORDER_CHECK_FXML = StaffUIURLConfig.staff_order_check_fxml_url();
		ORDER_CHECK_CSS = StaffUIURLConfig.staff_order_check_css_url();
	}
	
	@FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void check(ActionEvent event) {
     	Window owner = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(owner, "订单信息", ORDER_CHECK_FXML, ORDER_CHECK_CSS);
    
    }
    @FXML
    void supply(ActionEvent event) {

    }
}
