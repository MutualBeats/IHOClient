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
		promotion_ID.setText(promotionVO.promotionID);
    	promotion_name.setText(promotionVO.promotionName);
    	time_start.setText(promotionVO.startDate);
    	time_end.setText(promotionVO.finishDate);
    	discount.setText(promotionVO.discount.toString());
		}
 
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

	
}

