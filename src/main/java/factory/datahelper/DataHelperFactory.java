package factory.datahelper;

import java.rmi.RemoteException;

import dataservice.datafactoryservice.DataFactory;

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
	 * DataFactory Helpe
	 */
	private static DataHelperFactory helper = null;

	private CreditDataHelper creditDataHelper;
	private HotelDataHelper hotelDataHelper;
	private OrderDataHelper orderDataHelper;
	private PromotionDataHelper promotionDataHelper;
	private RoomDataHelper roomDataHelper;

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

	// public ClientDataHelper getClientDatabase() throws RemoteException {
	// if(creditDataHelper == null) {
	// getDataFactoryInstance();
	//
	// }
	// return null;
	// }
	//
	// public MarketerDataHelper getMarketerDatabase() throws RemoteException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// public StaffDataHelper getStaffDatabase() throws RemoteException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// public ManagerDataHelper getManagerDatabase() throws RemoteException {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//

}
