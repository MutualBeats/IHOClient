/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.staffui.hotelordermanage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogicservice.orderblservice.OrderBLService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.stage.Window;
import presentation.bundle.OrderInfoBundle;
import presentation.utilui.WindowGrab;
import util.Time;
import util.UserCache;
import util.exception.NetException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderVO;

public class Order_Manage_Controller implements Initializable {
	
	@FXML
	private TableView<OrderVO> order_list;
	
	@FXML
	private TableColumn<OrderVO, String> order_id;
	
	@FXML
	private TableColumn<OrderVO, String> client_name;
	
	@FXML
	private TableColumn<OrderVO, String> order_state;
	
	@FXML
	private TableColumn<OrderVO, String> check_in_date;
	
	@FXML
	private TableColumn<OrderVO, String> estimate_check_out_date;
	
	@FXML
	private TableColumn<OrderVO, String> actual_check_out_date;
	
	@FXML
    private Button execute_button;
	
	@FXML
    private Button finish_button;
	
	@FXML
    private Button supply_button;
	
	@FXML
	private Button execute_order;
	
	@FXML
	private Label execute_order_pressed;
	
	@FXML
	private Button finished_order;

	@FXML
	private Label finished_order_pressed;
	
	@FXML
	private Button revoked_order;

	@FXML
	private Label revoked_order_pressed;
	
	@FXML
	private Button exception_order;
	
	@FXML
	private Label exception_order_pressed;

	@FXML
	private Button unexecuted_order;

	@FXML
	private Label unexecuted_order_pressed;

	
    @FXML
    private Button cancel;

    @FXML
    private Label order_manage_title;

    @FXML
    private Button check;

    private static URL ORDER_CHECK_FXML;
    private static URL ORDER_CHECK_CSS;
    
    //人员信息界面
    private static URL MENU_FXML;
    private static URL MENU_CSS;
    
