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
import bussinesslogic.userbl.manager.entrust.Client2Manager;
import bussinesslogic.userbl.manager.entrust.Hotel2Manager;
import bussinesslogic.userbl.manager.entrust.Marketer2Manager;
import bussinesslogic.userbl.manager.entrust.Staff2Manager;
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
	
	public static ClientBLService getClientBLServiceInstance() throws RemoteException {
		if(clientController == null) {
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static StaffBLService getStaffBLServiceInstance() throws RemoteException {
		if(staffController == null) {
			staffController = new StaffController();
		}
		return staffController;
	}
	
	public static MarketerBLService getMarketerBLServiceInstance() throws RemoteException {
		if(marketerController == null) {
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static ManagerBLService getManagerBLServiceInstance() throws RemoteException {
		if(managerController == null) {
			managerController = new ManagerController();
		}
		return managerController;
	}
	
	public static Client2Manager getClient2ManagerInstance() throws RemoteException{
		if(clientController == null){
			clientController = new ClientController();
		}
		return clientController;
	}
	
	public static Staff2Manager getStaff2ManagerInstance() throws RemoteException{
		if(staffController == null){
			staffController = new StaffController();
		}
		return staffController;
	}
	
	public static Marketer2Manager getMarketer2ManagerInstance() throws RemoteException{
		if(marketerController == null){
			marketerController = new MarketerController();
		}
		return marketerController;
	}
	
	public static Hotel2Manager getHotel2ManagerInstance(){
		if(hotelController == null) {
			hotelController = new HotelController();
		}
		return hotelController;
	}
	
	public static ClientInfo getClientInfoInstance() {
		//TODO:
		return null;
	}
	
}
