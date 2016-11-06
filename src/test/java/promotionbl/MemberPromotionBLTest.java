package promotionbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.promotionbl.MemberPromotion;
import vo.MemberVO;
import vo.PromotionVO;

public class MemberPromotionBLTest {
	
	MemberPromotion memberPromotion;
	MemberVO vo1;
	PromotionVO vo2;
	ArrayList<Integer> list;
	@Before
	public void init(){
		vo1=new MemberVO("123456789","腾讯企业",2);
		vo2=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
		list=new ArrayList<Integer>();
		list.add(vo1.level);
	}
	@Test
	public void testLevelMake() {
		assertEquals(memberPromotion.levelMake(vo1), list);
	}
	@Test
	public void testGetLevel(){
		assertEquals(memberPromotion.getLevel(vo1.memberID), vo1.level);
	}
	public void testGetDiscount(){
		assertEquals(memberPromotion.getDiscount(vo1.memberID), vo2.discount);
	}
}
