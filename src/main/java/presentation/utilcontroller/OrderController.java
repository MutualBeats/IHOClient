package presentation.utilcontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.utilui.WindowGrab;
import vo.order.OrderVO;

public class OrderController implements Initializable {
	
	@FXML
	private Label user_name;
	
	
	@FXML
	private Label order_id;
	
	@FXML
	private Label order_status;
	

	@FXML
	private Label make_time;
	
	@FXML
	private Label finish_time;
	

	@FXML
	private Label expect_check_in;

	@FXML
	private Label expect_leave_time;
	
	@FXML
	private Label last_execute_time;
	
	
	@FXML
	private Label actual_in;
	
	@FXML
	private Label actual_out;

	

	@FXML
	private Label hotel_name;

	@FXML
	private Label people_num;

	@FXML
	private Label children;
	
	@FXML
	private Label price;
	
	@FXML
	private Label room_list;
	
	@FXML
	private Label promotion;
	
	@FXML
	private Button back;
	

	@FXML
	void back(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		OrderVO info = (OrderVO) resources.getObject("order_info");
		promotion.setText(resources.getString("promotion_name"));
		
		String hotel = resources.getString("hotel_name");
		
		user_name.setText(info.clientID);
		
		order_status.setText(info.getOrderState());
		order_id.setText(info.orderID);
		
		make_time.setText(info.makeTime);
		finish_time.setText(info.finishTime);
		
		expect_check_in.setText(info.estimate_checkInDate);
		expect_leave_time.setText(info.estimate_checkOutDate);
		last_execute_time.setText(info.latest_execute_time);
		
		actual_in.setText(info.executeTime);
		actual_out.setText(info.actual_checkOutDate);
		
		hotel_name.setText(hotel);
		
		people_num.setText(info.numOfPeople+"");
		children.setText(info.children ? "有" : "无");
		
		price.setText(info.value + " 元");
		
		ArrayList<String> rooms = info.roomNumberList;
		String room = "";
		for(String roomnumber : rooms) {
			room += roomnumber + "、 " ;
		}
		room_list.setText(room);
		

		
	}

}
