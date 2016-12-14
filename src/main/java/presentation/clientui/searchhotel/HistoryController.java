package presentation.clientui.searchhotel;

import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.utilui.WindowGrab;

public class HistoryController { 

	@FXML
    private Button cancel;

    @FXML
    private TableView<?> hotel_list;

    @FXML
    private TableColumn<?, ?> province;

    @FXML
    private TableColumn<?, ?> field;

    @FXML
    private TableColumn<?, ?> city;

    @FXML
    private Button info_look;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private Pane history_hotel_pane;

    @FXML
    private Label title;

    @FXML
    private TableColumn<?, ?> group;
    
    
    private static URL CHECK_FXML;
    private static URL CHECK_CSS;
    
    private static URL CLIENTMENU_FXML;
    private static URL CLIENTMENU_CSS;
    
    static{
    	try {
			
			CHECK_FXML=new URL("file:src/main/resources/ui/clientui/fxml/check.fxml");
			CHECK_CSS=new URL("file:src/main/resources/ui/clientui/css/check.css");
			
			CLIENTMENU_FXML=new URL("file:src/main/resources/ui/clientui/fxml/clientmenu.fxml");
			CLIENTMENU_CSS=new URL("file:src/main/resources/ui/clientui/css/clientmenu.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
   
    
    @FXML
    void cancel(ActionEvent event) {
    	Scene frame=WindowGrab .getScene(event);
    	WindowGrab.changeScene(CLIENTMENU_FXML, CLIENTMENU_CSS, frame);
    	Stage stage=WindowGrab.getStage(0);
    	stage.setTitle("Client Menu");
    }
}
