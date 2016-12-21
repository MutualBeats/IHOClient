package bussinesslogic.hotelbl;

import java.util.ArrayList;

import bussinesslogic.orderbl.HotelInfo;
import bussinesslogic.userbl.manager.entrust.HotelAdd;
import bussinesslogicservice.hotelblservice.HotelBLService;
import util.exception.NetException;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

/**
 *酒店控制器 
 * 
 * @author Saltwater
 */
public class HotelController implements HotelBLService, HotelAdd, HotelInfo {

	private Hotel hotel = new Hotel();
	
	public HotelController() throws NetException {
		
	}

	@Override
	public HotelVO showHotelInfo(String hotelID) throws NetException {
		return hotel.showHotelInfo(hotelID);
	}

	@Override
	public ResultMessage_Hotel changeHotelInfo(HotelVO vo) {
		return hotel.changeHotelInfo(vo);
	}

	@Override
	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) throws NetException {
		return hotel.getHotelsSatisfyCondition(sc);
	}

	@Override
	public ArrayList<HotelEvaluationVO> getHotelEvalutions(String hotelID) throws NetException {
		return hotel.getHotelEvalutions(hotelID);
	}

	@Override
	public ResultMessage_Hotel evaluate(HotelEvaluationVO vo) {
		return hotel.evaluate(vo);
	}

	@Override
	public String addHotel(HotelVO vo) throws NetException {
		return hotel.addHotel(vo);
	}

	@Override
	public String getBusinessDistrict(String hotelID) throws NetException {
		return hotel.showHotelInfo(hotelID).businessDistrict;
	}

}
