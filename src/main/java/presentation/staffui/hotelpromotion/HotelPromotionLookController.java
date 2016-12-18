package presentation.staffui.hotelpromotion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.promotion.PromotionType;
import vo.promotion.EnterprisePromotionVO;
import vo.promotion.PromotionVO;

public class HotelPromotionLookController implements Initializable {

    @FXML
    private Button cancel;

    @FXML
    private Label end_date;

    @FXML
    private Label promotion_type;

    @FXML
    private Label promotion_name;

    @FXML
    private Label promotion_ID;

    @FXML
    private Label hotel_name;

    @FXML
    private Label start_date;
    
    @FXML
    private Text enterprise_text;
    
    @FXML
    private ListView<String> enterprise_list;
    
    @FXML
    private TableColumn<Discount, String> discount;
    
    @FXML
    private TableColumn<Discount, String> member_level;
    
    @FXML
    private TableView<Discount> discount_list;
    
    private ObservableList<Discount> discountItems = FXCollections.observableArrayList();
    private ObservableList<String> enterpriseItems = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		PromotionVO promotion = (PromotionVO)resources.getObject("promotion");
		
		promotion_ID.setText(promotion.promotionID);
		promotion_name.setText(promotion.promotionName);
		promotion_type.setText(promotion.type.toString());
		start_date.setText(promotion.startDate);
		end_date.setText(promotion.finishDate);
		
		try {
			String hotelName = ControllerFactory.getHotelBLServiceInstance().showHotelInfo(UserCache.getHotelID()).hotelName;
			hotel_name.setText(hotelName);
		} catch (NetException e) {
			WindowGrab.startNetErrorWindow(WindowGrab.getWindowByStage(0));
		}
		
		for (int i = 0; i < promotion.discount.size(); i++)
			discountItems.add(new Discount(i, promotion.discount.get(i)));
		
		discount_list.setItems(discountItems);
		member_level.setCellValueFactory(cellData -> cellData.getValue().getLevelProperty());
		discount.setCellValueFactory(cellData -> cellData.getValue().getDiscountProperty());
		
		if(promotion.type == PromotionType.Enterprise) {
			enterprise_text.setVisible(true);
			enterprise_list.setVisible(true);
			EnterprisePromotionVO vo = (EnterprisePromotionVO)promotion;
			ArrayList<String> enterprises = vo.enterpriseList;
			enterpriseItems.addAll(enterprises);
			enterprise_list.setItems(enterpriseItems);
		}
		
	}

    @FXML
    void cancel(ActionEvent event) {
    	WindowGrab.closeWindow(event);
    }
    
    private class Discount {
    	private StringProperty levelProperty;
    	private StringProperty discountProperty;
    	
    	public StringProperty getLevelProperty() {
    		return levelProperty;
    	}
    	public StringProperty getDiscountProperty() {
    		return discountProperty;
    	}
    	public Discount(int level, double discount) {
    		levelProperty = new SimpleStringProperty(String.valueOf(level));
    		discountProperty = new SimpleStringProperty(String.valueOf(discount));
    	}
    }

}
