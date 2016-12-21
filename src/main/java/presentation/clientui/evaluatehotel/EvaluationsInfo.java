package presentation.clientui.evaluatehotel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import presentation.utilui.WindowGrab;
import vo.hotel.HotelEvaluationVO;

public class EvaluationsInfo implements Initializable {

	@FXML
	private TableColumn<HotelEvaluationVO, String> evaluation;

	@FXML
	private TableView<HotelEvaluationVO> evaluation_list;

	@FXML
	private TableColumn<HotelEvaluationVO, Integer> score;

	@FXML
	private Button back;

	@FXML
	private TableColumn<HotelEvaluationVO, String> order_id;

	@FXML
	void back(ActionEvent event) {
		WindowGrab.closeWindow(event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		@SuppressWarnings("unchecked")
		ArrayList<HotelEvaluationVO> evaluationVOs = (ArrayList<HotelEvaluationVO>) resources.getObject("evaluations");
		
		evaluation_list.getItems().addAll(evaluationVOs);
		evaluation.setCellValueFactory(cellData->cellData.getValue().getEvaluation_property());
		score.setCellValueFactory(cellData->cellData.getValue().getScore_property().asObject());
		order_id.setCellValueFactory(cellData->cellData.getValue().getOrder_property());
	}

}
