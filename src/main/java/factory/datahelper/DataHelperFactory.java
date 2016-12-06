package factory.datahelper;

import java.rmi.RemoteException;

import dataservice.datafactoryservice.DataFactory;
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

	private static synchronized void checkFactoryState() throws Exception {
		if (factory == null) {
			factory = RMIConnectHelper.connect();
		}
	}

	public CreditDataHelper getCreditDatabase() throws Exception {
		if (creditDataHelper == null) {
			checkFactoryState();
			creditDataHelper = new CreditDataHelper(factory.getCreditDatabase());
		}
		return creditDataHelper;
	}

	public HotelDataHelper getHotelDatabase() throws Exception {
		if (hotelDataHelper == null) {
			checkFactoryState();
			hotelDataHelper = new HotelDataHelper(factory.getHotelDatabase());
		}
		return hotelDataHelper;
	}

	public OrderDataService getOrderDatabase() throws Exception {
		if (orderDataService == null) {
			checkFactoryState();
			orderDataService = factory.getOrderDatabase();
		}
		return orderDataService;
	}

	public PromotionDataHelper getPromotionDatabase() throws Exception {
		if (promotionDataHelper == null) {
			checkFactoryState();
			promotionDataHelper = new PromotionDataHelper(factory.getPromotionDatabase());
		}
		return promotionDataHelper;
	}

	public RoomDataHelper getRoomDatabase() throws Exception {
		if (roomDataHelper == null) {
			checkFactoryState();
			roomDataHelper = new RoomDataHelper(factory.getRoomDatabase());
		}
		return roomDataHelper;
	}

	public ClientDataService getClientDatabase() throws Exception {
		if (clientDataService == null) {
			checkFactoryState();
			clientDataService = factory.getClientDatabase();
		}
		return clientDataService;
	}

	public StaffDataService getStaffDatabase() throws Exception {
		if (staffDataService == null) {
			checkFactoryState();
			staffDataService = factory.getStaffDatabase();
		}
		return staffDataService;
	}

	public MarketerDataService getMarketerDatabase() throws Exception {
		if (marketerDataService == null) {
			checkFactoryState();
			marketerDataService = factory.getMarketerDatabase();
		}
		return marketerDataService;
	}

	public ManagerDataService getManagerDatabase() throws Exception {
		if (managerDataService == null) {
			checkFactoryState();
			managerDataService = factory.getManagerDatabase();
		}
		return managerDataService;
	}
	
	public Identify getIdentityService() throws Exception {
		if(identify == null) {
			checkFactoryState();
			identify = factory.getIdentityService();
		}
		return identify;
	}
	
}
