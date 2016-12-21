package bl_test.promotionbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.promotionbl.Promotion;
import util.exception.NetException;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.DistrictPromotionVO;
import vo.promotion.PromotionVO;

public class PromotionBLTest {
	
	private static final int MAX_VIP_LEVEL = 3;

	private Promotion promotion;
	
	@Before
	public void init() {
		promotion = new Promotion();
	}
	
	@Test
	public void testGetHotelPromotion() {
		try {
			ArrayList<PromotionVO> hotelPromotionList = promotion.getHotelPromotion("00000001");
			PromotionVO vo = hotelPromotionList.get(hotelPromotionList.size() - 1);
			assertEquals("000008", vo.promotionID);
			assertEquals("生日住宿特惠", vo.promotionName);
			assertEquals(PromotionType.Birthday, vo.type);
			assertEquals("00000001", vo.hotelID);
		} catch (NetException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetWebPromotion() {
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
	public void testGetPromotionById() {
		try {
			// 促销策略不存在情形
			PromotionVO vo;
			// 促销策略存在情形
			vo = promotion.getPromotionById("000008");
			assertEquals("生日住宿特惠", vo.promotionName);
			assertEquals(PromotionType.Birthday, vo.type);
			assertEquals("00000001", vo.hotelID);
			
			vo = promotion.getPromotionById("000005");
			DistrictPromotionVO districtVO = (DistrictPromotionVO)vo;
			assertEquals("如城商圈", districtVO.districtList.get(0));
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
		// 仅可测试一次，测试已完成
//		ArrayList<Double> discount = new ArrayList<>();
//		discount.add(10.0);
//		discount.add(9.0);
//		discount.add(8.0);
//		discount.add(7.0);
//		ArrayList<String> enterpriseList = new ArrayList<>();
//		enterpriseList.add("腾讯企业");
//		enterpriseList.add("南京大学软件学院");
//		PromotionVO vo = new EnterprisePromotionVO(null, "测试1", PromotionType.Enterprise, 
//				discount, "00000002", "2016/12/18", "2017/01/01", enterpriseList);
//		try {
//			String id = promotion.addhotelPromotion(vo);
//			System.out.println(id);
//		} catch (NetException e) {
//			e.printStackTrace();
//		}
	}
	
	@Test
	public void testDeletePromotion() {
		ResultMessage_Promotion result;
		result = promotion.cancel("invalid");
		assertEquals(ResultMessage_Promotion.Promotion_Not_Exist, result);
		// 仅可测试一次
//		result = promotion.cancel("000007");
//		assertEquals(ResultMessage_Promotion.Delete_Successful, result);
	}

}
