/**
 * @author huangxiao
 * 2016年10月15日
 */
package dataservice.roomdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDataService extends Remote{
	/**
	 * 查询酒店房间列表
	 * 
	 * @param HotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomPO> find(String HotelID) throws RemoteException;
	/**
	 * 增加房间
	 * 
	 * @param po
	 * @throws RemoteException : Net Error
	 */
	public ResultMessage_Room insert(RoomPO po) throws RemoteException;
	/**
	 * 更新房间信息
	 * 
	 * @param po
	 * @throws RemoteException
	 */
	public ResultMessage_Room update(RoomPO po) throws RemoteException;
}
