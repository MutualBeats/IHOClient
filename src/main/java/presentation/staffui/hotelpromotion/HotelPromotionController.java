/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.hotelpromotion;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import config.urlconfig.StaffUIURLConfig;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.bundle.PromotionInfoBundle;
import presentation.bundle.PromotionUpdateBundle;
import presentation.utilcontroller.Confirm;
import presentation.utilcontroller.PromotionUpdate;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class HotelPromotionController implements Initializable, PromotionUpdate, Confirm {
	
	@FXML
	private TableColumn<PromotionVO, String> promotion_id;
	
	@FXML
	private TableColumn<PromotionVO, String> promotion_name;
	
	@FXML
	private TableColumn<PromotionVO, String> promotion_type;
	
	@FXML
	private TableColumn<PromotionVO, String> start_date;
	
	@FXML
	private TableColumn<PromotionVO, String> finish_date;
	
	@FXML
	private TableView<PromotionVO> promotion_list;
	
	@FXML
	private Button search;

    @FXML
    private Button cancel;

    @FXML
    private Label promotion_title;

    @FXML
    private Button delete;

    @FXML
    private Button create;

    @FXML
    private Button check;

    private static URL HOTEL_PROMOTION_CREATE_FXML;
    private static URL HOTEL_PROMOTION_CREATE_CSS;
    private static URL HOTEL_PROMOTION_LOOK_FXML;
    private static URL HOTEL_PROMOTION_LOOK_CSS;

    //人员信息界面
    private static URL MENU_FXML;
    private static URL MENU_CSS;
    
    //订单管理
    private static URL ORDER_MANAGE_FXML;
    private static URL ORDER_MANAGE_CSS;
    
    //酒店信息管理
    private static URL MAINTAIN_HOTEL_FXML;
	private static URL MAINTAIN_HOTEL_CSS;

    //房间管理
    private static URL ROOM_MANAGE_FXML;
    private static URL ROOM_MANAGE_CSS;
    
	
	static {
		HOTEL_PROMOTION_CREATE_FXML = StaffUIURLConfig.staff_hotel_promotion_create_fxml_url();
		HOTEL_PROMOTION_CREATE_CSS = StaffUIURLConfig.staff_hotel_promotion_create_css_url();
		HOTEL_PROMOTION_LOOK_FXML = StaffUIURLConfig.staff_hotel_promotion_check_fxml_url();
		HOTEL_PROMOTION_LOOK_CSS = StaffUIURLConfig.staff_hotel_promotion_check_css_url();
		
		ROOM_MANAGE_FXML = StaffUIURLConfig.staff_room_manage_fxml_url();
		ROOM_MANAGE_CSS = StaffUIURLConfig.staff_room_manage_css_url();

		ORDER_MANAGE_FXML = StaffUIURLConfig.staff_order_manage_fxml_url();
		ORDER_MANAGE_CSS = StaffUIURLConfig.staff_order_manage_css_url();

		MAINTAIN_HOTEL_FXML = StaffUIURLConfig.staff_maintain_hotel_fxml_url();
		MAINTAIN_HOTEL_CSS = StaffUIURLConfig.staff_maintain_hotel_css_url();

		MENU_FXML = StaffUIURLConfig.staff_main_fxml_url();
		MENU_CSS =  StaffUIURLConfig.staff_main_css_url();
		
	}
	
	private ObservableList<PromotionVO> list = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			PromotionBLService promotionBL = ControllerFactory.getPromotionBLServiceInstance();
			ArrayList<PromotionVO> hotelPromotionVOList = promotionBL.getHotelPromotion(UserCache.getHotelID());
			list.addAll(hotelPromotionVOList);
			promotion_list.setItems(list);
			initColumn();
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
	
	private void initColumn() {
		promotion_id.setCellValueFactory(cellData -> cellData.getValue().getPromotionIDProperty());
		promotion_name.setCellValueFactory(cellData -> cellData.getValue().getPromotionNameProperty());
		promotion_type.setCellValueFactory(cellData -> cellData.getValue().getPromotionTypeProperty());
		start_date.setCellValueFactory(cellData -> cellData.getValue().getStartDateProperty());
		finish_date.setCellValueFactory(cellData-> cellData.getValue().getFinishDateProperty());
	}
	
    @FXML
    void delete(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	int promotionIndex = promotion_list.getSelectionModel().getSelectedIndex();
    	if(promotionIndex == -1) {
    		WindowGrab.startNoticeWindow(window, "请选择促销策略");
    		return;
    	}
    	WindowGrab.startConfirmWindow(window, this, "是否确认删除");
	}

   

    @FXML
    void check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	PromotionVO promotionVO = promotion_list.getSelectionModel().getSelectedItem();
    	if(promotionVO == null) {
    		WindowGrab.startNoticeWindow(window, "请选择促销策略");
    		return;
    	}
    	WindowGrab.startWindowWithBundle(window, "查看促销策略", HOTEL_PROMOTION_LOOK_FXML, HOTEL_PROMOTION_LOOK_CSS, new PromotionInfoBundle(promotionVO));
    }

    @FXML
    void create(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
//		WindowGrab.startWindow(window, "新建促销策略",HOTEL_PROMOTION_CREATE_FXML,HOTEL_PROMOTION_CREATE_CSS);
		WindowGrab.startWindowWithBundle(window, "", HOTEL_PROMOTION_CREATE_FXML, HOTEL_PROMOTION_CREATE_CSS, new PromotionUpdateBundle(this));
    }

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
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

	@Override
	public void update(PromotionVO vo) {
		promotion_list.getItems().add(0, vo);
	}
	
	@FXML
    void peopleInfo(ActionEvent event) {
		WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
    }

    @FXML
    void manageRoom(ActionEvent event) {
    	WindowGrab.changeScene(ROOM_MANAGE_FXML, ROOM_MANAGE_CSS, event);
    }

    @FXML
    void manageOrder(ActionEvent event) {
    	WindowGrab.changeScene(ORDER_MANAGE_FXML, ORDER_MANAGE_CSS, event);
    }

    @FXML
    void maintainMessage(ActionEvent event) {
    	WindowGrab.changeScene(MAINTAIN_HOTEL_FXML, MAINTAIN_HOTEL_CSS, event);
    }
	
}
