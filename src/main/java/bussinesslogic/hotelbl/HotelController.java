package bussinesslogic.hotelbl;

import java.util.ArrayList;

import bussinesslogicservice.hotelblservice.HotelBLService;
import util.SearchCondition;
import util.result_message.hotel.ResultMessage_HotelBLService;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class HotelController implements HotelBLService {
	
	private Hotel hotel = new Hotel();

	@Override
	public HotelVO showHotelData(String hotelID) {
		return hotel.showHotelData(hotelID);
	}

	@Override
	public ResultMessage_HotelBLService changeHotelData(HotelVO vo) {
		return hotel.changeHotelData(vo);
	}

	@Override
	public ArrayList<HotelVO> showHotelListData(SearchCondition sc) {
		return hotel.showHotelListData(sc);
	}
	
	@Override
	public ArrayList<HotelEvaluationVO> showHotelEvaluationListData(String hotelID) {
		return hotel.showHotelEvaluationListData(hotelID);
	}

	@Override
	public ResultMessage_HotelBLService evaluateHotel(HotelEvaluationVO vo) {
		return hotel.evaluateHotel(vo);
	}

	@Override
	public ResultMessage_HotelBLService addHotel(HotelVO vo) {
		return hotel.addHotel(vo);
	}

}
