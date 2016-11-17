package orderbl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.creditbl.MockCredit;
import bussinesslogic.orderbl.Order;
import bussinesslogic.promotionbl.MockPromotion;
import bussinesslogic.roombl.MockRoom;
import bussinesslogic.usebl.client.MockClient;
import util.MemberType;
import util.OrderState;
import util.ResultMessage;
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
		assertEquals(ResultMessage.ExcuteSucceed, order.excuteOrder(vo.orderId));
		vo = order.queryOrderById(vo.orderId);
		assertEquals(OrderState.Excute, vo.orderState);
	}
	
	@Test
	public void testPutUp() {
		vo = new OrderVO("1234567890123458", "1234567891", "WoDeTian", "98765432125", MemberType.Enterprise, OrderState.Exception, "12345678", "和园宾馆", "3B347",RoomType.Double, 1,10000 ,-1000, "2016/10/17", "", "", "2016/10/17", "2016/10/19", "2016/10/17","2015/10/18",1,false);
		order.putUpOrder(vo.orderId);
		vo = order.queryOrderById(vo.orderId);
		assertEquals(OrderState.Excute, vo.orderState);
	}
	
	@Test
	public void testQueryOrder() {
		OrderVO vo2 = order.queryOrderById(vo.orderId);
		assertEquals(vo.userName, vo2.userName);
		assertEquals(vo.makeTime, vo2.makeTime);
		ArrayList<OrderVO> list;
		list = order.queryHotelOrder(vo.hotelId);
		find(list.iterator(), vo.orderId);
		list = order.queryUserOrder(vo.userId);
		find(list.iterator(), vo.orderId);
		list = order.queryOrderByHotel(vo.hotelId, vo.userId);
		find(list.iterator(), vo.orderId);
		list = order.queryRoomOrder(vo.hotelId, "3B346");
		find(list.iterator(), vo.orderId);
	}
	
	private void find(Iterator<OrderVO> it, String orderId) {
		boolean contain = false;
		for(; it.hasNext(); ){
			OrderVO each = it.next();
			if(each.orderId.equals(orderId)) {
				contain = true;
			}
		}
		if(! contain) {
			fail();
		}
	}
	
}
