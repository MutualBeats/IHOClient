package bussinesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.Iterator;

import vo.promotion.PromotionVO;

public interface PromotionGet {
	
	public Iterator<PromotionVO> getUnderwayPromotion(String hotelID) throws RemoteException;
	
	public double getDiscount(int level) throws RemoteException;
	
}