	static {
		try {
			ORDER_CHECK_FXML = new URL("file:src/main/resources/ui/utilui/fxml/order_information.fxml");
			ORDER_CHECK_CSS = new URL("file:src/main/resources/ui/utilui/css/order_information.css");
		
			MENU_FXML = new URL("file:src/main/resources/ui/staffui/fxml/staff_main.fxml");
    		MENU_CSS = new URL("file:src/main/resources/ui/staffui/css/staff_main.css");
    		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private OrderBLService orderBLService;
	
	private ObservableList<OrderVO> finished_list = FXCollections.observableArrayList();
	private ObservableList<OrderVO> unexecuted_list = FXCollections.observableArrayList();
	private ObservableList<OrderVO> execute_list = FXCollections.observableArrayList();
	private ObservableList<OrderVO> revoked_list = FXCollections.observableArrayList();
	private ObservableList<OrderVO> exception_list = FXCollections.observableArrayList();

	/**
	 * 订单管理界面初始化
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			orderBLService = ControllerFactory.getOrderBLServiceInstance();
			
			// 不同类型订单获取
			String hotelID = UserCache.getHotelID();
			ArrayList<OrderVO> finish = orderBLService.queryHotelOrder(hotelID, OrderState.Finished);
			ArrayList<OrderVO> unexecuted = orderBLService.queryHotelOrder(hotelID, OrderState.Unexecuted);
			ArrayList<OrderVO> execute = orderBLService.queryHotelOrder(hotelID, OrderState.Execute);
			ArrayList<OrderVO> revoked = orderBLService.queryHotelOrder(hotelID, OrderState.Canceled);
			ArrayList<OrderVO> exception = orderBLService.queryHotelOrder(hotelID, OrderState.Exception);
			// 列表初始化
			execute_list.addAll(execute);
			finished_list.addAll(finish);
			unexecuted_list.addAll(unexecuted);
			revoked_list.addAll(revoked);
			exception_list.addAll(exception);
			// 初始显示执行中订单
			order_list.setItems(execute_list);
			initColumn();
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
	}
	
	private void initColumn() {
		order_id.setCellValueFactory(cellData -> cellData.getValue().getId_property());
		client_name.setCellValueFactory(cellData -> {
			try {
				return ControllerFactory.getClientBLServiceInstance()
						.getClientInfo(cellData.getValue().clientID).getName_property();
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
				return new SimpleStringProperty("");
			}
		});
		order_state.setCellValueFactory(cellData -> cellData.getValue().getState_property());
		check_in_date.setCellValueFactory(cellData -> cellData.getValue().getCheck_in_date_property());
		estimate_check_out_date.setCellValueFactory(cellData -> cellData.getValue().getEstimate_check_out_date_property());
		actual_check_out_date.setCellValueFactory(cellData -> cellData.getValue().getActual_check_out_date_property());
	}
	
	@FXML
	void execute_order(ActionEvent event) {
		// 显示执行中订单
		order_list.setItems(execute_list);
		
		exception_order.setVisible(true);
		execute_order.setVisible(false);
		unexecuted_order.setVisible(true);
		finished_order.setVisible(true);
		revoked_order.setVisible(true);
		
		exception_order_pressed.setVisible(false);
		execute_order_pressed.setVisible(true);
		unexecuted_order_pressed.setVisible(false);
		finished_order_pressed.setVisible(false);
		revoked_order_pressed.setVisible(false);
		
	}

	@FXML
	void finished_order(ActionEvent event) {
		// 显示已完成订单
		order_list.setItems(finished_list);
		
		exception_order.setVisible(true);
		execute_order.setVisible(true);
		unexecuted_order.setVisible(true);
		finished_order.setVisible(false);
		revoked_order.setVisible(true);
		
		exception_order_pressed.setVisible(false);
		execute_order_pressed.setVisible(false);
		unexecuted_order_pressed.setVisible(false);
		finished_order_pressed.setVisible(true);
		revoked_order_pressed.setVisible(false);
	}

	@FXML
	void unexecuted_order(ActionEvent event) {
		// 显示未执行订单
		order_list.setItems(unexecuted_list);
		
		exception_order.setVisible(true);
		execute_order.setVisible(true);
		unexecuted_order.setVisible(false);
		finished_order.setVisible(true);
		revoked_order.setVisible(true);
		
		exception_order_pressed.setVisible(false);
		execute_order_pressed.setVisible(false);
		unexecuted_order_pressed.setVisible(true);
		finished_order_pressed.setVisible(false);
		revoked_order_pressed.setVisible(false);
	}

	@FXML
	void revoked_order(ActionEvent event) {
		// 显示已撤销订单
		order_list.setItems(revoked_list);
		
		exception_order.setVisible(true);
		execute_order.setVisible(true);
		unexecuted_order.setVisible(true);
		finished_order.setVisible(true);
		revoked_order.setVisible(false);
		
		exception_order_pressed.setVisible(false);
		execute_order_pressed.setVisible(false);
		unexecuted_order_pressed.setVisible(false);
		finished_order_pressed.setVisible(false);
		revoked_order_pressed.setVisible(true);
	}

	@FXML
	void exception_order(ActionEvent event) {
		// 显示异常订单
		order_list.setItems(exception_list);
		
		exception_order.setVisible(false);
		execute_order.setVisible(true);
		unexecuted_order.setVisible(true);
		finished_order.setVisible(true);
		revoked_order.setVisible(true);
		
		exception_order_pressed.setVisible(true);
		execute_order_pressed.setVisible(false);
		unexecuted_order_pressed.setVisible(false);
		finished_order_pressed.setVisible(false);
		revoked_order_pressed.setVisible(false);
	}

	
	@FXML
    void cancel(ActionEvent event) {
    	WindowGrab.changeScene(MENU_FXML, MENU_CSS, event);
    }

	/**
	 * 查看订单
	 */
    @FXML
    void check(ActionEvent event) {
    	TableViewSelectionModel<OrderVO> model = order_list.getSelectionModel();
		Window window = WindowGrab.getWindow(event);
		int select_index = model.getSelectedIndex();
		if (select_index == -1) {
			WindowGrab.startNoticeWindow(window, "请选择要查看的订单");
		} else {
			OrderVO info = model.getSelectedItem();
			String hotel_name = null;
			String promotion_name = "无";
			try {
				hotel_name = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(UserCache.getHotelID()).hotelName;
				if(info.promotionIDList.size() > 0)
					promotion_name = ControllerFactory.getPromotionBLServiceInstance().getPromotionById(info.promotionIDList.get(0)).promotionName;
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			}
			OrderInfoBundle bundle = new OrderInfoBundle(info, hotel_name, promotion_name);

			WindowGrab.startWindowWithBundle(window, "订单详情", ORDER_CHECK_FXML, ORDER_CHECK_CSS, bundle);
		}
    }
    
    /**
     * 执行订单
     */
    @FXML
    void execute(ActionEvent event) {
    	TableViewSelectionModel<OrderVO> model = order_list.getSelectionModel();
		Window window = WindowGrab.getWindow(event);
		int select_index = model.getSelectedIndex();
		if (select_index == -1) {
			WindowGrab.startNoticeWindow(window, "请选择需要执行的订单");
			return;
		}
		OrderVO info = model.getSelectedItem();
		if(info.orderState != OrderState.Unexecuted) {
			WindowGrab.startNoticeWindow(window, "非未执行订单，无法执行");
			return;
		}
		if(info.estimate_checkInDate.compareTo(Time.getCurrentDate()) != 0) {
			WindowGrab.startNoticeWindow(window, "未到预订入住日期，无法执行");
			return;
		}
		try {
			OrderBLService orderBLService = ControllerFactory.getOrderBLServiceInstance();
			ResultMessage_Order result = orderBLService.executeOrder(info.orderID);
			switch (result) {
			case Execute_Successful:
				unexecuted_list.remove(select_index);
				info = orderBLService.queryOrderById(info.orderID);
				execute_list.add(0, info);
				order_list.setItems(execute_list);
				WindowGrab.startNoticeWindow(window, "订单执行成功");
				break;
			case Order_State_Error:
				WindowGrab.startErrorWindow(window, "非未执行订单，无法执行");
				break;
			case Date_Error:
				WindowGrab.startErrorWindow(window, "未到预订入住日期，无法执行");
				break;
			case Net_Error:
				WindowGrab.startNetErrorWindow(window);
			default:
				WindowGrab.startErrorWindow(window, "异常错误");
				break;
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
    }
    
    /**
     * 完成订单
     */
    @FXML 
    void finish(ActionEvent event) {
    	TableViewSelectionModel<OrderVO> model = order_list.getSelectionModel();
		Window window = WindowGrab.getWindow(event);
		int select_index = model.getSelectedIndex();
		if (select_index == -1) {
			WindowGrab.startNoticeWindow(window, "请选择需要退房的订单");
			return;
		}
		OrderVO info = model.getSelectedItem();
		if(info.orderState != OrderState.Execute) {
			WindowGrab.startNoticeWindow(window, "非执行中订单，无法退房");
			return;
		}
		if(info.estimate_checkOutDate.compareTo(Time.getCurrentDate()) < 0) {
			WindowGrab.startNoticeWindow(window, "已过预计离开日期，无法退房");
			return;
		}
		try {
			OrderBLService orderBLService = ControllerFactory.getOrderBLServiceInstance();
			ResultMessage_Order result = orderBLService.finishOrder(info.orderID);
			switch (result) {
			case Finish_Successful:
				execute_list.remove(select_index);
				info = orderBLService.queryOrderById(info.orderID);
				finished_list.add(0, info);
				order_list.setItems(finished_list);
				WindowGrab.startNoticeWindow(window, "退房成功");
				break;
			case Order_State_Error:
				WindowGrab.startErrorWindow(window, "非执行中订单，无法退房");
				break;
			case Net_Error:
				WindowGrab.startNetErrorWindow(window);
			default:
				WindowGrab.startErrorWindow(window, "异常错误");
				break;
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
    }
    
    /**
     * 补录订单
     */
    @FXML
    void supply(ActionEvent event) {
    	TableViewSelectionModel<OrderVO> model = order_list.getSelectionModel();
		Window window = WindowGrab.getWindow(event);
		int select_index = model.getSelectedIndex();
		if (select_index == -1) {
			WindowGrab.startNoticeWindow(window, "请选择需要补录的订单");
			return;
		}
		OrderVO info = model.getSelectedItem();
		if(info.orderState != OrderState.Exception) {
			WindowGrab.startNoticeWindow(window, "非异常订单，无法补录");
			return;
		}
		if(info.estimate_checkOutDate.compareTo(Time.getCurrentDate()) < 0) {
			WindowGrab.startNoticeWindow(window, "超出时间无法补录");
			return;
		}
		try {
			OrderBLService orderBLService = ControllerFactory.getOrderBLServiceInstance();
			ResultMessage_Order result = orderBLService.putUpOrder(info.orderID);
			switch (result) {
			case Put_Up_Successful:
				exception_list.remove(select_index);
				info = orderBLService.queryOrderById(info.orderID);
				execute_list.add(0, info);
				order_list.setItems(execute_list);
				WindowGrab.startNoticeWindow(window, "补录成功");
				break;
			case Room_Already_Ordered:
				WindowGrab.startErrorWindow(window, "房间已被预订，无法补录");
				break;
			case Order_State_Error:
				WindowGrab.startErrorWindow(window, "非异常订单，无法补录");
				break;
			case Date_Error:
				WindowGrab.startErrorWindow(window, "超出时间无法补录");
				break;
			case Net_Error:
				WindowGrab.startNetErrorWindow(window);
			default:
				WindowGrab.startErrorWindow(window, "异常错误");
				break;
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}
    	
    }


}
