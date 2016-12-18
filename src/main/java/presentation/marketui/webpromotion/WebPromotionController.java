/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.marketui.webpromotion;


import java.net.MalformedURLException;
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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.bundle.PromotionInfoBundle;
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class WebPromotionController implements Initializable,Confirm{
	
	@FXML
    private Button cancel;

    @FXML
    private MenuItem time_discount;

    @FXML
    private TableColumn<PromotionVO, String> start_time;

    @FXML
    private TableColumn<PromotionVO, String> id_list;

    @FXML
    private MenuItem member_discount;

    @FXML
    private Label web_promotion_title;

    @FXML
    private TableColumn<PromotionVO, String> promotion_name;

    @FXML
    private Button delete;

    @FXML
    private TableView<PromotionVO> promotion_list;

    @FXML
    private Button create;

    @FXML
    private TableColumn<PromotionVO, String> type;

    @FXML
    private TableColumn<PromotionVO, String> finish_time;
    
    
    
    private ObservableList<PromotionVO> total;    

    private static URL WEB_PROMOTION_CHOOSE_CSS;
    private static URL WEB_PROMOTION_CHOOSE_FXML;
    
    private static URL WEB_PROMOTION_CHECK_FXML;
    private static URL WEB_PROMOTION_CHECK_CSS;
    
    
    private static URL MEMBER_LEVEL_FXML;
    private static URL MEMBER_LEVEL_CSS;
    
    static{
    	try {
    		
    		WEB_PROMOTION_CHOOSE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion_choose.fxml");
    		WEB_PROMOTION_CHOOSE_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion_choose.css");
    		
    		WEB_PROMOTION_CHECK_FXML=new URL("file:src/main/resources/ui/marketui/fxml/promotion_check.fxml");
    		WEB_PROMOTION_CHECK_CSS=new URL("file:src/main/resources/ui/marketui/css/promotion_check.css");
    		
    		MEMBER_LEVEL_FXML=new URL("file:src/main/resources/ui/marketui/fxml/member_level.fxml");
    		MEMBER_LEVEL_CSS=new URL("file:src/main/resources/ui/marketui/css/member_level.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }

    @SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> total_promotion=(ArrayList<PromotionVO>)resources.getObject("total_promotion");
		total=FXCollections.observableArrayList();
		
		total.addAll(total_promotion);
		
		promotion_list.setItems(total);
		
		initColumn();
		
		
	}
    

    private void initColumn(){
    	id_list.setCellValueFactory(celldata->celldata.getValue().getPromotionIDProperty());
    	promotion_name.setCellValueFactory(celldata->celldata.getValue().getPromotionNameProperty());
    	start_time.setCellValueFactory(celldata->celldata.getValue().getStartDateProperty());
    	finish_time.setCellValueFactory(celldata->celldata.getValue().getFinishDateProperty());
    	type.setCellValueFactory(celldata->celldata.getValue().getPromotionTypeProperty());
    }
    
    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void update(ActionEvent event) {
     	Window window = WindowGrab.getWindow(event);
     	int promotionIndex = promotion_list.getSelectionModel().getSelectedIndex();
    	if(promotionIndex == -1) {
    		WindowGrab.startNoticeWindow(window, "请选择促销策略");
    		return;
    	}
    	WindowGrab.startConfirmWindow(window, this, "是否确认删除");
    }

    @FXML
    void create(ActionEvent event) {
     	Window window = WindowGrab.getWindow(event);
     	WindowGrab.startWindow(window, "选择新建促销策略类型", WEB_PROMOTION_CHOOSE_FXML,WEB_PROMOTION_CHOOSE_CSS);
   
    }



	@FXML
    void check(ActionEvent event) {
		Window window =WindowGrab.getWindow(event);
		PromotionVO promotion=null;
		promotion=promotion_list.getSelectionModel().getSelectedItem();
		ResourceBundle bundle=new PromotionInfoBundle(promotion);
		WindowGrab.startWindowWithBundle(window, "促销策略详情", WEB_PROMOTION_CHECK_FXML	, WEB_PROMOTION_CHECK_CSS, bundle);
    }


	@Override
	public void confirm() {
		// 确认是否删除订单
		Window window = WindowGrab.getWindowByStage(0);
		PromotionVO promotionVO = promotion_list.getSelectionModel().getSelectedItem();
		int index = promotion_list.getSelectionModel().getSelectedIndex();
		try {
			ResultMessage_Promotion result = ControllerFactory.getPromotionBLServiceInstance().cancel(promotionVO.promotionID);
			switch (result) {
			case Delete_Successful:
				promotion_list.getItems().remove(index);
				// TODO 提示窗口问题
				WindowGrab.startNoticeWindow(window, "删除成功");
				break;
			case Promotion_Not_Exist:
				WindowGrab.startNoticeWindow(window, "促销策略不存在");
				break;
			case Net_Error:
				WindowGrab.startNetErrorWindow(window);
				break;
			default:
				WindowGrab.startNoticeWindow(window, "异常错误");
				break;
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
	
	}


	@FXML
    void member_level(ActionEvent event) {
		Window window=WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "制定会员等级折扣", MEMBER_LEVEL_FXML, MEMBER_LEVEL_CSS);
    }
	
}

