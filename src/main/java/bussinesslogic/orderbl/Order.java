package bussinesslogic.orderbl;

import java.util.ArrayList;

import bussinesslogicservice.orderblservice.OrderBLService;
import util.ResultMessage;
import vo.OrderMakeVO;
import vo.OrderVO;

public class Order implements OrderBLService{
	
	private UserInfo userInfo;
	private CreditUpdate credit;
	private PromotionGet promotion;
	private RoomUpdate room;

	/**
	 * @param userInfo
	 * @param credit
	 * @param promotion
	 * @param room
	 */
	public Order(UserInfo userInfo, CreditUpdate credit, PromotionGet promotion, RoomUpdate room) {
		super();
		this.userInfo = userInfo;
		this.credit = credit;
		this.promotion = promotion;
		this.room = room;
	}

	@Override
	public ResultMessage cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage excuteOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage putUpOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO queryOrderById(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryOrderByHotel(String hotelId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryRoomOrder(String hotelId, String roomId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryUserOrder(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> queryHotelOrder(String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO makeOrder(OrderMakeVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}