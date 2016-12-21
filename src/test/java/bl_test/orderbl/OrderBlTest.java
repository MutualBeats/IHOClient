package bl_test.orderbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.orderbl.Order;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderVO;

public class OrderBlTest {

	OrderVO vo;
	Order order;

	@Before
	public void init() {
		order = new Order();
	}
	
	@Test
	public void testMake() {
		// 仅可测试一次，测试已完成
//		ArrayList<String> roomList = new ArrayList<String>();
//		roomList.add("3B320");
//		roomList.add("3B321");
//		roomList.add("3B322");
//		OrderMakeVO makeVO = 
//				new OrderMakeVO("0000000001", "00000001", roomList, "2016/12/08", "2016/12/09", 6, true);
//		
//		try {
//			OrderVO orderVO = order.makeOrder(makeVO);
//			assertNotNull(orderVO);
//			assertEquals(OrderState.Unexecuted, orderVO.orderState);
//			assertNotNull(orderVO.orderID);
//			assertEquals(2, orderVO.promotionIDList.size());
//			assertEquals("000010", orderVO.promotionIDList.get(0));
//			assertEquals("000008", orderVO.promotionIDList.get(1));
//			assertEquals(718, (int)orderVO.value);
//			
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
	}

	@Test
	public void testCancel() {
		ResultMessage_Order res;
		try {
			// 订单号不存在情形
			res = order.cancelOrder("invalid");
			assertEquals(ResultMessage_Order.Order_Not_Exist, res);
			// 订单状态错误情形
//			res = order.cancelOrder("");
//			assertEquals(ResultMessage_Order.Order_State_Error, res);
			// 正常情形（不扣除信用，仅可测试一次）测试通过
//			res = order.cancelOrder("0000000000000001");
//			vo = order.queryOrderById("0000000000000001");
//			// 正常情形（扣除信用，仅可测试一次）测试通过
//			res = order.cancelOrder("0000000000000002");
//			vo = order.queryOrderById("0000000000000002");
//			assertEquals(ResultMessage_Order.Cancel_Successful, res);
//			assertEquals(OrderState.Canceled, vo.orderState);
//			assertNotSame("", vo.finishTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testExecute() {
		ResultMessage_Order res;
		try {
			// 订单号不存在情形
			res = order.executeOrder("invalid");
			assertEquals(ResultMessage_Order.Order_Not_Exist, res);
			// 订单状态错误情形
//			res = order.executeOrder("1");
//			assertEquals(ResultMessage_Order.Order_State_Error, res);
			// 正常情形（测试已完成，仅可测试一次）
//			res = order.executeOrder("3");
//			assertEquals(ResultMessage_Order.Execute_Successful, res);
//			OrderVO newVO = order.queryOrderById("3");
//			assertEquals(OrderState.Execute, newVO.orderState);
//			assertNotSame("", newVO.executeTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPutUp() {
		ResultMessage_Order res;
		try {
			// 订单号不存在情形
			res = order.putUpOrder("invalid");
			assertEquals(ResultMessage_Order.Order_Not_Exist, res);
//			// 订单状态错误情形
//			res = order.putUpOrder("1");
//			assertEquals(ResultMessage_Order.Order_State_Error, res);
//			// 时间错误情形
//			res = order.putUpOrder("4");
//			assertEquals(ResultMessage_Order.Date_Error, res);
			// 房间已被预订情形
			
			// 正常情形（测试已完成，仅可测试一次）
//			res = order.putUpOrder("5");
//			OrderVO newVO = order.queryOrderById("5");
//			assertEquals(OrderState.Execute, newVO.orderState);
//			assertEquals("", newVO.finishTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	@Test
//	public void testFinish() {
//		
//	}
	
	@Test
	public void testQueryOrder() {
		try {
			// 订单号不存在情形
			OrderVO orderVO = order.queryOrderById("invalid");
			assertNull(orderVO);
			// 客户订单
			ArrayList<OrderVO> orderList = order.queryUserOrder("0000000001", OrderState.All);
			assertNotNull(orderList);
			if(orderList.size() == 0)
				fail();
			
		} catch (Exception e) {
			
		}
	}

}
