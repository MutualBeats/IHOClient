/**
 * @author huangxiao
 * 2016年11月16日
 */
package dataservice.datafactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.UserDataService;

public interface DataFactory extends Remote{
	
	public CreditDataService getCreditDatabase() throws RemoteException;
	
	public HotelDataService getHotelDatabase() throws RemoteException;
	
	public OrderDataService getOrderDatabase() throws RemoteException;
	
	public PromotionDataService getPromotionDatabase() throws RemoteException;
	
	public RoomDataService getRoomDatabase() throws RemoteException;
	
	public UserDataService getUserDatabase() throws RemoteException;
	
}
