package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.order.OrderPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Order;

public interface OrderDataService extends Remote{
	 
	/**
	 * 添加订单
	 * 
	 * @param po
	 * @return order_id
	 * @throws RemoteException
	 */
	public String addOrder(OrderPO po) throws NetException;
	/**
	 * 补录订单
	 * 
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Order putUpOrder(String orderID) throws NetException;
	/**
	 * 撤销订单
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Order cancelOrder(String orderID) throws NetException;
	/**
	 * 执行订单
	 * 
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Order executeOrder(String orderID) throws NetException;
	/**
	 * 完成订单
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Order finishOrder(String orderID) throws NetException;
	/**
	 * 根据orderId查询订单
	 * 
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public OrderPO findById(String orderID) throws NetException;
	/**
	 * 查询用户订单 
	 *  
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findByUser(String clientID) throws NetException;
	/**
	 * 查询房间订单
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findByRoom(String hotelID, String roomNumber) throws NetException;
	/**
	 * 用户查询在某酒店订单
	 * 
	 * @param hotelID
	 * @param clientID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findUOByHotel(String hotelID, String clientID) throws NetException;
	/**
	 * 查询酒店订单
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findHotelOrder(String hotelID) throws NetException;
	/**
	 * 查找网站未执行订单
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findUnexecutedOrder(String date) throws NetException;
	
	
}
