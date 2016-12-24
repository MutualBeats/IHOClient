package presentation.clientui.evaluatehotel;

import java.net.URL;
import java.util.ResourceBundle;

import bussinesslogic.controllerfactory.ControllerFactory;
import config.StarConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Window;
import presentation.clientui.browseorder.UpdateEvaluation;
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.Time;
import util.UserCache;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelEvaluationVO;
import vo.order.OrderVO;

/**
 * 评价酒店界面控制器
 * @author heleninsa
 *
 */
public class EvaluateHotelController implements Initializable, Confirm {

	@FXML
	private TextArea evaluation;

	@FXML
	private Button confirm;

	@FXML
	private Button cancel;

	@FXML
	private ComboBox<Integer> marks;

	@FXML
	private Label title;

	private OrderVO order;
	
	private UpdateEvaluation update;

	@FXML
	void confirm(ActionEvent event) {
		Window window = WindowGrab.getWindow(event);
		WindowGrab.startConfirmWindow(window, this, "是否确认评价？");
	}

	@FXML
	void cancel(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		update = (UpdateEvaluation) resources.getObject("update");
		marks.getItems().addAll(StarConfig.SCORE_SEPERATE);
		order = (OrderVO) resources.getObject("order_info");
	}

	@Override
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		if (CheckUtil.checkSelect(marks) && CheckUtil.checkText(evaluation)) {
			int mark = marks.getSelectionModel().getSelectedItem();
			HotelEvaluationVO vo = new HotelEvaluationVO(order.hotelID, UserCache.getID(), order.orderID, Time.getCurrentTime(), mark,
					evaluation.getText());
			ResultMessage_Hotel result = ResultMessage_Hotel.Evaluate_Successful;
			try {
				result = ControllerFactory.getHotelBLServiceInstance().evaluate(vo);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			}
			if (result == ResultMessage_Hotel.Net_Error) {
				WindowGrab.startNetErrorWindow(window);
			} else if (result == ResultMessage_Hotel.Evaluate_Successful) {
				order.setEvaluationState(true);
				update.update();
				WindowGrab.closeWindow(window);
				WindowGrab.startNoticeWindow(WindowGrab.getWindowByStage(0), "成功评论");
			} else {
				WindowGrab.startErrorWindow(window, "评论失败");
			}
		} else {
			WindowGrab.startNoticeWindow(window, "请输入评价");
		}
	}

	
}
