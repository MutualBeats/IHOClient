package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.hotel.HotelEvaluationVO;

public class EvaluationBundle extends ResourceBundle {

	private ArrayList<HotelEvaluationVO> evaluations;
	private final static String EVA = "evaluations";

	public EvaluationBundle(ArrayList<HotelEvaluationVO> evaluations) {
		super();
		this.evaluations = evaluations;
	}

	@Override
	protected Object handleGetObject(String key) {
		if (EVA.equals(key)) {
			return evaluations;
		}
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
