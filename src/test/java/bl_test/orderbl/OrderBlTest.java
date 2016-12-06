package bl_test.orderbl;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
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
		// ClientInfo client = ControllerFactory.getClientInfoInstance();
		try {
			order = new Order();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCancel() {
		ResultMessage_Order res;
		try {
			// 订单号不存在情形
			res = order.cancelOrder("abc");
			assertEquals(ResultMessage_Order.Order_Not_Exist, res);
			// 订单状态错误情形
			res = order.cancelOrder("1");
			assertEquals(ResultMessage_Order.Order_State_Error, res);
			// 正常情形（测试已完成，仅可测试一次）
			// res = order.cancelOrder("2");
			// assertEquals(ResultMessage_Order.Cancel_Successful, res);
			// OrderVO newVO = order.queryOrderById("2");
			// assertEquals(OrderState.Canceled, newVO.orderState);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMake() {
		// TODO
	}

	@Test
	public void testExecute() {
		ResultMessage_Order res;
		try {
			// 订单号不存在情形
			res = order.executeOrder("abc");
			assertEquals(ResultMessage_Order.Order_Not_Exist, res);
			// 订单状态错误情形
			res = order.executeOrder("1");
			assertEquals(ResultMessage_Order.Order_State_Error, res);
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
		// TODO
		ResultMessage_Order res;
		try {
			// 订单号不存在情形
			res = order.putUpOrder("abc");
			assertEquals(ResultMessage_Order.Order_Not_Exist, res);
			// 订单状态错误情形
			res = order.putUpOrder("1");
			assertEquals(ResultMessage_Order.Order_State_Error, res);
			// 时间错误情形
			res = order.putUpOrder("4");
			assertEquals(ResultMessage_Order.Date_Error, res);
			// TODO 房间已被预订情形
			
			// 正常情形（测试已完成，仅可测试一次）
//			res = order.putUpOrder("5");
//			OrderVO newVO = order.queryOrderById("5");
//			assertEquals(OrderState.Execute, newVO.orderState);
//			assertEquals("", newVO.finishTime);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQueryOrder() {
		try {
			vo = order.queryOrderById("1");
			assertEquals(OrderState.Execute, vo.orderState);
			assertEquals(1024, (int)vo.value);
			assertEquals(false, vo.children);
			
			ArrayList<OrderVO> orderList;
			
			orderList = order.queryHotelOrder("00000001");
			assertEquals(5, orderList.size());
			
			orderList = order.queryUserOrder("0000000001");
			assertEquals(3, orderList.size());
			
			orderList = order.queryOrderByHotel("00000002", "0000000001");
			assertEquals(0, orderList.size());
			
//			orderList = order.queryUnexecutedOrder("2016/12/04");
//			assertEquals(2, orderList.size());
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
