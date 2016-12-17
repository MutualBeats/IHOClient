package presentation.marketui.webpromotion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Window;
import po.promotion.DistrictPromotionPO;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;
import util.resultmessage.ResultMessage_User;
import vo.order.OrderVO;
import vo.promotion.DistrictPromotionVO;
import vo.promotion.PromotionVO;

public class MemberDiscountController implements Confirm,Initializable{

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
    private ObservableList<Double> discountObservableList=FXCollections.observableArrayList();
    
    @SuppressWarnings("unchecked")
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<Double> discountList=(ArrayList<Double>)resources.getObject("promotion");
		discountObservableList.addAll(discountList);
		discount_list.setItems(discountObservableList);
		initColumn();
	}
    
    private void initColumn(){
    	discount.getCellFactory();
    	
    }
    
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
		
		String startDate=startTime.getEditor().getText();
		String finishDate=finishTime.getEditor().getText();
		
		
		
		
		
		
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

