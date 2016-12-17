package presentation.marketui.webpromotion;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class MemberDiscountController implements Confirm{

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private TableColumn<Double, String> discount;

    @FXML
    private TableView<Double> discount_list;

    @FXML
    private DatePicker finishTime;
    
    @FXML
    private DatePicker startTime;
    
    
    PromotionVO promotionVO;

    @FXML
    void confirm(ActionEvent event) {
    	Window window=WindowGrab.getWindow(event);
    	WindowGrab.startConfirmWindow(window, this, "是否确认新建促销策略");
    }

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		Window window=WindowGrab.getWindowByStage(1);
		ResultMessage_Promotion result =ResultMessage_Promotion.Add_Successful;
		try {
			if(null!=ControllerFactory.getPromotionBLServiceInstance().addWebPromotion(promotionVO)){
				result=ResultMessage_Promotion.Add_Successful;
			}
			if(result==ResultMessage_Promotion.Add_Successful){
				WindowGrab.startNoticeWindow(window, "促销策略新建成功！");
			}
			else if (result==ResultMessage_Promotion.Net_Error) {
				WindowGrab.startNetErrorWindow(window);
			}
			else{
				WindowGrab.startErrorWindow(window, "促销策略新建失败！");
			}
		} catch (NetException e) {
			// TODO Auto-generated catch block
			WindowGrab.startNetErrorWindow(window);
		}
		
		
		
	}

	

}

