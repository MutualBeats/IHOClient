package bl_test.promotionbl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.promotionbl.Promotion;
import util.exception.NetException;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.EnterprisePromotionVO;
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
			ArrayList<PromotionVO> hotelPromotionList = promotion.getHotelPromotion("00000001");
			PromotionVO vo = hotelPromotionList.get(hotelPromotionList.size() - 1);
			assertEquals("三间以上优惠", vo.promotionName);
			assertEquals(PromotionType.Room, vo.type);
			assertEquals("00000001", vo.hotelID);
		} catch (NetException e) {
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
		} catch (NetException e) {
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
		} catch (NetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testMakeLevel() {
		ArrayList<Integer> level = new ArrayList<>();
		level.add(256);
		level.add(512);
		level.add(1024);
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(10.0);
		discount.add(9.5);
		discount.add(9.0);
		discount.add(8.5);
		ResultMessage_Promotion result = promotion.makeLevel(level, discount);
		assertEquals(ResultMessage_Promotion.Level_Make_Successful, result);
	}
	
	@Test
	public void testAddPromotion() {
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(10.0);
		discount.add(9.0);
		discount.add(8.0);
		discount.add(7.0);
		ArrayList<String> enterpriseList = new ArrayList<>();
		enterpriseList.add("腾讯企业");
		enterpriseList.add("南京大学软件学院");
		PromotionVO vo = new EnterprisePromotionVO(null, "测试1", PromotionType.Enterprise, 
				discount, "00000002", "2016/12/18", "2017/01/01", enterpriseList);
		try {
			String id = promotion.addhotelPromotion(vo);
			System.out.println(id);
		} catch (NetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDeletePromotion() {
		ResultMessage_Promotion result;
		result = promotion.cancel("100000");
		assertEquals(ResultMessage_Promotion.Promotion_Not_Exist, result);
//		result = promotion.cancel("000007");
//		assertEquals(ResultMessage_Promotion.Delete_Successful, result);
	}

}
