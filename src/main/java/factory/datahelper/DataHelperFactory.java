package factory.datahelper;

import java.rmi.RemoteException;

import dataservice.datafactoryservice.DataFactory;
import dataservice.userdataservice.ClientDataService;
import dataservice.userdataservice.ManagerDataService;
import dataservice.userdataservice.MarketerDataService;
import dataservice.userdataservice.StaffDataService;

/**
 * A factory using singleton
 * 
 * @author Saltwater
 */
public class DataHelperFactory {
	/**
	 * Connection to RMI
	 */
	private static DataFactory factory = null;
	/**
	 * DataFactory Helper
	 */
	private static DataHelperFactory helper = null;

	private CreditDataHelper creditDataHelper;
	private HotelDataHelper hotelDataHelper;
	private OrderDataHelper orderDataHelper;
	private PromotionDataHelper promotionDataHelper;
	private RoomDataHelper roomDataHelper;
	private ClientDataService clientDataService;
	private StaffDataService staffDataService;
	private MarketerDataService marketerDataService;
	private ManagerDataService managerDataService;

	private DataHelperFactory() {
	}

	public static DataHelperFactory getDataFactoryHelperInstance() {
		if (helper == null) {
			helper = new DataHelperFactory();
		}
		return helper;
	}

	private static synchronized DataFactory getDataFactoryInstance() {
		DataFactory factory = null;
		factory = RMIConnectHelper.connect();
		return factory;
	}

	public CreditDataHelper getCreditDatabase() throws RemoteException {
		if (creditDataHelper == null) {
			if (factory == null) {
				factory = getDataFactoryInstance();
			}
			creditDataHelper = new CreditDataHelper(factory.getCreditDatabase());
		}
		return creditDataHelper;
	}

	public HotelDataHelper getHotelDatabase() throws RemoteException {
		if (hotelDataHelper == null) {
			getDataFactoryInstance();
			hotelDataHelper = new HotelDataHelper(factory.getHotelDatabase());
		}
		return hotelDataHelper;
	}

	public OrderDataHelper getOrderDatabase() throws RemoteException {
		if (orderDataHelper == null) {
			getDataFactoryInstance();
			orderDataHelper = new OrderDataHelper(factory.getOrderDatabase());
		}
		return orderDataHelper;
	}

	public PromotionDataHelper getPromotionDatabase() throws RemoteException {
		if (promotionDataHelper == null) {
			getDataFactoryInstance();
			promotionDataHelper = new PromotionDataHelper(factory.getPromotionDatabase());
		}
		return promotionDataHelper;
	}

	public RoomDataHelper getRoomDatabase() throws RemoteException {
		if (roomDataHelper == null) {
			getDataFactoryInstance();
			roomDataHelper = new RoomDataHelper(factory.getRoomDatabase());
		}
		return roomDataHelper;
	}

	 public ClientDataService getClientDatabase() throws RemoteException {
		 if(clientDataService==null){
			 if(factory==null){
				 factory = getDataFactoryInstance();
				 clientDataService = factory.getClientDatabase();
			 }
		}
	 return clientDataService;
	 }
	 
	 public StaffDataService getStaffDatabase() throws RemoteException {
		 if(staffDataService==null){
			 if(factory==null){
				 factory = getDataFactoryInstance();
				 staffDataService = factory.getStaffDatabase();
			 }
		}
	 return staffDataService;
	 }
	 
	 public MarketerDataService getMarketerDatabase() throws RemoteException {
		 if(marketerDataService==null){
			 if(factory==null){
				 factory = getDataFactoryInstance();
				 marketerDataService = factory.getMarketerDatabase();
			 }
		}
	 return marketerDataService;
	 }
	 
	 public ManagerDataService getManagerDatabase() throws RemoteException {
		 if(managerDataService==null){
			 if(factory==null){
				 factory = getDataFactoryInstance();
				 managerDataService = factory.getManagerDatabase();
			 }
		}
	 return managerDataService;
	 }

}
