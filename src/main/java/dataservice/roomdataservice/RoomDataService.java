/**
 * @author huangxiao
 * 2016年10月15日
 */
package dataservice.roomdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.room.RoomPO;
import po.room.RoomRecordPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Room;

public interface RoomDataService extends Remote{
	/**
	 * 获取房间列表
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomPO> getRoom(String hotelID) throws NetException;
	/**
	 * 获取房间信息
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public RoomPO getRoomInfo(String hotelID, String roomNumber) throws NetException;
	/**
	 * 添加酒店
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Room addRoom(RoomPO po) throws NetException;
	/**
	 * 入住
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Room checkIn(String hotelID, String roomNumber, boolean isOnline) throws NetException;
	/**
	 * 离开
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Room checkOut(String hotelID, String roomNumber, boolean isOnline) throws NetException;
	/**
	 * 获得预定记录
	 * 
	 * @param hotelID
	 * @param roomNumber
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomRecordPO> getOrderRecord(String hotelID, String roomNumber) throws NetException;
	/**
	 * 增加房间预定记录
	 * 
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Room addRecord(RoomRecordPO po) throws NetException;
	/**
	 * 删除房间预定记录
	 * 
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_Room deleteRecord(String orderID) throws NetException;

	
}
