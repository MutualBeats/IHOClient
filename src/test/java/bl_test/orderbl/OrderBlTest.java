package bl_test.orderbl;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.controllerfactory.ControllerFactory;
import bussinesslogic.orderbl.ClientInfo;
import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogic.orderbl.Order;
import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogic.promotionbl.MockPromotion;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import util.user.MemberType;
import vo.order.OrderVO;
import vo.user.ClientVO;

public class OrderBlTest {

	OrderVO vo;
	Order order;

	@Before
	public void init() {
		// ClientInfo client = ControllerFactory.getClientInfoInstance();
		try {
			/************** 测试专用 ***************/
			ClientInfo client = new ClientInfo() {
				@Override
				public ClientVO getClientInfo(String clientID) {
					ClientVO vo = new ClientVO("0000000002", "刘钦", "", 0, MemberType.Enterprise, 2, "");
					return vo;
				}
			};

			CreditUpdate credit = ControllerFactory.getCreditUpdateInstance();
			MockPromotion promotion = new MockPromotion();
			RoomUpdate room = ControllerFactory.getRoomUpdateInstance();
			order = new Order(client, credit, promotion, room);
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
	public void testExcute() {
		// TODO
	}

	@Test
	public void testPutUp() {
		// TODO
	}

	@Test
	public void testQueryOrder() {
		// TODO
	}

	private void find(Iterator<OrderVO> it, String orderId) {
		boolean contain = false;
		for (; it.hasNext();) {
			OrderVO each = it.next();
			if (each.orderID.equals(orderId)) {
				contain = true;
			}
		}
		if (!contain) {
			fail();
		}
	}

}
