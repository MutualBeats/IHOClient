package vo.order;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.order.OrderPO;
import util.Time;
import util.order.OrderState;

public class OrderVO {
	private final static String STATES[] = { "未执行订单", "执行中订单", "已完成订单", "已撤销订单", "异常订单" };
	private final static String EVA_FINISH = "已评价";
	private final static String EVA_UNFINISH = "未评价";

	private StringProperty make_time_property;
	private StringProperty finish_time_property;
	private StringProperty hotel_property;
	private StringProperty state_property;
	private StringProperty id_property;
	private StringProperty evaluation_state;

	public void setStateProperty(OrderState state) {
		orderState = state;
		state_property = new SimpleStringProperty(STATES[state.ordinal()]);
	}

	public void setFinishTimeProperty(String finish_time) {
		this.finishTime = finish_time;
		finish_time_property = new SimpleStringProperty(finish_time);
	}

	public void setEvaluationState(boolean isEvaluate) {
		this.isEvaluate = isEvaluate;
		evaluation_state = new SimpleStringProperty(isEvaluate ? EVA_FINISH : EVA_UNFINISH);
	}

	public StringProperty getEvaluateState() {
		return evaluation_state;
	}

	public StringProperty getMake_time_property() {
		return make_time_property;
	}

	public StringProperty getFinish_time_property() {
		return finish_time_property;
	}

	public StringProperty getHotel_property() {
		return hotel_property;
	}

	public StringProperty getState_property() {
		return state_property;
	}

	public StringProperty getId_property() {
		return id_property;
	}

	public String getOrderState() {
		return STATES[orderState.ordinal()];
	}

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
	public String latest_execute_time;
	/**
	 * 预订入住日期
	 */
	public String estimate_checkInDate;
	/**
	 * 预订离开时间
	 */
	public String estimate_checkOutDate;
	/**
	 * 实际离开日期
	 */
	public String actual_checkOutDate;
	/**
	 * 预计入住人数
	 */
	public int numOfPeople;
	/**
	 * 有无儿童
	 */
	public boolean children;

	/**
	 * 是否已评价
	 */
	public boolean isEvaluate;

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
			String actualCheckOutDate, int numOfPeople, boolean children, boolean isEvaluate) {
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
		this.latest_execute_time = latestETime;
		this.estimate_checkInDate = checkInDate;
		this.estimate_checkOutDate = estimateCheckOutDate;
		this.actual_checkOutDate = actualCheckOutDate;
		this.numOfPeople = numOfPeople;
		this.children = children;
		this.isEvaluate = isEvaluate;

		make_time_property = new SimpleStringProperty(makeTime);
		finish_time_property = new SimpleStringProperty(finishTime);
		hotel_property = new SimpleStringProperty(hotelID);
		state_property = new SimpleStringProperty(STATES[orderState.ordinal()]);
		id_property = new SimpleStringProperty(orderID);
		evaluation_state = new SimpleStringProperty(isEvaluate ? EVA_FINISH : EVA_UNFINISH);
	}

	public OrderVO(OrderMakeVO vo) {
		this("", OrderState.Unexecuted, vo.clientID, vo.hotelID, vo.roomNumberList, null, 0, Time.getCurrentTime(), "",
				"", vo.checkInDate + " " + "23:59:59", vo.checkInDate, vo.estimateCheckOutDate, "", vo.numOfPeople,
				vo.children, false);
		// this.orderState = OrderState.Unexecuted;
		// this.clientID = vo.clientID;
		// this.hotelID = vo.hotelID;
		// this.roomNumberList = vo.roomNumberList;
		// this.makeTime = Time.getCurrentTime();
		// this.executeTime = "";
		// this.finishTime = "";
		// this.latestETime = this.checkInDate = vo.checkInDate;
		// this.estimateCheckOutDate = vo.estimateCheckOutDate;
		// this.actualCheckOutDate = "";
		// this.numOfPeople = vo.numOfPeople;
		// this.children = vo.children;
	}

	public OrderVO(OrderPO po) {
		this(po.getOrderID(), po.getOrderState(), po.getClientID(), po.getHotelID(), po.getRoomNumberList(),
				po.getPromotionIDList(), po.getValue(), po.getMakeTime(), po.getExecuteTime(), po.getFinishTime(),
				po.getLatestETime(), po.getCheckInDate(), po.getEstimateCheckOutDate(), po.getActualCheckOutDate(),
				po.getNumOfPeople(), po.isChildren(), po.isEvaluate());
	}

	public static OrderVO copy(OrderVO vo) {
		return new OrderVO(vo.orderID, vo.orderState, vo.clientID, vo.hotelID, vo.roomNumberList, vo.promotionIDList,
				vo.value, vo.makeTime, vo.executeTime, vo.finishTime, vo.latest_execute_time, vo.estimate_checkInDate,
				vo.estimate_checkOutDate, vo.actual_checkOutDate, vo.numOfPeople, vo.children, vo.isEvaluate);
	}

}
