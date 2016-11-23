package bussinesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.Iterator;

import bussinesslogicservice.hotelblservice.HotelBLService;
import dataservice.hoteldataservice.ResultMessage_Hotel;
import util.SearchCondition;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

public class HotelController implements HotelBLService {

	private Hotel hotel = new Hotel();

	@Override
	public HotelVO showHotelInfo(String hotelID) throws RemoteException {
		return hotel.showHotelInfo(hotelID);
	}

	@Override
	public ResultMessage_Hotel changeHotelInfo(HotelVO vo) {
		return hotel.changeHotelInfo(vo);
	}

	@Override
	public Iterator<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) throws RemoteException {
		return hotel.getHotelsSatisfyCondition(sc);
	}

	@Override
	public Iterator<HotelEvaluationVO> getHotelEvalutions(String hotelID) throws RemoteException {
		return hotel.getHotelEvalutions(hotelID);
	}

	@Override
	public ResultMessage_Hotel evaluate(HotelEvaluationVO vo) {
		return hotel.evaluate(vo);
	}

	@Override
	public ResultMessage_Hotel addHotel(HotelVO vo) {
		return hotel.addHotel(vo);
	}

}
