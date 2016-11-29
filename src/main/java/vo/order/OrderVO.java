package vo.order;

import java.util.ArrayList;

import util.OrderState;

public class OrderVO {
	/**
	 * 订单id
	 */
	public String orderId;
	/**
	 * 订单状态
	 */
	public OrderState orderState;
	/**
	 * 用户id
	 */
	public String clientId;
	/**
	 * 酒店id
	 */
	public String hotelId;
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
	 * 预计入住人数
	 */
	public int numOfPeople;
	/**
	 * 有无儿童
	 */
	public boolean children;
	
	/**
	 * @param orderId
	 * @param orderState
	 * @param clientId
	 * @param hotelId
	 * @param roomNumberList
	 * @param promotionIDList
	 * @param value
	 * @param makeTime
	 * @param executeTime
	 * @param finishTime
	 * @param latestETime
	 * @param checkInDate
	 * @param estimateCheckOutDate
	 * @param numOfPeople
	 * @param children
	 */
	public OrderVO(String orderId, OrderState orderState, String clientId, String hotelId,
			ArrayList<String> roomNumberList, ArrayList<String> promotionIDList, double value, String makeTime,
			String executeTime, String finishTime, String latestETime, String checkInDate, String estimateCheckOutDate,
			int numOfPeople, boolean children) {
		super();
		this.orderId = orderId;
		this.orderState = orderState;
		this.clientId = clientId;
		this.hotelId = hotelId;
		this.roomNumberList = roomNumberList;
		this.promotionIDList = promotionIDList;
		this.value = value;
		this.makeTime = makeTime;
		this.executeTime = executeTime;
		this.finishTime = finishTime;
		this.latestETime = latestETime;
		this.checkInDate = checkInDate;
		this.estimateCheckOutDate = estimateCheckOutDate;
		this.numOfPeople = numOfPeople;
		this.children = children;
	}
	
}
