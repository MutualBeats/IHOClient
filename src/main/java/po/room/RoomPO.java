/**
 * @author huangxiao
 * @version 2016年10月15日 po创建
 * @version 2016年11月19日 添加空构造方法
 * @version 2016年11月22日 po属性修改
 */
package po.room;

import java.io.Serializable;
import java.rmi.RemoteException;

import util.room.RoomState;
import util.room.RoomType;
import vo.room.RoomVO;

public class RoomPO implements Serializable {
	/**
	 * version id
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 所属酒店id
	 */
	private String hotelID;
	/**
	 * 房间号
	 */
	private String roomNumber;
	/**
	 * 房间类型
	 */
	private RoomType type;
	/**
	 * 房间价格
	 */
	private int price;
	/**
	 * 当前状态
	 */
	private RoomState condition;
	
	/**
	 * @param hotelID
	 * @param roomNumber
	 * @param type
	 * @param price
	 * @param condition
	 * @throws RemoteException 
	 */
	public RoomPO(String hotelID, String roomNumber, RoomType type, int price, RoomState condition) {
		this.hotelID = hotelID;
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.condition = condition;
	}

	public RoomPO() {
	}
	
	public RoomPO(RoomVO vo) {
		this(vo.hotelID, vo.roomNumber, vo.type, vo.price, vo.condition);
	}

	/**
	 * Copy Constructor
	 * 
	 * @param po
	 */
	public RoomPO(RoomPO po) {
		this(po.hotelID, po.roomNumber, po.type, po.price, po.condition);
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public RoomState getCondition() {
		return condition;
	}

	public void setCondition(RoomState condition) {
		this.condition = condition;
	}

}
