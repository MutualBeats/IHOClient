package vo.order;

import java.util.ArrayList;

import po.order.OrderPO;
import util.Time;
import util.order.OrderState;

public class OrderVO {
	/**
	 * 订单id
	 */
	public String orderID;
	/**
	 * 订单状态
	 */
	public OrderState orderState;
	/**
	 * 用户id
	 */
	public String clientID;
	/**
	 * 酒店id
	 */
	public String hotelID;
	/**
	 * 订单预订房间号列表
	 */
	public ArrayList<String> roomNumberList;
	/**
	 * 使用促销策略列表
	 */
	public ArrayList<String> promotionIDList;
	/**
	 * 订单价格
	 */
	public double value;
	/**
	 * 下单时间
	 */
	public String makeTime;
	/**
	 * 订单执行时间
	 */
	public String executeTime;
	/**
	 * 结束时间（执行完成/撤销）
	 */
	public String finishTime;
	/**
	 * 最晚订单执行时间
	 */
	public String latestETime;
	/**
	 * 预订入住日期
	 */
	public String checkInDate;
	/**
	 * 预订离开时间
	 */
	public String estimateCheckOutDate;
	/**
	 * 实际离开日期
	 */
	public String actualCheckOutDate;
	/**
	 * 预计入住人数
	 */
	public int numOfPeople;
	/**
	 * 有无儿童
	 */
	public boolean children;

	/**
	 * @param orderID
	 * @param orderState
	 * @param clientID
	 * @param hotelID
	 * @param roomNumberList
	 * @param promotionIDList
	 * @param value
	 * @param makeTime
	 * @param executeTime
	 * @param finishTime
	 * @param latestETime
	 * @param checkInDate
	 * @param estimateCheckOutDate
	 * @param actualCheckOutDate
	 * @param numOfPeople
	 * @param children
	 */
	public OrderVO(String orderID, OrderState orderState, String clientID, String hotelID,
			ArrayList<String> roomNumberList, ArrayList<String> promotionIDList, double value, String makeTime,
			String executeTime, String finishTime, String latestETime, String checkInDate, String estimateCheckOutDate,
			String actualCheckOutDate, int numOfPeople, boolean children) {
		super();
		this.orderID = orderID;
		this.orderState = orderState;
		this.clientID = clientID;
		this.hotelID = hotelID;
		this.roomNumberList = roomNumberList;
		this.promotionIDList = promotionIDList;
		this.value = value;
		this.makeTime = makeTime;
		this.executeTime = executeTime;
		this.finishTime = finishTime;
		this.latestETime = latestETime;
		this.checkInDate = checkInDate;
		this.estimateCheckOutDate = estimateCheckOutDate;
		this.actualCheckOutDate = actualCheckOutDate;
		this.numOfPeople = numOfPeople;
		this.children = children;
	}

	public OrderVO(OrderMakeVO vo) {
		this.orderState = OrderState.Unexecuted;
		this.clientID = vo.clientID;
		this.hotelID = vo.hotelID;
		this.roomNumberList = vo.roomNumberList;
		this.makeTime = Time.getCurrentTime();
		this.executeTime = "";
		this.finishTime = "";
		this.latestETime = vo.checkInDate + " " + "23:59:59";
		this.checkInDate = vo.checkInDate;
		this.estimateCheckOutDate = vo.estimateCheckOutDate;
		this.actualCheckOutDate = "";
		this.numOfPeople = vo.numOfPeople;
		this.children = vo.children;
	}

	public OrderVO(OrderPO po) {
		this(po.getOrderID(), po.getOrderState(), po.getClientID(), po.getHotelID(), po.getRoomNumberList(),
				po.getPromotionIDList(), po.getValue(), po.getMakeTime(), po.getExecuteTime(), po.getFinishTime(),
				po.getLatestETime(), po.getCheckInDate(), po.getEstimateCheckOutDate(), po.getActualCheckOutDate(),
				po.getNumOfPeople(), po.isChildren());
	}

	public static OrderVO copy(OrderVO vo) {
		return new OrderVO(vo.orderID, vo.orderState, vo.clientID, vo.hotelID, vo.roomNumberList, vo.promotionIDList,
				vo.value, vo.makeTime, vo.executeTime, vo.finishTime, vo.latestETime, vo.checkInDate,
				vo.estimateCheckOutDate, vo.actualCheckOutDate, vo.numOfPeople, vo.children);
	}

}
