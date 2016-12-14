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
import presentation.utilcontroller.Confirm;
import presentation.utilui.CheckUtil;
import presentation.utilui.WindowGrab;
import util.UserCache;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelEvaluationVO;

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

	private String hotel_id;

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
	public void confirm() {
		Window window = WindowGrab.getWindowByStage(1);
		if (CheckUtil.checkSelect(marks) && CheckUtil.checkText(evaluation)) {
			int mark = marks.getSelectionModel().getSelectedItem();
			HotelEvaluationVO vo = new HotelEvaluationVO(hotel_id, UserCache.getID(), "", mark, evaluation.getText());
			ResultMessage_Hotel result = ResultMessage_Hotel.Evaluate_Successful;
			try {
				result = ControllerFactory.getHotelBLServiceInstance().evaluate(vo);
			} catch (NetException e) {
				WindowGrab.startNetErrorWindow(window);
			}
			if(result == ResultMessage_Hotel.Net_Error) {
				WindowGrab.startNetErrorWindow(window);
			} else if(result == ResultMessage_Hotel.Evaluate_Successful) {
				WindowGrab.closeWindow(window);
				WindowGrab.startNoticeWindow(WindowGrab.getWindowByStage(0), "成功评论");
			} else {
				WindowGrab.startErrorWindow(window, "评论失败");
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		marks.getItems().addAll(StarConfig.SCORE_SEPERATE);
		hotel_id = resources.getString("hotel_id");
	}
}
