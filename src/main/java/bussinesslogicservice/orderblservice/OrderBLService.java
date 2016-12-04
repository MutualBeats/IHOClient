package bussinesslogicservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.resultmessage.ResultMessage_Order;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

public interface OrderBLService {
	
	/**
	 * 添加订单
	 * 
	 * @param vo
	 * @return
	 */
	public OrderVO makeOrder(OrderMakeVO vo) throws RemoteException;
	/**
	 * 更新订单
	 * 
	 * @param orderId
	 * @return
	 */
	public ResultMessage_Order cancelOrder(String orderId);
	/**
	 * 执行订单
	 * 
	 * @param orderId
	 * @return
	 */
	public ResultMessage_Order excuteOrder(String orderId);
	/**
	 * 补录订单
	 * 
	 * @param orderId
	 * @return
	 */
	public ResultMessage_Order putUpOrder(String orderId);
	/**
	 * 根据ID查找订单
	 * 
	 * @param orderId
	 * @return
	 */
	public OrderVO queryOrderById(String orderId) throws RemoteException;
	/**
	 * 查找用户在酒店订单
	 * 
	 * @param hotelId
	 * @param userId
	 * @return
	 */
	public ArrayList<OrderVO> queryOrderByHotel(String hotelId, String userId) throws RemoteException;
	/**
	 * 查询房间订单
	 * 
	 * @param hotelId
	 * @param roomId
	 * @return
	 */
	public ArrayList<OrderVO> queryRoomOrder(String hotelId, String roomId) throws RemoteException;
	/**
	 * 查询用户订单
	 * 
	 * @param userId
	 * @return
	 */
	public ArrayList<OrderVO> queryUserOrder(String userId) throws RemoteException;
	/**
	 * 酒店管理人员查询酒店订单
	 * 
	 * @param hotelId
	 * @return
	 */
	public ArrayList<OrderVO> queryHotelOrder(String hotelId) throws RemoteException;
	
}

