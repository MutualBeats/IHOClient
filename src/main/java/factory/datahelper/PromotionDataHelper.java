package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.promotiondataservice.PromotionDataService;
import po.promotion.PromotionPO;
import util.resultmessage.ResultMessage_Promotion;

public class PromotionDataHelper {

	private PromotionDataService promotion_service;
	/**
	 * A record for current hotel
	 */
	private String current_hotel;
	/**
	 * Cache for hotel promotion
	 */
	private ArrayList<PromotionPO> hotel_promotion_cache;
	/**
	 * Cache for web promotion
	 */
	private ArrayList<PromotionPO> web_promotion_cache;
	/**
	 * Cache for member level and discount
	 */
	private ArrayList<Integer> member_level_cache;
	private ArrayList<Double> member_discount_cache;
	
	/**
	 * @param promotion_service
	 * @throws RemoteException 
	 */
	public PromotionDataHelper(PromotionDataService promotion_service) throws RemoteException {
		super();
		this.promotion_service = promotion_service;
		this.current_hotel = "";
		this.hotel_promotion_cache = new ArrayList<>();
		this.hotel_promotion_cache.clear();
		this.web_promotion_cache = promotion_service.getWebPromotion();
		this.member_level_cache = promotion_service.getMemberLevel();
		this.member_discount_cache = promotion_service.getMemberDiscount();
	}

	public ResultMessage_Promotion addPromotion(PromotionPO po) {
		ResultMessage_Promotion result = ResultMessage_Promotion.Add_Successful;
		try {
			result = promotion_service.addPromotion(po);
			if(!result.equals(ResultMessage_Promotion.Add_Successful))
				return result;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Promotion.Net_Error;
		}
		// 更新cache
		if(po.getHotelID().equals("")) {
			web_promotion_cache.add(po);
		} else {
			if(current_hotel.equals(po.getHotelID()))
				hotel_promotion_cache.add(po);
		}
		
		return result;
	}

	public Iterator<PromotionPO> getHotelPromotion(String hotelID) throws RemoteException {
		if(!current_hotel.equals(hotelID)) {
			hotel_promotion_cache = promotion_service.getHotelPromotion(hotelID);
			current_hotel = hotelID;
		}
		return hotel_promotion_cache.iterator();
	}

	public Iterator<PromotionPO> getWebPromotion() throws RemoteException {
		return web_promotion_cache.iterator();
	}

	public ResultMessage_Promotion deletePromotion(String promotionID) {
		ResultMessage_Promotion result = ResultMessage_Promotion.Delete_Successful;
		try {
			result = promotion_service.deletePromotion(promotionID);
			if (!result.equals(ResultMessage_Promotion.Delete_Successful))
				return result;
			// 更新cache
			current_hotel = "";
			hotel_promotion_cache.clear();
			web_promotion_cache = promotion_service.getWebPromotion();
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Promotion.Net_Error;
		}
		return result;
	}
	
	public ArrayList<Integer> getMemberLevel() throws RemoteException {
		return member_level_cache;
	}

	public ArrayList<Double> getMemberDiscount() throws RemoteException {
		return member_discount_cache;
	}

	public ResultMessage_Promotion levelMake(ArrayList<Integer> level, ArrayList<Double> discount) {
		ResultMessage_Promotion result = ResultMessage_Promotion.Level_Make_Successful;
		try {
			result = promotion_service.levelMake(level, discount);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_Promotion.Net_Error;
		}
		if(!result.equals(ResultMessage_Promotion.Level_Make_Successful))
			return result;
		
		member_level_cache = level;
		member_discount_cache = discount;
		
		return result;
	}

}
