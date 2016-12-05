package factory.datahelper;

import java.rmi.RemoteException;

import dataservice.datafactory.DataFactory;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.ClientDataService;
import dataservice.userdataservice.ManagerDataService;
import dataservice.userdataservice.MarketerDataService;
import dataservice.userdataservice.StaffDataService;
import dataservice.utildataservice.Identify;

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
	private OrderDataService orderDataService;
	private PromotionDataHelper promotionDataHelper;
	private RoomDataHelper roomDataHelper;
	private ClientDataService clientDataService;
	private StaffDataService staffDataService;
	private MarketerDataService marketerDataService;
	private ManagerDataService managerDataService;
	private Identify identify;

	private DataHelperFactory() {
	}

	public static DataHelperFactory getDataFactoryHelperInstance() {
		if (helper == null) {
			helper = new DataHelperFactory();
		}
		return helper;
	}

	private static synchronized void checkFactoryState() {
		if (factory == null) {
			factory = RMIConnectHelper.connect();
		}
	}

	public CreditDataHelper getCreditDatabase() throws RemoteException {
		if (creditDataHelper == null) {
			checkFactoryState();
			creditDataHelper = new CreditDataHelper(factory.getCreditDatabase());
		}
		return creditDataHelper;
	}

	public HotelDataHelper getHotelDatabase() throws RemoteException {
		if (hotelDataHelper == null) {
			checkFactoryState();
			hotelDataHelper = new HotelDataHelper(factory.getHotelDatabase());
		}
		return hotelDataHelper;
	}

	public OrderDataService getOrderDatabase() throws RemoteException {
		if (orderDataService == null) {
			checkFactoryState();
			orderDataService = factory.getOrderDatabase();
		}
		return orderDataService;
	}

	public PromotionDataHelper getPromotionDatabase() throws RemoteException {
		if (promotionDataHelper == null) {
			checkFactoryState();
			promotionDataHelper = new PromotionDataHelper(factory.getPromotionDatabase());
		}
		return promotionDataHelper;
	}

	public RoomDataHelper getRoomDatabase() throws RemoteException {
		if (roomDataHelper == null) {
			checkFactoryState();
			roomDataHelper = new RoomDataHelper(factory.getRoomDatabase());
		}
		return roomDataHelper;
	}

	public ClientDataService getClientDatabase() throws RemoteException {
		if (clientDataService == null) {
			checkFactoryState();
			clientDataService = factory.getClientDatabase();
		}
		return clientDataService;
	}

	public StaffDataService getStaffDatabase() throws RemoteException {
		if (staffDataService == null) {
			checkFactoryState();
			staffDataService = factory.getStaffDatabase();
		}
		return staffDataService;
	}

	public MarketerDataService getMarketerDatabase() throws RemoteException {
		if (marketerDataService == null) {
			checkFactoryState();
			marketerDataService = factory.getMarketerDatabase();
		}
		return marketerDataService;
	}

	public ManagerDataService getManagerDatabase() throws RemoteException {
		if (managerDataService == null) {
			checkFactoryState();
			managerDataService = factory.getManagerDatabase();
		}
		return managerDataService;
	}
	
	public Identify getIdentityService() throws RemoteException {
		if(identify == null) {
			checkFactoryState();
			identify = factory.getIdentityService();
		}
		return identify;
	}
	
}
