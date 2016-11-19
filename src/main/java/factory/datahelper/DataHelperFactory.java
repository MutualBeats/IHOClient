package factory.datahelper;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.datafactoryservice.DataFactory;

public class DataHelperFactory {
	/**
	 * Config
	 */
	private final static int port = 8888;
	
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
	
	private DataHelperFactory(){
	}
	
	public static DataHelperFactory getDataFactoryHelperInstance() {
		if(helper == null) {
			helper = new DataHelperFactory();
		}
		return helper;
	}
	
	private static synchronized void getDataFactoryInstance() {
		if(factory == null) {
			/*-----Get IP------*/
			String ip = null;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {;
				System.err.println("Fail To Get LocalHost");
				System.exit(3);
			}
			/*-------------------*/
			try {
				factory = (DataFactory) Naming.lookup("rmi://"+ ip + ":"+port+"/DataFactory");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
				// TODO 	Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public CreditDataHelper getCreditDatabase() throws RemoteException {
		if(creditDataHelper == null) {
			getDataFactoryInstance();
			creditDataHelper = new CreditDataHelper(factory.getCreditDatabase());
		}
		return creditDataHelper;
	}

	public HotelDataHelper getHotelDatabase() throws RemoteException {
		if(hotelDataHelper == null) {
			getDataFactoryInstance();
			hotelDataHelper = new HotelDataHelper(factory.getHotelDatabase());
		}
		return hotelDataHelper;
	}

	public OrderDataHelper getOrderDatabase() throws RemoteException {
		if(orderDataHelper == null) {
			getDataFactoryInstance();
			orderDataHelper = new OrderDataHelper(factory.getOrderDatabase());
		}
		return orderDataHelper;
	}

	public PromotionDataHelper getPromotionDatabase() throws RemoteException {
		if(promotionDataHelper == null) {
			getDataFactoryInstance();
			promotionDataHelper = new PromotionDataHelper(factory.getPromotionDatabase());
		}
		return promotionDataHelper;
	}

	public RoomDataHelper getRoomDatabase() throws RemoteException {
		if(roomDataHelper == null) {
			getDataFactoryInstance();
			roomDataHelper = new RoomDataHelper(factory.getRoomDatabase());
		}
		return roomDataHelper;
	}

//	public ClientDataHelper getClientDatabase() throws RemoteException {
//		if(creditDataHelper == null) {
//			getDataFactoryInstance();
//			
//		}
//		return null;
//	}
//
//	public MarketerDataHelper getMarketerDatabase() throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public StaffDataHelper getStaffDatabase() throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public ManagerDataHelper getManagerDatabase() throws RemoteException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	
}
