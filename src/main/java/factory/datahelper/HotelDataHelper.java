package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import dataservice.hoteldataservice.HotelDataService;
import po.hotel.HotelEvaluationPO;
import po.hotel.HotelPO;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;

/**
 * @author Saltwater Hotel Data Helper A local cache. To hide the interface and
 *         make some deal.
 */
public class HotelDataHelper {

	private HotelDataService hotel_service;

	/**
	 * The Usage of Hotel_Info_Cache : Why : When load a list of hotel, it's
	 * easy for the user to click the item he get. Cache at client, Faster at
	 * access How it work : Update each time the client filt. Update when no
	 * such po is in cache.
	 */
	private Map<String, HotelPO> hotel_info_cache;

	public HotelDataHelper(HotelDataService hotel_service) {
		this.hotel_service = hotel_service;
		hotel_info_cache = new HashMap<>();
	}

	/**
	 * 获取酒店信息
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public HotelPO getHotelInfo(String hotelID) throws RemoteException {
		// Search the cache;
		HotelPO info = hotel_info_cache.get(hotelID);
		if (info == null) {
			info = hotel_service.getHotelInfo(hotelID);
			// Update Cache
			if (info != null) {
				hotel_info_cache.put(hotelID, info);
			} else {
				return null;
			}

		}
		return new HotelPO(info);
	}

	/**
	 * Search the hotels which satisfy the condition
	 * 
	 * 
	 * @param sc
	 *            : Search Condition , such as star, score, location
	 * @return
	 * @throws RemoteException
	 *             : Net Error
	 */
	public Iterator<HotelPO> findHotelByCondition(SearchCondition sc) throws RemoteException {
		ArrayList<HotelPO> hotels = hotel_service.findHotelByCondition(sc);
		// Update Cache :
		Iterator<HotelPO> iterator = hotels.iterator();
		while (iterator.hasNext()) {
			HotelPO po = iterator.next();
			hotel_info_cache.remove(po.getHotelID());
			hotel_info_cache.put(po.getHotelID(), po);
		}
		return hotels.iterator();
	}

	/**
	 * Change the hotel information
	 * 
	 * @param po
	 * @return
	 */
	public ResultMessage_Hotel changeHotelInfo(HotelPO po) {
		ResultMessage_Hotel change_result = ResultMessage_Hotel.Change_Successful;
		try {
			change_result = hotel_service.changeHotelInfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Hotel.Net_Error;
		}
		// Update Server First.
		// If Exception,
		// Jump out
		if (change_result.equals(ResultMessage_Hotel.Change_Successful)) {
			// Local Cache Update
			if (hotel_info_cache.containsKey(po.getHotelID())) {
				HotelPO old = hotel_info_cache.get(po.getHotelID());
				po.setScore(old.getScore());
				hotel_info_cache.remove(po.getHotelID());
				hotel_info_cache.put(po.getHotelID(), po);
			}
			return ResultMessage_Hotel.Change_Successful;
		} else {
			return ResultMessage_Hotel.Hotel_Not_Exists;
		}
	}

	/**
	 * 评价酒店
	 * 
	 * @param po
	 *            ：酒店评价信息
	 * @return : 评价结果
	 * @throws RemoteException
	 *             ： Net Error
	 */
	public ResultMessage_Hotel evaluate(HotelEvaluationPO po) {
		try {
			ResultMessage_Hotel result = hotel_service.evaluation(po);
			// Update the cache at local. for each evaluation, mark will change.
			// Cannot use get method local.
			HotelPO hotelInfo = hotel_service.getHotelInfo(po.getHotelID());
			hotel_info_cache.remove(po.getHotelID());
			hotel_info_cache.put(po.getHotelID(), hotelInfo);
			return result;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Hotel.Net_Error;
		}
	}

	/**
	 * 添加酒店
	 * 
	 * @param po
	 * @return
	 */
	public String addHotel(HotelPO po) throws RemoteException,NullPointerException {
		String id = hotel_service.addHotel(po);
		if (id != null) {
			po.setHotelID(id);
			hotel_info_cache.put(id, po);
			return id;
		} 
		throw new NullPointerException();
	}

	/**
	 * 获取酒店评价
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 *             : Net Error
	 */
	public Iterator<HotelEvaluationPO> getHotelEvaluation(String hotelID) throws RemoteException {
		return hotel_service.getHotelEvaluation(hotelID).iterator();
	}

}
