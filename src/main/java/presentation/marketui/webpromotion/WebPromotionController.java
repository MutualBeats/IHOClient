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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Window;
import presentation.bundle.PromotionInfoBundle;
import presentation.utilui.WindowGrab;
import vo.promotion.PromotionVO;

public class WebPromotionController implements PromotionUpdate,Initializable{
	
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
    private Button update;

    @FXML
    private TableView<PromotionVO> promotion_list;

    @FXML
    private Button create;

    @FXML
    private TableColumn<PromotionVO, String> type;

    @FXML
    private TableColumn<PromotionVO, String> finish_time;
    
    
    
    private ObservableList<PromotionVO> total;    

    private static URL WEB_PROMOTION_CHOOSE_FXML;
    private static URL WEB_PROMOTION_CHOOSE_CSS;
    
    private static URL WEB_PROMOTION_UPDATE_FXML;
    private static URL WEB_PROMOTION_UPDATE_CSS;
    
    
    private static URL WEB_PROMOTION_CHECK_FXML;
    private static URL WEB_PROMOTION_CHECK_CSS;
    
    static{
    	try {
    		
    		WEB_PROMOTION_CHOOSE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/promotion_choose.fxml");
    		WEB_PROMOTION_CHOOSE_CSS=new URL("file:src/main/resources/ui/marketui/css/promotion_choose.css");
    		
    		WEB_PROMOTION_UPDATE_FXML=new URL("file:src/main/resources/ui/marketui/fxml/web_promotion_update.fxml");
    		WEB_PROMOTION_UPDATE_CSS=new URL("file:src/main/resources/ui/marketui/css/web_promotion_update.css");
    		
    		WEB_PROMOTION_CHECK_FXML=new URL("file:src/main/resources/ui/marketui/fxml/promotion_check.fxml");
    		WEB_PROMOTION_CHECK_CSS=new URL("file:src/main/resources/ui/marketui/css/promotion_check.css");
    		
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
    	WindowGrab.startWindow(window, "修改网站促销策略", WEB_PROMOTION_UPDATE_FXML,WEB_PROMOTION_UPDATE_CSS);
    }

    @FXML
    void create(ActionEvent event) {
     	Window window = WindowGrab.getWindow(event);
     	WindowGrab.startWindow(window, "选择新建促销策略类型", WEB_PROMOTION_CHOOSE_FXML,WEB_PROMOTION_CHOOSE_CSS);
   
    }

	@Override
	public void update(String promotionID) {
		//获取单个并添加到对应类型表和总表中
		
		
	}

	@FXML
    void check(ActionEvent event) {
		Window window =WindowGrab.getWindow(event);
		PromotionVO promotion=null;
		promotion=promotion_list.getSelectionModel().getSelectedItem();
		ResourceBundle bundle=new PromotionInfoBundle(promotion);
		WindowGrab.startWindowWithBundle(window, "促销策略详情", WEB_PROMOTION_CHECK_FXML	, WEB_PROMOTION_CHECK_CSS, bundle);
    }
}

