package bussinesslogicservice.orderblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

public interface OrderBLService {
	
	/**
	 * 添加订单
	 * 
	 * @param vo
	 * @return OrderVO
	 */
	public OrderVO makeOrder(OrderMakeVO vo) throws NetException;
	/**
	 * 撤销订单
	 * 
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order cancelOrder(String orderID);
	/**
	 * 执行订单
	 * 
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order executeOrder(String orderID);
	/**
	 * 完成订单
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order finishOrder(String orderID);
	/**
	 * 补录订单
	 * 
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order putUpOrder(String orderID);
	/**
	 * 根据ID查找订单
	 * 
	 * @param orderID
	 * @return OrderVO
	 */
	public OrderVO queryOrderById(String orderID) throws NetException;
	/**
	 * 查找用户在酒店订单
	 * 
	 * @param hotelID
	 * @param clientID
	 * @return ArrayList
	 */
	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) throws NetException;
	/**
	 * 查询房间订单
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return ArrayList
	 */
	public ArrayList<OrderVO> queryRoomOrder(String hotelID, String roomNumber) throws NetException;
	/**
	 * 查询用户订单
	 * 
	 * @param clientID
	 * @return ArrayList
	 */
	public ArrayList<OrderVO> queryUserOrder(String clientID) throws NetException;
	/**
	 * 酒店管理人员查询酒店订单
	 * 
	 * @param hotelID
	 * @return ArrayList
	 */
	public ArrayList<OrderVO> queryHotelOrder(String hotelID) throws NetException;
	/**
	 * 网站营销人员查看某天未执行订单
	 * @param date
	 * @return ArrayList
	 */
	public ArrayList<OrderVO> queryUnexecutedOrder(String date) throws NetException;
	
}

