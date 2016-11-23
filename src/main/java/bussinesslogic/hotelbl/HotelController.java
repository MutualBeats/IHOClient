package bussinesslogic.hotelbl;

import java.util.ArrayList;

import bussinesslogicservice.hotelblservice.HotelBLService;
import util.ResultMessage_For_Stub;
import util.SearchCondition;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class HotelController implements HotelBLService {
	
	private Hotel hotel = new Hotel();

	@Override
	public HotelVO showHotelData(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub changeHotelData(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> showHotelListData(SearchCondition sc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<HotelEvaluationVO> showHotelEvaluationListData(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub evaluateHotel(HotelEvaluationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
