package factory.datahelper;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import po.order.OrderPO;
import util.ResultMessage_For_Stub;

public class OrderDataHelper implements OrderDataService{
	
	private OrderDataService order_service;
	
	/**
	 * @param order_service
	 */
	public OrderDataHelper(OrderDataService order_service) {
		super();
		this.order_service = order_service;
	}

	@Override
	public ResultMessage_For_Stub putUpOrder(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage_For_Stub update(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO findById(String orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findByUser(String userId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findByRoom(String hotelId, String roomId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findUOByHotel(String hotelId, String userId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findHotelOrder(String hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderPO> findUnexcutedOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
