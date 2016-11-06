package orderbl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.creditbl.MockCredit;
import bussinesslogic.orderbl.Order;
import bussinesslogic.promotionbl.MockPromotion;
import bussinesslogic.roombl.MockRoom;
import bussinesslogic.usebl.MockClient;
import util.MemberType;
import util.OrderState;
import util.RoomType;
import vo.OrderMakeVO;
import vo.OrderVO;

public class OrderBlTest {
	
	OrderVO vo;
	Order order;
	
	@Before
	public void init() {
		vo = new OrderVO("1234567890123456", "1234567890", "WoDeMa", "12345678901", MemberType.Ordinary, OrderState.UnExcuted, "12345678", "和园宾馆", "3B346", RoomType.Single, 1,10000 ,1000, "2016/10/14", "2016/10/15", "2016/10/16", "2016/10/14", "2016/10/16", "2016/10/15","2015/10/15",1,false);
		MockClient client = new MockClient();
		MockCredit credit = new MockCredit();
		MockPromotion promotion = new MockPromotion();
		MockRoom room = new MockRoom();
		order = new Order(client,credit, promotion, room);
	}
	
	@Test
	public void testCancel() {
//		vo = new OrderVO("1234567890123456", "1234567890", "WoDeMa", "12345678901", MemberType.Ordinary, OrderState.UnExcuted, "12345678", "和园宾馆", "3B346", RoomType.Single, 1,10000 ,1000, "2016/10/14", "2016/10/15", "2016/10/16", "2016/10/14", "2016/10/16", "2016/10/15","2015/10/15",1,false);
		String orderId = vo.orderId;
		order.cancelOrder(orderId);
		OrderVO vo = order.queryOrderById(orderId);
		assertEquals(OrderState.Canceled, vo.orderState);
	}
	
	@Test
	public void testMake() {
		OrderMakeVO makeVO = new OrderMakeVO("1234567891","12345678", "和园宾馆", "3B347", RoomType.Double, 10000,"2016/10/14", "2016/10/14","2015/10/15",1,4,false);
		vo = order.makeOrder(makeVO);
		assertEquals(makeVO.makeTime, vo.makeTime);
	}
	
	@Test
	public void testExcute() {
		
	}
}
