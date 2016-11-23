package bussinesslogic.hotelbl;

import java.util.ArrayList;

import bussinesslogicservice.hotelblservice.HotelBLService;
import util.SearchCondition;
import util.result_message.hotel.ResultMessage_HotelBLService;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

public class HotelController implements HotelBLService {
	
	private Hotel hotel = new Hotel();

	@Override
	public HotelVO showHotelInfo(String hotelID) {
		return hotel.showHotelInfo(hotelID);
	}

	@Override
	public ResultMessage_HotelBLService changeHotelInfo(HotelVO vo) {
		return hotel.changeHotelInfo(vo);
	}

	@Override
	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) {
		return hotel.getHotelsSatisfyCondition(sc);
	}
	
	@Override
	public ArrayList<HotelEvaluationVO> getHotelEvalutions(String hotelID) {
		return hotel.getHotelEvalutions(hotelID);
	}

	@Override
	public ResultMessage_HotelBLService evaluate(HotelEvaluationVO vo) {
		return hotel.evaluate(vo);
	}

	@Override
	public ResultMessage_HotelBLService addHotel(HotelVO vo) {
		return hotel.addHotel(vo);
	}

}
