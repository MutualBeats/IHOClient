package presentation.marketui.unusualorder;


import bussinesslogic.controllerfactory.ControllerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.text.Text;
import javafx.stage.Window;
import presentation.utilui.WindowGrab;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderVO;

public class AppealController {

    @FXML
    private Button all;

    @FXML
    private Button half;

    @FXML
    private Text confirm_text;

    static boolean all_credit;
    
    @FXML
    void all(ActionEvent event) {
    	all_credit=true;
    }

    @FXML
    void half(ActionEvent event) {
    	all_credit=false;
    }
}
