package bussinesslogicservice.orderblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.OrderVO;

public interface OrderBLService {
	
	/**
	 * 添加订单
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage makeOrder(OrderVO vo);
	/**
	 * 更新订单
	 * 
	 * @param orderId
	 * @return
	 */
	public ResultMessage cancelOrder(String orderId);
	/**
	 * 执行订单
	 * 
	 * @param orderId
	 * @return
	 */
	public ResultMessage excuteOrder(String orderId);
	/**
	 * 补录订单
	 * 
	 * @param orderId
	 * @return
	 */
	public ResultMessage putUpOrder(String orderId);
	/**
	 * 根据ID查找订单
	 * 
	 * @param orderId
	 * @return
	 */
	public OrderVO queryOrderById(String orderId);
	/**
	 * 查找用户在酒店订单
	 * 
	 * @param hotelId
	 * @param userId
	 * @return
	 */
	public ArrayList<OrderVO> queryOrderByHotel(String hotelId, String userId);
	/**
	 * 查询房间订单
	 * 
	 * @param hotelId
	 * @param roomId
	 * @return
	 */
	public ArrayList<OrderVO> queryRoomOrder(String hotelId, String roomId);
	/**
	 * 查询用户订单
	 * 
	 * @param userId
	 * @return
	 */
	public ArrayList<OrderVO> queryUserOrder(String userId);
	/**
	 * 酒店管理人员查询酒店订单
	 * 
	 * @param hotelId
	 * @return
	 */
	public ArrayList<OrderVO> queryHotelOrder(String hotelId);
	
}

