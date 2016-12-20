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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.bundle.LevelBundle;
import presentation.bundle.PromotionInfoBundle;
import presentation.bundle.PromotionUpdateBundle;
import presentation.bundle.SingleOrderListBundle;
import presentation.marketui.credit.CreditIDInputHandle;
import presentation.utilcontroller.Confirm;
import presentation.utilcontroller.PromotionUpdate;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Promotion;
import vo.order.OrderVO;
import vo.promotion.PromotionVO;

public class WebPromotionController implements Initializable,Confirm,PromotionUpdate{
	
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
    
    @FXML
    private Button web_promotion;
    
    @FXML
    private Button unusual_order;

    @FXML
    private Button unexecuted_order;

    @FXML
    private Button credit;
    
    @FXML
    private Button level;
    
    @FXML
    private Button peopleInfo;
    
    private ObservableList<PromotionVO> total;  
    private ArrayList<Integer> credit_list;
    private ArrayList<Double>	discount_list;
    private ArrayList<PromotionVO> total_promotion;
    private static URL WEB_PROMOTION_CHOOSE_CSS;
    private static URL WEB_PROMOTION_CHOOSE_FXML;
    
    private static URL WEB_PROMOTION_CHECK_FXML;
    private static URL WEB_PROMOTION_CHECK_CSS;
    
    
    private static URL MEMBER_LEVEL_FXML;
    private static URL MEMBER_LEVEL_CSS;
    

    private static URL UNUSUAL_ORDER_FXML;
    private static URL UNUSUAL_ORDER_CSS;
    
    private static URL UNEXCUTED_ORDER_FXML;
    private static URL UNEXCUTED_ORDER_CSS;
    
    private static URL MENU_FXML;
    private static URL MENU_CSS;
    
    
    
    static{
    	try {
    		
    		WEB_PROMOTION_CHOOSE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion_choose.fxml");
    		WEB_PROMOTION_CHOOSE_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion_choose.css");
    		
    		WEB_PROMOTION_CHECK_FXML=new URL("file:src/main/resources/ui/marketui/fxml/promotion_check.fxml");
    		WEB_PROMOTION_CHECK_CSS=new URL("file:src/main/resources/ui/marketui/css/promotion_check.css");
    		
    		MEMBER_LEVEL_FXML=new URL("file:src/main/resources/ui/marketui/fxml/member_level.fxml");
    		MEMBER_LEVEL_CSS=new URL("file:src/main/resources/ui/marketui/css/member_level.css");
    		
    		UNUSUAL_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unusual_order.fxml");
    		UNUSUAL_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unusual_order.css");
    		
    		UNEXCUTED_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unexecuted_order.fxml");
    		UNEXCUTED_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unexecuted_order.css");
    		
    		MENU_FXML=new URL("file:src/main/resources/ui/marketui/fxml/marketmenu.fxml");
    		MENU_CSS=new URL("file:src/main/resources/ui/marketui/css/marketmenu.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    	
    }

    @SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		total_promotion=(ArrayList<PromotionVO>)resources.getObject("total_promotion");
		
		total=FXCollections.observableArrayList();
		total.addAll(total_promotion);
		
		try {
			credit_list=ControllerFactory.getPromotionBLServiceInstance().getMemberLevel();
			discount_list=ControllerFactory.getPromotionBLServiceInstance().getMemberDiscount();
			
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
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
    	WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
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
    	//选择新建促销策略类型
     	Window window = WindowGrab.getWindow(event);
     	ResourceBundle bundle=new PromotionUpdateBundle(this);
     	WindowGrab.startWindowWithBundle(window, "选择新建促销策略类型", WEB_PROMOTION_CHOOSE_FXML,WEB_PROMOTION_CHOOSE_CSS, bundle);
   
    }



	@FXML
    void check(ActionEvent event) {
		//查看促销策略详情
		Window window =WindowGrab.getWindow(event);	
		PromotionVO promotion=null;
		promotion=promotion_list.getSelectionModel().getSelectedItem();
		if(promotion == null) {
    		WindowGrab.startNoticeWindow(window, "请选择促销策略");
    		return;
    	}
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
		ResourceBundle bundle=new LevelBundle(credit_list, discount_list);
		WindowGrab.startWindowWithBundle(window, "制定会员等级信息", MEMBER_LEVEL_FXML, MEMBER_LEVEL_CSS, bundle);
	}
		

	
	@Override
	public void update(PromotionVO vo) {
		//新建促销策略刷新
//		total.clear();
//		total_promotion.add(vo);
//		total.addAll(total_promotion);
//		promotion_list.setItems(total);
		promotion_list.getItems().add(vo);
	}
	
	
	
	//界面切换
	@FXML
    void unexecuted_order(ActionEvent event) {
		Scene frame=WindowGrab.getScene(event);
    	ArrayList<OrderVO> order_info=null;
		try {
			order_info = ControllerFactory.getOrderBLServiceInstance().queryUnexecutedOrder(util.Time.getCurrentDate());
		} catch (NetException e) {
			Window window=WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
    	ResourceBundle bundle=new SingleOrderListBundle(order_info);
    	WindowGrab.changeSceneWithBundle(UNEXCUTED_ORDER_FXML, UNEXCUTED_ORDER_CSS, frame, bundle);
    }

    @FXML
    void unusual_order(ActionEvent event) {
    	Scene frame=WindowGrab.getScene(event);
    	ArrayList<OrderVO> order_info=null;
		try {
			order_info = ControllerFactory.getOrderBLServiceInstance().queryAbnormalOrder();
		} catch (NetException e) {
			Window window=WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
    	ResourceBundle bundle=new SingleOrderListBundle(order_info);
    	WindowGrab.changeSceneWithBundle(UNUSUAL_ORDER_FXML, UNUSUAL_ORDER_CSS, frame, bundle);
    }

    @FXML
    void on_credit(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startIDInputWindow(window, new CreditIDInputHandle());
    }
	
    @FXML
    void peopleInfo(ActionEvent event) {
    	WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
    }
}

