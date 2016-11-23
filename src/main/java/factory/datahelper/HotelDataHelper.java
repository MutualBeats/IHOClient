package factory.datahelper;

import java.util.ArrayList;

import dataservice.hoteldataservice.HotelDataService;
import po.HotelEvaluationPO;
import po.HotelPO;
import util.ResultMessage_For_Stub;
import util.SearchCondition;
/**
 * @author Saltwater
 * Hotel Data Helper
 * A local cache.
 * To hide the interface and make some deal.
 */
public class HotelDataHelper {
	
	private HotelDataService hotel_service;
	
	/**
	 * The Usage of Hotel_Info_Cache : 
	 * 		Why : When load a list of hotel, it's easy for the user to click the item he get. Cache at client, Faster at access
	 * 		How it work : Update each time the client filt. Update when no such po is in cache.
	 */
	private ArrayList<HotelPO> hotel_info_cache;
	
	public HotelDataHelper(HotelDataService hotel_service) {
		this.hotel_service = hotel_service;
		hotel_info_cache = new ArrayList<>();
	}
	
	
	
	public HotelPO getHotelInfo(String hotelID) {
		
		return null;
	}

	public ArrayList<HotelPO> find(SearchCondition sc) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateHotelData(HotelPO po)  {
		// TODO Auto-generated method stub
		
	}

	public ResultMessage_For_Stub insertHotelEvaluation(HotelEvaluationPO po) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insertHotel(HotelPO po)  {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<HotelEvaluationPO> findHotelEvaluation(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

}
