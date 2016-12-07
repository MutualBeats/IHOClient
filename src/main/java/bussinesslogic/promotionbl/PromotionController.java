package bussinesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import bussinesslogic.orderbl.PromotionGet;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class PromotionController implements PromotionBLService, PromotionGet{
	
	private Promotion promotion;

	public PromotionController() throws Exception {
		promotion = new Promotion();
	}

	@Override
	public String addhotelPromotion(PromotionVO vo) throws RemoteException {
		return promotion.addhotelPromotion(vo);
	}

	@Override
	public String addWebPromotion(PromotionVO vo) throws RemoteException {
		return promotion.addWebPromotion(vo);
	}

	@Override
	public ArrayList<PromotionVO> gethotelPromotion(String hotelID) throws RemoteException {
		return promotion.gethotelPromotion(hotelID);
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotion() throws RemoteException {
		return promotion.getWebPromotion();
	}

	@Override
	public ResultMessage_Promotion cancel(String promotionID) {
		return promotion.cancel(promotionID);
	}

	@Override
	public ArrayList<Integer> getMemberLevel() throws RemoteException {
		return promotion.getMemberLevel();
	}

	@Override
	public ArrayList<Double> getMemberDiscount() throws RemoteException {
		return promotion.getMemberDiscount();
	}

	@Override
	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount) {
		return promotion.makeLevel(level, discount);
	}

	@Override
	public Iterator<PromotionVO> getUnderwayPromotion(String hotelID) throws RemoteException {
		return promotion.getUnderwayPromotion(hotelID);
	}

	@Override
	public double getDiscount(int level) throws RemoteException {
		return promotion.getMemberDiscount().get(level);
	}
	
}
