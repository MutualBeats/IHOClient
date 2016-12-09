/**
 * @author huangxiao
 * 2016年11月16日
 */
package dataservice.datafactoryservice;

import java.rmi.Remote;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.userdataservice.ClientDataService;
import dataservice.userdataservice.ManagerDataService;
import dataservice.userdataservice.MarketerDataService;
import dataservice.userdataservice.StaffDataService;
import dataservice.utildataservice.Identify;
import util.exception.NetException;

public interface DataFactory extends Remote{
	
	public CreditDataService getCreditDatabase() throws NetException;
	
	public HotelDataService getHotelDatabase() throws NetException;
	
	public OrderDataService getOrderDatabase() throws NetException;
	
	public PromotionDataService getPromotionDatabase() throws NetException;
	
	public RoomDataService getRoomDatabase() throws NetException;
	
	public ClientDataService getClientDatabase() throws NetException;
	
	public MarketerDataService getMarketerDatabase() throws NetException;
	
	public StaffDataService getStaffDatabase() throws NetException;
	
	public ManagerDataService getManagerDatabase() throws NetException;
	
	public Identify getIdentityService() throws NetException;
	
}
