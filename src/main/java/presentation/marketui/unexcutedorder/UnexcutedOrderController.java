/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.marketui.unexcutedorder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;

public class UnexcutedOrderController {

    @FXML
    private Button cancel;

    @FXML
    private Button search;

    @FXML
    private Label unexcuted_order_title;

    @FXML
    private Button check;

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void on_check(ActionEvent event) {

    }


    @FXML
    void on_search(ActionEvent event) {

    }


}
