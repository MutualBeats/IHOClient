package presentation.clientui.mainclient;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.order.OrderState;
import vo.order.OrderVO;

public class MainClientController {

	@FXML
    private Button all;

    @FXML
    private Label hotel_one;

    @FXML
    private Label hotel_four;

    @FXML
    private Label user_name;

    @FXML
    private Label hotel_five;

    @FXML
    private Button history;

    @FXML
    private Label title;

    @FXML
    private Label hotel_six;

    @FXML
    private Button logout;

    @FXML
    private Button browse_order;

    @FXML
    private Button search;

    @FXML
    private Button member;

    @FXML
    private Button maintain_message;

    @FXML
    private Label hotel_three;

    @FXML
    private Label hotel_seven;

    @FXML
    private Label hotel_two;

	
    //浏览订单
    private static URL BROWSE_ORDER_FXML;
    private static URL BROWSE_ORDER_CSS;
    
    //注册会员
    private static URL MEMBER_FXML;
    private static URL MEMBER_CSS;
    
   
    //维护个人信息
    private static URL MAINTAIN_MESSAGE_FXML;
    private static URL MAINTAIN_MESSAGE_CSS;
    
    //搜索酒店
    private static URL SEARCH_HOTEL_FXML;
    private static URL SEARCH_HOTEL_CSS;
    
    //历史记录
    private static URL HISTORY_FXML;
    private static URL HISTORY_CSS;
    
    static{
    	try {
    		BROWSE_ORDER_FXML=new URL("file:src/main/resources/ui/clientui/fxml/browse_order.fxml");
			BROWSE_ORDER_CSS=new URL("file:src/main/resources/ui/clientui/css/browse_order.css");
		
			MEMBER_FXML=new URL("file:src/main/resources/ui/clientui/fxml/member.fxml");
			MEMBER_CSS=new URL("file:src/main/resources/ui/clientui/css/member.css");
		
			MAINTAIN_MESSAGE_FXML=new URL("file:src/main/resources/ui/clientui/fxml/maintain_message.fxml");
			MAINTAIN_MESSAGE_CSS=new URL("file:src/main/resources/ui/clientui/css/maintain_message.css");
		
			SEARCH_HOTEL_FXML=new URL("file:src/main/resources/ui/clientui/fxml/search_hotel.fxml");
			SEARCH_HOTEL_CSS=new URL("file:src/main/resources/ui/clientui/css/search_hotel.css");
		
			HISTORY_FXML=new URL("file:src/main/resources/ui/clientui/fxml/history.fxml");
			HISTORY_CSS=new URL("file:src/main/resources/ui/clientui/css/history.css");
		
			
    	} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
    

    @FXML
    void browse_order(ActionEvent event) {
    	OrderVO vo = new OrderVO("123", OrderState.Canceled, "123", "213", new ArrayList<>(), new ArrayList<>(), 10000, "1111", "1111", "1111", "222", "222", "111", "213", 3, false);
    	ArrayList<OrderVO> total = new ArrayList<>();
    	total.add(vo);
    	
    	Scene frame =WindowGrab.getScene(event);
    	WindowGrab.changeScene(BROWSE_ORDER_FXML, BROWSE_ORDER_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("浏览订单");
    }

   

    @FXML
    void member(ActionEvent event) {
    	Window window=WindowGrab .getWindow(event);
    	WindowGrab.startWindow(window, "注册会员", MEMBER_FXML, MEMBER_CSS);
    }

    @FXML
    void maintain_message(ActionEvent event) {
    	Window window=WindowGrab .getWindow(event);
    	WindowGrab.startWindow(window, "个人信息详情", MAINTAIN_MESSAGE_FXML, MAINTAIN_MESSAGE_CSS);
    }

    
    @FXML
    void logout(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void on_search(ActionEvent event) {
    	Scene frame =WindowGrab.getScene(event);
    	WindowGrab.changeScene(SEARCH_HOTEL_FXML, SEARCH_HOTEL_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("搜索酒店");
    
    }
    @FXML
    void history(ActionEvent event) {
    	Scene frame =WindowGrab.getScene(event);
    	WindowGrab.changeScene(HISTORY_FXML, HISTORY_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("历史记录");
    }
}

