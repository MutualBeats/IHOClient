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
	 * @param orderID
	 * @return
	 */
	public ResultMessage_Order cancelOrder(String orderID);
	/**
	 * 执行订单
	 * 
	 * @param orderID
	 * @return
	 */
	public ResultMessage_Order executeOrder(String orderID);
	/**
	 * 完成订单
	 * @param orderID
	 * @return
	 */
	public ResultMessage_Order finishOrder(String orderID);
	/**
	 * 补录订单
	 * 
	 * @param orderID
	 * @return
	 */
	public ResultMessage_Order putUpOrder(String orderID);
	/**
	 * 根据ID查找订单
	 * 
	 * @param orderID
	 * @return
	 */
	public OrderVO queryOrderById(String orderID) throws RemoteException;
	/**
	 * 查找用户在酒店订单
	 * 
	 * @param hotelID
	 * @param clientID
	 * @return
	 */
	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) throws RemoteException;
	/**
	 * 查询房间订单
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 */
	public ArrayList<OrderVO> queryRoomOrder(String hotelID, String roomNumber) throws RemoteException;
	/**
	 * 查询用户订单
	 * 
	 * @param clientID
	 * @return
	 */
	public ArrayList<OrderVO> queryUserOrder(String clientID) throws RemoteException;
	/**
	 * 酒店管理人员查询酒店订单
	 * 
	 * @param hotelID
	 * @return
	 */
	public ArrayList<OrderVO> queryHotelOrder(String hotelID) throws RemoteException;
	/**
	 * 网站营销人员查看某一天未执行订单
	 * @param date
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> queryUnexecutedOrder(String date) throws RemoteException;
	
}

