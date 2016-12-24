/**
 * @author huangxiao
 */
package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.hotel.HotelEvaluationPO;
import po.hotel.HotelPO;
import util.Time;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;

public class HotelDataService_Stub implements HotelDataService {

	private static final int HOTEL_ID_LENTH = 8;
	
	private HotelPO hotelPO;
	private HotelEvaluationPO evaluationPO;
	
	
	public HotelDataService_Stub() {
		hotelPO = new HotelPO();
		hotelPO.setHotelID("00000001");
		hotelPO.setHotelName("测试酒店");
		hotelPO.setRegion("江苏省 南通市 如皋市");
		hotelPO.setBusinessDistrict("如城商圈");
		hotelPO.setAddress("测试地址");
		hotelPO.setScore(5);
		hotelPO.setStarLevel(5);
		
		evaluationPO = new HotelEvaluationPO();
		evaluationPO.setClientID("huangxiao");
		evaluationPO.setHotelID("00000001");
		evaluationPO.setOrderID("0000000000000001");
		evaluationPO.setEvaluateTime(Time.getCurrentTime());
		evaluationPO.setEvaluateScore(3);
		evaluationPO.setEvaluateInfo("测试评价");
	}
	
	@Override
	public HotelPO getHotelInfo(String hotelID) throws RemoteException {
		if(hotelID.length() != HOTEL_ID_LENTH)
			return null;
		hotelPO.setHotelID(hotelID);
		return hotelPO;
	}

	@Override
	public ArrayList<HotelPO> findHotelByCondition(SearchCondition sc) throws RemoteException {
		ArrayList<HotelPO> hotelList = new ArrayList<>();
		hotelPO.setRegion(sc.region);
		hotelPO.setBusinessDistrict(sc.businessDistrict);
		hotelList.add(hotelPO);
		return hotelList;
	}

	@Override
	public ResultMessage_Hotel changeHotelInfo(HotelPO po) throws RemoteException {
		if(po.getHotelID().length() != HOTEL_ID_LENTH)
			return ResultMessage_Hotel.Hotel_Not_Exists;
		return ResultMessage_Hotel.Change_Successful;
	}

	@Override
	public ResultMessage_Hotel evaluation(HotelEvaluationPO po) throws RemoteException {
		if(po.getHotelID().length() != HOTEL_ID_LENTH)
			return ResultMessage_Hotel.Hotel_Not_Exists;
		return ResultMessage_Hotel.Evaluate_Successful;
	}

	@Override
	public String addHotel(HotelPO po) throws RemoteException {
		return "10000000";
	}

	@Override
	public ArrayList<HotelEvaluationPO> getHotelEvaluation(String hotelID) throws RemoteException {
		ArrayList<HotelEvaluationPO> evaluations = new ArrayList<>();
		evaluationPO.setHotelID(hotelID);
		evaluations.add(evaluationPO);
		return evaluations;
	}

}
