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

public class OrderDataService_Driver {
	
	public void drive(OrderDataService orderDataService) throws RemoteException {
		
		ResultMessage_Order result;
		OrderPO po = new OrderPO();
		
		// 生成订单
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
		
		String orderID = orderDataService.addOrder(po);
		System.out.println("Generate ID: " + orderID);
		po.setOrderID(orderID);
		
		// 撤销订单
		result = orderDataService.cancelOrder(orderID);
		System.out.println(result.toString());
		
		// 申诉订单
		result = orderDataService.appealOrder(orderID);
		System.out.println(result.toString());
		
		// 补录订单
		po.setOrderID(orderID);
		po.setOrderState(OrderState.Exception);
		po.setFinishTime("2016/11/03 00:00:00");
		
		result = orderDataService.putUpOrder(orderID);
		System.out.println(result.toString());
		
		// 执行订单
		po.setOrderState(OrderState.Unexecuted);
		po.setActualCheckOutDate("");
		po.setFinishTime("");
		
		result = orderDataService.executeOrder(orderID);
		System.out.println(result);
		
		// 完成订单
		result = orderDataService.finishOrder(orderID);
		System.out.println(result);
		
		// 根据id查询订单
		po = orderDataService.findById("0000000000000001");
		System.out.println(po.getOrderState() + " " + po.getClientID() + " " + po.getHotelID());
		
		ArrayList<OrderPO> orderList = new ArrayList<>();
		
		// 查询用户订单
		orderList = orderDataService.findByUser("huangxiao");
		System.out.println("huangxiao has maked " + orderList.size() + " orders");
		
		// 查询用户在某酒店订单
		orderList = orderDataService.findUOByHotel("00000001", "huangxiao");
		System.out.println("huangxiao has maked " + orderList.size() + " orders in hotelID: 00000001");
		
		// 查询酒店订单
		orderList = orderDataService.findHotelOrder("00000001");
		System.out.println("HotelID:00000001 has " + orderList.size() +  " orders");
		
		orderList = orderDataService.findUnexecutedOrder(Time.getCurrentDate());
		System.out.println("There are " + orderList.size() + " orders on " + Time.getCurrentDate());
		
		orderList = orderDataService.findAbnormalOrder();
		System.out.println("There are " + orderList.size() + " abnormal orders so far");
		
	}

}
