package promotionbl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.promotionbl.Promotion;
import util.ResultMessage;
import vo.OrderPromotionConditionVO;
import vo.PromotionVO;

public class PromotionBLTest {

	Promotion promotion;
	PromotionVO vo1;
	PromotionVO vo2;
	OrderPromotionConditionVO ordervo;
	@Before
	public void init(){
		vo1=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
		vo2=new PromotionVO("123456780", "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		ordervo=new OrderPromotionConditionVO();
	}
	@Test
	public void testHotelAdd() {
		assertEquals(ResultMessage.HotelAddSuccess, promotion.hotelAdd(vo1));
	}
	@Test
	public void testWebAdd() {
		assertEquals(ResultMessage.WebAddSuccess, promotion.webAdd(vo2));
	}
	@Test
	public void testHotelLook(){
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		assertEquals(promotion.hotelLook(vo1.id),list);
	}
	@Test
	public void testWebLook(){
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo2);
		assertEquals(promotion.webLook(),list);
	}
	public void testcancel(){
		assertEquals(ResultMessage.CancelSucceed, promotion.cancel(vo1.id));
	}
	public void testGetPromotion(){
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		assertEquals(promotion.getPromotion(ordervo), list);
	}
}
