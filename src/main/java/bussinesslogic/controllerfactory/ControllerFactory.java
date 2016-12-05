package bussinesslogic.controllerfactory;

import java.rmi.RemoteException;

import bussinesslogic.creditbl.CreditController;
import bussinesslogic.hotelbl.HotelController;
import bussinesslogic.orderbl.ClientInfo;
import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogic.orderbl.OrderController;
import bussinesslogic.orderbl.PromotionGet;
import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogic.promotionbl.PromotionController;
import bussinesslogic.roombl.RoomController;
import bussinesslogic.userbl.client.ClientController;
import bussinesslogic.userbl.manager.ManagerController;
import bussinesslogic.userbl.manager.entrust.ClientInfoGet;
import bussinesslogic.userbl.manager.entrust.HotelAdd;
import bussinesslogic.userbl.manager.entrust.MarketerManage;
import bussinesslogic.userbl.manager.entrust.StaffManage;
import bussinesslogic.userbl.marketer.MarketerController;
import bussinesslogic.userbl.staff.StaffController;
import bussinesslogicservice.creditblservice.CreditBLService;
import bussinesslogicservice.hotelblservice.HotelBLService;
import bussinesslogicservice.orderblservice.OrderBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import bussinesslogicservice.roomblservice.RoomBLService;
import bussinesslogicservice.userblservice.ClientBLService;
import bussinesslogicservice.userblservice.ManagerBLService;
import bussinesslogicservice.userblservice.MarketerBLService;
import bussinesslogicservice.userblservice.StaffBLService;
import dataservice.utildataservice.Identify;
import factory.datahelper.DataHelperFactory;

public class ControllerFactory {
	
	private static CreditController creditController;
	private static HotelController hotelController;
	private static OrderController orderController;
	private static PromotionController promotionController;
	private static RoomController roomController;
	
	private static ClientController clientController;
	private static MarketerController marketerController;
	private static StaffController staffController;
	private static ManagerController managerController;
	
	private static Identify identify_service;
	
	private ControllerFactory(){}
	
	public static CreditBLService getCreditBLServiceInstance(){
		if(creditController == null) {
			creditController = new CreditController();
		}
		return creditController;
	}
	
	public static CreditUpdate getCreditUpdateInstance() {
		if(creditController == null) {
			creditController = new CreditController();
		}
		return creditController;
	}
	
	public static HotelBLService getHotelBLServiceInstance() {
		if(hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public static OrderBLService getOrderBLServiceInstance() {
		if(orderController == null) {
			orderController = new OrderController();
		}
		return orderController;
	}
	
	public static PromotionBLService getPromotionBLServiceInstance() {
		if(promotionController == null) {
			promotionController = new PromotionController();
		}
		return promotionController;
	}
	
	public static PromotionGet getPromotionGetInstance() {
		if(promotionController == null) {
			promotionController = new PromotionController();
		}
		return promotionController;
	}
	
	public static RoomBLService getRoomBLServiceInstance() {
		if(roomController == null) {
			roomController = new RoomController();
		}
		return roomController;
	}
	
	public static RoomUpdate getRoomUpdateInstance() {
		if(roomController == null) {
			roomController = new RoomController();
		}
		return roomController;
	}
	
	public static ClientBLService getClientBLServiceInstance()  {
		if(clientController == null) {
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static StaffBLService getStaffBLServiceInstance()  {
		if(staffController == null) {
			staffController = new StaffController();
		}
		return staffController;
	}
	
	public static MarketerBLService getMarketerBLServiceInstance() {
		if(marketerController == null) {
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static ManagerBLService getManagerBLServiceInstance()  {
		if(managerController == null) {
			managerController = new ManagerController();
		}
		return managerController;
	}
	
	public static ClientInfoGet getClient2ManagerInstance() {
		if(clientController == null){
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static StaffManage getStaff2ManagerInstance() {
		if(staffController == null){
			staffController = new StaffController();
		}
		return staffController;
	}
	
	public static MarketerManage getMarketer2ManagerInstance() {
		if(marketerController == null){
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static HotelAdd getHotel2ManagerInstance(){
		if(hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public static ClientInfo getClientInfoInstance() {
		if(clientController == null) {
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static  Identify getIdentityService() throws RemoteException {
		if(identify_service == null ){
			identify_service = DataHelperFactory.getDataFactoryHelperInstance().getIdentityService();
		}
		return identify_service;
	}
	
}
