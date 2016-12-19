/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.marketui.unexcutedorder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.bundle.PromotionBundle;
import presentation.bundle.SingleOrderListBundle;
import presentation.marketui.credit.CreditIDInputHandle;
import presentation.marketui.utilui.OrderListView;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import vo.order.OrderVO;
import vo.promotion.PromotionVO;

public class UnexcutedOrderController extends OrderListView{


    @FXML
    private TableColumn<OrderVO,String> user_name;

    @FXML
    private TableColumn<OrderVO,String> contact;


    @FXML
    private TableColumn<OrderVO,String> id;

    @FXML
    private TableView<OrderVO> order_list;

    @FXML
    private TableColumn<OrderVO,String> hotelname;

    @FXML
    private Button credit;

    @FXML
    private Button unexecuted_order;
    
    @FXML
    private Button web_promotion;
    
    @FXML
    private Button unusual_order;

    private static URL WEB_PROMOTION_FXML;
    private static URL WEB_PROMOTION_CSS;
    
    private static URL UNUSUAL_ORDER_FXML;
    private static URL UNUSUAL_ORDER_CSS;
    
    
    private static URL MENU_FXML;
    private static URL MENU_CSS;
    
    
    static{
    	try {
    		WEB_PROMOTION_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion.fxml");
    		WEB_PROMOTION_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion.css");
    		
    		UNUSUAL_ORDER_FXML=new URL("file:src/main/resources/ui/marketui/fxml/unusual_order.fxml");
    		UNUSUAL_ORDER_CSS=new URL("file:src/main/resources/ui/marketui/css/unusual_order.css");
    		
    		MENU_FXML=new URL("file:src/main/resources/ui/marketui/fxml/marketmenu.fxml");
    		MENU_CSS=new URL("file:src/main/resources/ui/marketui/css/marketmenu.css");
    		
    	} catch (MalformedURLException e) {
			e.printStackTrace();
			
		}
    }
    
	@Override
	@SuppressWarnings("unchecked")
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<OrderVO> unexecute_order=(ArrayList<OrderVO>) resources.getObject("order_list");
		order_list.getItems().addAll(unexecute_order);
		initColumn();
	}
	
	private void initColumn(){
		id.setCellValueFactory(celldata->celldata.getValue().getId_property());
//		 ControllerFactory.getClientBLServiceInstance().getClientInfo(clientID)
		user_name.setCellValueFactory(celldata->{
			try {
				return ControllerFactory.getClientBLServiceInstance().getClientInfo(celldata.getValue().clientID).getName_property();
			} catch (NetException e1) {
				// TODO Net Exception
				return new SimpleStringProperty("");
			}
		});

		contact.setCellValueFactory(celldata->{
			try{
				return ControllerFactory.getClientBLServiceInstance().getClientInfo(celldata.getValue().clientID).getContact_property();
			}catch (NetException e) {
				// TODO: Net Exception 
				return new SimpleStringProperty("");
			}
		});
		
		hotelname.setCellValueFactory(celldata -> { 
			try{
				return new SimpleStringProperty(ControllerFactory.getHotelBLServiceInstance()
						.showHotelInfo(celldata.getValue().getHotel_property().getValue()).hotelName);
			}catch (NetException e) {
				// TODO: handle exception
				WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
				return new SimpleStringProperty("");
			}
		});
	}

	@FXML
    void on_credit(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
    	WindowGrab.startIDInputWindow(window, new CreditIDInputHandle());
    }

    @FXML
    void web_promotion(ActionEvent event) {
    	Scene frame=WindowGrab.getScene(event);
    	ArrayList<PromotionVO> promotionList=null;
    	try {
			promotionList=ControllerFactory.getPromotionBLServiceInstance().getWebPromotion();
		} catch (NetException e) {
			Window window=WindowGrab.getWindow(event);
			WindowGrab.startNetErrorWindow(window);
		}
    	ResourceBundle bundle=new PromotionBundle(promotionList);
    	WindowGrab.changeSceneWithBundle(WEB_PROMOTION_FXML, WEB_PROMOTION_CSS, frame, bundle);
    	
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
    void peopleInfo(ActionEvent event) {
    	WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
    }
}
