package bussinesslogic.controllerfactory;

import bussinesslogic.creditbl.CreditController;
import bussinesslogic.hotelbl.HotelController;
import bussinesslogic.orderbl.ClientInfo;
import bussinesslogic.orderbl.CreditUpdate;
import bussinesslogic.orderbl.OrderController;
import bussinesslogic.orderbl.PromotionGet;
import bussinesslogic.orderbl.RoomUpdate;
import bussinesslogic.promotionbl.PromotionController;
import bussinesslogic.roombl.RoomController;
import bussinesslogic.usebl.client.ClientController;
import bussinesslogic.usebl.manager.ManagerController;
import bussinesslogic.usebl.manager.entrust.Client2Manager;
import bussinesslogic.usebl.manager.entrust.Marketer2Manager;
import bussinesslogic.usebl.manager.entrust.Staff2Manager;
import bussinesslogic.usebl.marketer.MarketerController;
import bussinesslogic.usebl.staff.StaffController;
import bussinesslogicservice.creditblservice.CreditBLService;
import bussinesslogicservice.hotelblservice.HotelBLService;
import bussinesslogicservice.orderblservice.OrderBLService;
import bussinesslogicservice.promotionblservice.PromotionBLService;
import bussinesslogicservice.roomblservice.RoomBLService;
import bussinesslogicservice.userblservice.ClientBLService;
import bussinesslogicservice.userblservice.ManagerBLService;
import bussinesslogicservice.userblservice.MarketerBLService;

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
	
	public static ClientBLService getClientBLServiceInstance() {
		if(clientController == null) {
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static ClientBLService getStaffBLServiceInstance() {
		if(staffController == null) {
			staffController = new StaffController();
		}
		return clientController;
	}
	
	public static MarketerBLService getMarketerBLServiceInstance() {
		if(marketerController == null) {
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static ManagerBLService getManagerBLServiceInstance() {
		if(managerController == null) {
			managerController = new ManagerController();
		}
		return managerController;
	}
	
	public static Client2Manager getClient2ManagerIstance(){
		if(clientController == null){
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static Staff2Manager getStaff2ManagerIstance(){
		if(staffController == null){
			staffController = new StaffController();
		}
		return staffController;
	}
	
	public static Marketer2Manager getManager2ManagerIstance(){
		if(marketerController == null){
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static ClientInfo getClientInfoInstance() {
		//TODO:
		return null;
	}
	
}
