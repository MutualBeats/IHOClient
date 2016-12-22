package bussinesslogic.controllerfactory;

import bussinesslogic.creditbl.CreditController;
import bussinesslogic.creditbl.Notify;
import bussinesslogic.hotelbl.HotelController;
import bussinesslogic.hotelbl.OrderUpdate;
import bussinesslogic.orderbl.ClientInfo;
import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogic.orderbl.HotelInfo;
import bussinesslogic.orderbl.OrderController;
import bussinesslogic.orderbl.PromotionGet;
import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogic.promotionbl.MemberLevelGet;
import bussinesslogic.promotionbl.PromotionController;
import bussinesslogic.roombl.RoomController;
import bussinesslogic.userbl.client.ClientController;
import bussinesslogic.userbl.client.CreditRegister;
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
import util.exception.NetException;

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
	
	public static CreditBLService getCreditBLServiceInstance() throws NetException {
		if(creditController == null) {
			creditController = new CreditController();
		}
		return creditController;
	}
	
	public static CreditUpdate getCreditUpdateInstance() throws NetException {
		if(creditController == null) {
			creditController = new CreditController();
		}
		return creditController;
	}
	
	public static HotelBLService getHotelBLServiceInstance() throws NetException {
		if(hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public static HotelInfo getHotelInfoInstance() throws NetException {
		if(hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public static OrderBLService getOrderBLServiceInstance() throws NetException {
		if(orderController == null) {
			orderController = new OrderController();
		}
		return orderController;
	}
	
	public static PromotionBLService getPromotionBLServiceInstance() throws NetException {
		if(promotionController == null) {
			promotionController = new PromotionController();
		}
		return promotionController;
	}
	
	public static MemberLevelGet getMemberLevel() throws NetException {
		if(promotionController == null) {
			promotionController = new PromotionController();
		}
		return promotionController;
	}
	
	public static PromotionGet getPromotionGetInstance() throws NetException {
		if(promotionController == null) {
			promotionController = new PromotionController();
		}
		return promotionController;
	}
	
	public static RoomBLService getRoomBLServiceInstance() throws NetException {
		if(roomController == null) {
			roomController = new RoomController();
		}
		return roomController;
	}
	
	public static RoomUpdate getRoomUpdateInstance() throws NetException {
		if(roomController == null) {
			roomController = new RoomController();
		}
		return roomController;
	}
	
	public static ClientBLService getClientBLServiceInstance() throws NetException {
		if(clientController == null) {
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static StaffBLService getStaffBLServiceInstance() throws NetException {
		if(staffController == null) {
			staffController = new StaffController();
		}
		return staffController;
	}
	
	public static MarketerBLService getMarketerBLServiceInstance() throws NetException {
		if(marketerController == null) {
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static ManagerBLService getManagerBLServiceInstance() throws NetException {
		if(managerController == null) {
			managerController = new ManagerController();
		}
		return managerController;
	}
	
	public static ClientInfoGet getClient2ManagerInstance() throws NetException {
		if(clientController == null){
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static StaffManage getStaff2ManagerInstance() throws NetException {
		if(staffController == null){
			staffController = new StaffController();
		}
		return staffController;
	}
	
	public static MarketerManage getMarketer2ManagerInstance() throws NetException {
		if(marketerController == null){
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static HotelAdd getHotel2ManagerInstance() throws NetException {
		if(hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public static ClientInfo getClientInfoInstance() throws NetException {
		if(clientController == null) {
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static Notify getClientCreditNotifier() throws NetException {
		if(clientController == null) {
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static CreditRegister getCreditRegister() throws NetException {
		if(creditController == null) {
			creditController = new CreditController();
		}
		return creditController;
	}
	
	public static  Identify getIdentityService() throws NetException {
		if(identify_service == null ){
			identify_service = DataHelperFactory.getDataFactoryHelperInstance().getIdentityService();
		}
		return identify_service;
	}
	
	public static OrderUpdate getOrderUpdate() throws NetException {
		if(orderController == null) {
			orderController = new OrderController();
		}
		return orderController;
	}
	
}
