/**
 * @author huangxiao
 * 2016年10月16日
 */
package dataservice.hoteldataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.hotel.HotelEvaluationPO;
import po.hotel.HotelPO;
import util.exception.NetException;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;

public interface HotelDataService extends Remote{

	public HotelPO getHotelInfo(String hotelID) throws NetException;
	
	public ArrayList<HotelPO> findHotelByCondition(SearchCondition sc) throws NetException;
	
	public ResultMessage_Hotel changeHotelInfo(HotelPO po) throws NetException;
		
	public ResultMessage_Hotel evaluation(HotelEvaluationPO po) throws NetException;
	
	public String addHotel(HotelPO po) throws NetException;
	
	public ArrayList<HotelEvaluationPO> getHotelEvaluation(String hotelID) throws NetException;
	
}
