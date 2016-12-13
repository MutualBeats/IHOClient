/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.staffui.hotelpromotion;
import java.awt.Desktop.Action;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import bussinesslogicservice.roomblservice.RoomBLService;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;
import presentation.staffui.roommanage.RoomData;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.promotion.PromotionVO;
import vo.room.RoomVO;

public class HotelPromotionController implements Initializable {
	
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
    
    @FXML
    private TableView<HotelPromotionData> hotelPromotionTable;
    
    
    private ObservableList<HotelPromotionData> data = FXCollections.observableArrayList();


    private static URL HOTEL_PROMOTION_CREATE_FXML;
    private static URL HOTEL_PROMOTION_CREATE_CSS;
    private static URL HOTEL_PROMOTION_LOOK_FXML;
    private static URL HOTEL_PROMOTION_LOOK_CSS;
    private static URL HOTEL_PROMOTION_CHANGE_FXML;
	private static URL HOTEL_PROMOTION_CHANGE_CSS;

	static {
		HOTEL_PROMOTION_CREATE_FXML = StaffUIURLConfig.staff_hotel_promotion_create_fxml_url();
		HOTEL_PROMOTION_CREATE_CSS = StaffUIURLConfig.staff_hotel_promotion_create_css_url();
		HOTEL_PROMOTION_LOOK_FXML = StaffUIURLConfig.staff_hotel_promotion_check_fxml_url();
		HOTEL_PROMOTION_LOOK_CSS = StaffUIURLConfig.staff_hotel_promotion_check_css_url();
		HOTEL_PROMOTION_CHANGE_FXML = StaffUIURLConfig.staff_hotel_promotion_change_fxml_url();
		HOTEL_PROMOTION_CHANGE_CSS = StaffUIURLConfig.staff_hotel_promotion_change_css_url();
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO
		try {
			ObservableList<TableColumn<HotelPromotionData, ?>> observableList = hotelPromotionTable.getColumns();
			observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("promotionID"));
			observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("promotionName"));
			observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("promotionType"));
			observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("startDate"));
			observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("endDate"));
			observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("discount"));
			
			PromotionBLService promotionBL = ControllerFactory.getPromotionBLServiceInstance();
			// TODO 获取酒店id
			ArrayList<PromotionVO> hotelPromotionVOList = promotionBL.getHotelPromotion("00000001");
			for (PromotionVO promotion : hotelPromotionVOList) {
				HotelPromotionData promotionData = new HotelPromotionData(promotion.promotionID, promotion.promotionName, promotion.type, promotion.startDate, promotion.finishDate, 9.0);
				data.add(promotionData);
			}
			hotelPromotionTable.setItems(data);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
	
	@FXML
	void search(ActionEvent event) {
		// TODO
	}
	
    @FXML
    void delete(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
    	WindowGrab.startWindow(window, "删除促销策略",HOTEL_PROMOTION_CHANGE_FXML,HOTEL_PROMOTION_CHANGE_CSS);
	}

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

    @FXML
    void check(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "查看促销策略",HOTEL_PROMOTION_LOOK_FXML,HOTEL_PROMOTION_LOOK_CSS);
    }

    @FXML
    void create(ActionEvent event) {
    	Window window = WindowGrab.getWindow(event);
		WindowGrab.startWindow(window, "新建促销策略",HOTEL_PROMOTION_CREATE_FXML,HOTEL_PROMOTION_CREATE_CSS);
    }

}

