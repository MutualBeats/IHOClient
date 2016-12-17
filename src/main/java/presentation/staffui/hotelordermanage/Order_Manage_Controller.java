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
import presentation.utilcontroller.Confirm;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderVO;

public class Order_Manage_Controller implements Initializable, Confirm {
	
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
	private Button all_order;
	
	@FXML
	private Button finished_order;

	@FXML
	private Button revoked_order;

	@FXML
	private Button exception_order;

	@FXML
	private Button unexecuted_order;

    @FXML
    private Button cancel;

    @FXML
    private Label order_manage_title;

    @FXML
    private Button check;

    private static URL ORDER_CHECK_FXML;
    private static URL ORDER_CHECK_CSS;
    
	static {
		try {
			ORDER_CHECK_FXML = new URL("file:src/main/resources/ui/utilui/fxml/order_information.fxml");
			ORDER_CHECK_CSS = new URL("file:src/main/resources/ui/utilui/css/order_information.css");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private ObservableList<OrderVO> total_list;
	private ObservableList<OrderVO> finished_list;
	private ObservableList<OrderVO> unexecuted_list;
	private ObservableList<OrderVO> revoked_list;
	private ObservableList<OrderVO> exception_list;

	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<OrderVO> total = (ArrayList<OrderVO>) resources.getObject("total");
		ArrayList<OrderVO> finish = (ArrayList<OrderVO>) resources.getObject("finish");
		ArrayList<OrderVO> unexecuted = (ArrayList<OrderVO>) resources.getObject("unexecute");
		ArrayList<OrderVO> revoked = (ArrayList<OrderVO>) resources.getObject("revoked");
		ArrayList<OrderVO> exception = (ArrayList<OrderVO>) resources.getObject("exception");
		
		total_list = FXCollections.observableArrayList();
		finished_list = FXCollections.observableArrayList();
		unexecuted_list = FXCollections.observableArrayList();
		revoked_list = FXCollections.observableArrayList();
		exception_list = FXCollections.observableArrayList();
		
		total_list.addAll(total);
		finished_list.addAll(finish);
		unexecuted_list.addAll(unexecuted);
		revoked_list.addAll(revoked);
		exception_list.addAll(exception);

		order_list.setItems(total_list);

		initColumn();
	}
	
	private void initColumn() {
		order_id.setCellValueFactory(cellData -> cellData.getValue().getId_property());
		client_name.setCellValueFactory(cellData -> {
			try {
				return new SimpleStringProperty(ControllerFactory.getClientBLServiceInstance()
						.getClientInfo(cellData.getValue().getClientProperty().getValue()).name);
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
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }

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
			try {
				hotel_name = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(UserCache.getHotelID()).hotelName;
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			}
			OrderInfoBundle bundle = new OrderInfoBundle(info, hotel_name);

			WindowGrab.startWindowWithBundle(window, "订单详情", ORDER_CHECK_FXML, ORDER_CHECK_CSS, bundle);
		}
    }
    
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
		if(info.estimate_checkOutDate.compareTo(util.Time.getCurrentDate()) < 0) {
			WindowGrab.startNoticeWindow(window, "超出时间无法补录");
			return;
		}
		WindowGrab.startConfirmWindow(window, this, "是否确认补录");
    	
    }

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(0);
		OrderVO info = order_list.getSelectionModel().getSelectedItem();
		try {
			OrderBLService orderBLService = ControllerFactory.getOrderBLServiceInstance();
			ResultMessage_Order result = orderBLService.putUpOrder(info.orderID);
			switch (result) {
			case Put_Up_Successful:
				WindowGrab.startNoticeWindow(window, "补录成功");
				break;
			case Room_Already_Ordered:
				WindowGrab.startNoticeWindow(window, "房间已被预订，无法补录");
				break;
			case Order_State_Error:
				WindowGrab.startNoticeWindow(window, "非异常订单，无法补录");
				break;
			case Date_Error:
				WindowGrab.startNoticeWindow(window, "超出时间无法补录");
				break;
			case Net_Error:
				WindowGrab.startNetErrorWindow(window);
			default:
				WindowGrab.startNoticeWindow(window, "异常错误");
				break;
			}
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(window);
		}		
	}

}
