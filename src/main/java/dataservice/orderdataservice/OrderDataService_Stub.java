/**
 * @author huangxiao
 */
package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.order.OrderPO;
import util.Time;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;

public class OrderDataService_Stub implements OrderDataService {

	private static final int ORDER_ID_LENGTH = 16;
	
	private OrderPO po;
	
	public OrderDataService_Stub() {
		po = new OrderPO();
		po.setOrderID("0000000000000001");
		po.setOrderState(OrderState.Unexecuted);
		po.setClientID("huangxiao");
		po.setHotelID("00000001");
		ArrayList<String> roomNumerList = new ArrayList<>();
		roomNumerList.add("3B323");
		po.setRoomNumberList(roomNumerList);
		po.setPromotionIDList(new ArrayList<>());
		po.setValue(1024);
		po.setMakeTime("2016/11/01 00:00:00");
		po.setExecuteTime("");
		po.setFinishTime("");
		po.setLatestETime("2016/11/02 23:59:59");
		po.setCheckInDate("2016/11/02");
		po.setEstimateCheckOutDate("2016/11/03");
		po.setActualCheckOutDate("");
		po.setNumOfPeople(4);
		po.setChildren(true);
		po.setEvaluate(false);
	}
	
	@Override
	public String addOrder(OrderPO po) throws RemoteException {
		return "1000000000000000";
	}

	@Override
	public ResultMessage_Order putUpOrder(String orderID) throws RemoteException {
		if(orderID.length() != ORDER_ID_LENGTH)
			return ResultMessage_Order.Order_Not_Exist;
		return ResultMessage_Order.Put_Up_Successful;
	}

	@Override
	public ResultMessage_Order appealOrder(String orderID) throws RemoteException {
		if(orderID.length() != ORDER_ID_LENGTH)
			return ResultMessage_Order.Order_Not_Exist;
		return ResultMessage_Order.Appeal_Successful;
	}

	@Override
	public ResultMessage_Order cancelOrder(String orderID) throws RemoteException {
		if(orderID.length() != ORDER_ID_LENGTH)
			return ResultMessage_Order.Order_Not_Exist;
		return ResultMessage_Order.Cancel_Successful;
	}

	@Override
	public ResultMessage_Order executeOrder(String orderID) throws RemoteException {
		if(orderID.length() != ORDER_ID_LENGTH)
			return ResultMessage_Order.Order_Not_Exist;
		return ResultMessage_Order.Execute_Successful;
	}

	@Override
	public ResultMessage_Order finishOrder(String orderID) throws RemoteException {
		if(orderID.length() != ORDER_ID_LENGTH)
			return ResultMessage_Order.Order_Not_Exist;
		return ResultMessage_Order.Finish_Successful;
	}

	@Override
	public OrderPO findById(String orderID) throws RemoteException {
		po.setOrderID(orderID);
		return po;
	}

	@Override
	public ArrayList<OrderPO> findByUser(String clientID) throws RemoteException {
		ArrayList<OrderPO> orderList = new ArrayList<>();
		po.setClientID(clientID);
		orderList.add(po);
		return orderList;
	}

	@Override
	public ArrayList<OrderPO> findUOByHotel(String hotelID, String clientID) throws RemoteException {
		ArrayList<OrderPO> orderList = new ArrayList<>();
		po.setHotelID(hotelID);
		po.setClientID(clientID);
		orderList.add(po);
		return orderList;
	}

	@Override
	public ArrayList<OrderPO> findHotelOrder(String hotelID) throws RemoteException {
		ArrayList<OrderPO> orderList = new ArrayList<>();
		po.setHotelID(hotelID);
		orderList.add(po);
		return orderList;
	}

	@Override
	public ArrayList<OrderPO> findUnexecutedOrder(String date) throws RemoteException {
		ArrayList<OrderPO> orderList = new ArrayList<>();
		po.setCheckInDate(Time.getCurrentDate());
		orderList.add(po);
		return orderList;
	}

	@Override
	public ArrayList<OrderPO> findAbnormalOrder() throws RemoteException {
		ArrayList<OrderPO> orderList = new ArrayList<>();
		po.setOrderState(OrderState.Exception);
		orderList.add(po);
		return orderList;
	}

	@Override
	public ResultMessage_Order orderEvaluate(String orderID) throws RemoteException {
		if(orderID.length() != ORDER_ID_LENGTH)
			return ResultMessage_Order.Order_Not_Exist;
		return ResultMessage_Order.Evaluate_Successful;
	}
	
}
