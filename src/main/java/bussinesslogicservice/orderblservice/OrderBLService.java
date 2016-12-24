package bussinesslogicservice.orderblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.exception.TimeConflictException;
import util.order.OrderState;
import util.resultmessage.ResultMessage_Order;
import vo.order.OrderMakeVO;
import vo.order.OrderVO;

public interface OrderBLService {
	
	/**
	 * 获取未生成订单具体信息
	 * 
	 * @param vo
	 * @return OrderVO
	 * @throws NetException
	 * @throws TimeConflictException
	 */
	public OrderVO getOrderVOBeforeMake(OrderMakeVO vo) throws NetException, TimeConflictException;
	/**
	 * 生成订单
	 * 
	 * @param vo
	 * @return orderID
	 * @throws NetException
	 */
	public String makeOrder(OrderVO vo) throws NetException;
	/**
	 * 撤销订单
	 * 
	 * @param orderID
	 * @return ResultMessage
	 */
	public ResultMessage_Order cancelOrder(String orderID);
	/**
	 * 订单申诉
	 * 
	 * @param orderID
	 * @param all
	 * @return ResultMessage
	 */
	public ResultMessage_Order appeal(String orderID, boolean all); 
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
	 * @throws NetException
	 */
	public OrderVO queryOrderById(String orderID) throws NetException;
	/**
	 * 查找用户在酒店订单
	 * 
	 * @param hotelID
	 * @param clientID
	 * @return ArrayList<OrderVO>
	 * @throws NetException
	 */
	public ArrayList<OrderVO> queryOrderByHotel(String hotelID, String clientID) throws NetException;
	/**
	 * 查询用户订单
	 * 
	 * @param clientID
	 * @return ArrayList<OrderVO>
	 * @throws NetException
	 */
	public ArrayList<OrderVO> queryUserOrder(String clientID, OrderState state) throws NetException;
	/**
	 * 酒店管理人员查询酒店订单
	 * 
	 * @param hotelID
	 * @return ArrayList<OrderVO>
	 * @throws NetException
	 */
	public ArrayList<OrderVO> queryHotelOrder(String hotelID, OrderState state) throws NetException;
	/**
	 * 网站营销人员查看某天未执行订单
	 * @param date
	 * @return ArrayList<OrderVO>
	 * @throws NetException
	 */
	public ArrayList<OrderVO> queryUnexecutedOrder(String date) throws NetException;
	/**
	 * 获取所有异常订单
	 * @return ArrayList<OrderVO>
	 * @throws NetException
	 */
	public ArrayList<OrderVO> queryAbnormalOrder() throws NetException;
	
}

