package bussinesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.orderbl.HotelInfo;
import bussinesslogic.userbl.manager.entrust.HotelAdd;
import bussinesslogicservice.hotelblservice.HotelBLService;
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
	
	public HotelController() throws Exception {
		
	}

	@Override
	public HotelVO showHotelInfo(String hotelID) throws RemoteException {
		return hotel.showHotelInfo(hotelID);
	}

	@Override
	public ResultMessage_Hotel changeHotelInfo(HotelVO vo) {
		return hotel.changeHotelInfo(vo);
	}

	@Override
	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) throws RemoteException {
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

	@Override
	public String getBusinessDistrict(String hotelID) throws RemoteException {
		return hotel.showHotelInfo(hotelID).businessDistrict;
	}

}
