package bl_test.promotionbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.promotionbl.Promotion;
import util.promotion.PromotionType;
import vo.promotion.PromotionVO;

public class PromotionBLTest {
	
	private final int MAX_VIP_LEVEL = 3;

	private Promotion promotion;
	
	@Before
	public void init() {
		try {
			promotion = new Promotion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetHotelPromotion() {
		try {
			ArrayList<PromotionVO> hotelPromotionList = promotion.gethotelPromotion("00000001");
			PromotionVO vo = hotelPromotionList.get(hotelPromotionList.size() - 1);
			assertEquals("三间以上优惠", vo.promotionName);
			assertEquals(PromotionType.Room, vo.type);
			assertEquals("00000001", vo.hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetWebPromotionPromotion() {
		try {
			ArrayList<PromotionVO> webPromotionList = promotion.getWebPromotion();
			PromotionVO vo = webPromotionList.get(webPromotionList.size() - 1);
			assertEquals("商圈活动", vo.promotionName);
			assertEquals(PromotionType.BusinessDistrict, vo.type);
			assertEquals("", vo.hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetMemberLevelandDiscount() {
		try {
			ArrayList<Double> discount = promotion.getMemberDiscount();
			ArrayList<Integer> level = promotion.getMemberLevel();
			assertEquals(MAX_VIP_LEVEL + 1, discount.size());
			assertEquals(MAX_VIP_LEVEL, level.size());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
