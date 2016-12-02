package vo.order;

import java.util.ArrayList;

/**
 * VO sent when make order
 */
public class OrderMakeVO {
	/*
	 * 用户id 
	 */
	public String clientID;
	/*
	 * 酒店id
	 */
	public String hotelID;
	/*
	 * 房间号列表
	 */
	public ArrayList<String> roomNumberList;
	/*
	 * 预订入住日期
	 */
	public String checkInDate;
	/*
	 * 预订离开日期
	 */
	public String estimateCheckOutDate;
	/*
	 * 预计入住人数
	 */
	public int numOfPeople;
	/*
	 * 有无儿童
	 */
	public boolean children;
	
	/**
	 * @param clientID
	 * @param hotelID
	 * @param roomNumberList
	 * @param checkInDate
	 * @param estimateCheckOutDate
	 * @param numOfPeople
	 * @param children
	 */
	public OrderMakeVO(String clientID, String hotelID, ArrayList<String> roomNumberList, String checkInDate,
			String estimateCheckOutDate, int numOfPeople, boolean children) {
		super();
		this.clientID = clientID;
		this.hotelID = hotelID;
		this.roomNumberList = roomNumberList;
		this.checkInDate = checkInDate;
		this.estimateCheckOutDate = estimateCheckOutDate;
		this.numOfPeople = numOfPeople;
		this.children = children;
	}
	
	
}
