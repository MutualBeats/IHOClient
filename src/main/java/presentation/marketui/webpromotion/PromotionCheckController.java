package presentation.marketui.webpromotion;


import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.promotion.PromotionVO;

public class PromotionCheckController implements Initializable{

    @FXML
    private Button cancel;

    @FXML
    private Label promotion_name;

    @FXML
    private Label time_start;

    @FXML
    private Label discount;

    @FXML
    private Label promotion_ID;

    @FXML
    private Label time_end;

    private PromotionVO promotionVO;
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		promotionVO=(PromotionVO)resources.getObject("promotion");

	}
 
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void promotion_ID(ActionEvent event) {
    	promotion_ID.setText(promotionVO.promotionID);
    }

    @FXML
    void promotion_name(ActionEvent event) {
    	promotion_name.setText(promotionVO.promotionName);
    }

    @FXML
    void time_start(ActionEvent event) {
    	time_start.setText(promotionVO.startDate);
    }

    @FXML
    void time_end(ActionEvent event) {
    	time_end.setText(promotionVO.finishDate);
    }

    @FXML
    void discount(ActionEvent event) {
    	discount.setText(promotionVO.discount.toString());
    }

	
}

