package presentation.marketui.webpromotion;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import po.promotion.DistrictPromotionPO;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;
import util.resultmessage.ResultMessage_User;
import vo.promotion.DistrictPromotionVO;
import vo.promotion.PromotionVO;

public class MemberDiscountController implements Confirm{

    @FXML
    private Button confirm;

    @FXML
    private Button cancel;

    @FXML
    private TableColumn<PromotionVO, String> discount;

    @FXML
    private TableView<PromotionVO> discount_list;

    
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
		
		PromotionVO promotionVO=new DistrictPromotionVO("", "会员商圈策略", PromotionType.BusinessDistrict, discount, "", startDate, finishDate, districtList)
		
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
			WindowGrab.startNoticeWindow(window, "促销策略新建失败！");
		}
	}

}

