package factory.test_helper;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import dataservice.datafactoryservice.DataFactory;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.roomdataservice.RoomDataService;
import po.credit.CreditPO;

public class DataFactoryHelper {

	private final static int port = 8888;

	private static DataFactory factory = null;

	private DataFactoryHelper() {
	}

	public static void main(String[] args) {
		DataFactory factory = getDataFactoryInstance();

		try {
			HotelDataService service = factory.getHotelDatabase();
			System.out.println(service.toString());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static synchronized DataFactory getDataFactoryInstance() {
		if (factory == null) {
			/*-----Get IP------*/
			String ip = null;
			try {
				ip = InetAddress.getLocalHost().getHostAddress();
			} catch (UnknownHostException e) {
				;
				System.err.println("Fail To Get LocalHost");
				System.exit(3);
			}
			/*-------------------*/
			try {
				factory = (DataFactory) Naming.lookup("rmi://" + ip + ":" + port + "/DataFactory");
			} catch (MalformedURLException | RemoteException | NotBoundException e) {
//				System.err.println("Error");
				e.printStackTrace();
			}
		}

		return factory;
	}

}
