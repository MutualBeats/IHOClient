package factory.datahelper;

import java.rmi.RemoteException;

import dataservice.datafactoryservice.DataFactory;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.ClientDataService;
import dataservice.userdataservice.ManagerDataService;
import dataservice.userdataservice.MarketerDataService;
import dataservice.userdataservice.StaffDataService;
import dataservice.utildataservice.Identify;
import util.exception.NetException;

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

	private static synchronized void checkFactoryState() throws NetException {
		if (factory == null) {
			factory = RMIConnectHelper.connect();
		}
	}

	public CreditDataHelper getCreditDatabase() throws NetException {
		if (creditDataHelper == null) {
			checkFactoryState();
			try {
				creditDataHelper = new CreditDataHelper(factory.getCreditDatabase());
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return creditDataHelper;
	}

	public HotelDataHelper getHotelDatabase() throws NetException {
		if (hotelDataHelper == null) {
			checkFactoryState();
			try {
				hotelDataHelper = new HotelDataHelper(factory.getHotelDatabase());
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return hotelDataHelper;
	}

	public OrderDataService getOrderDatabase() throws NetException {
		if (orderDataService == null) {
			checkFactoryState();
			try {
				orderDataService = factory.getOrderDatabase();
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return orderDataService;
	}

	public PromotionDataHelper getPromotionDatabase() throws NetException {
		if (promotionDataHelper == null) {
			checkFactoryState();
			try {
				promotionDataHelper = new PromotionDataHelper(factory.getPromotionDatabase());
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return promotionDataHelper;
	}

	public RoomDataHelper getRoomDatabase() throws NetException {
		if (roomDataHelper == null) {
			checkFactoryState();
			try {
				roomDataHelper = new RoomDataHelper(factory.getRoomDatabase());
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return roomDataHelper;
	}

	public ClientDataService getClientDatabase() throws NetException {
		if (clientDataService == null) {
			checkFactoryState();
			try {
				clientDataService = factory.getClientDatabase();
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return clientDataService;
	}

	public StaffDataService getStaffDatabase() throws NetException {
		if (staffDataService == null) {
			checkFactoryState();
			try {
				staffDataService = factory.getStaffDatabase();
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return staffDataService;
	}

	public MarketerDataService getMarketerDatabase() throws NetException {
		if (marketerDataService == null) {
			checkFactoryState();
			try {
				marketerDataService = factory.getMarketerDatabase();
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return marketerDataService;
	}

	public ManagerDataService getManagerDatabase() throws NetException {
		if (managerDataService == null) {
			checkFactoryState();
			try {
				managerDataService = factory.getManagerDatabase();
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return managerDataService;
	}
	
	public Identify getIdentityService() throws NetException {
		if(identify == null) {
			checkFactoryState();
			try {
				identify = factory.getIdentityService();
			} catch (RemoteException e) {
				throw new NetException();
			}
		}
		return identify;
	}
	
}
