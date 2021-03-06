package factory.datahelper;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.datafactoryservice.DataFactory;
import util.exception.NetException;

public class RMIConnectHelper {

	private final static int port = 8888;

	public static DataFactory connect() throws NetException {
		DataFactory factory = null;
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.err.println("Fail To Get LocalHost");
			System.exit(3);
		}
		/*-------------------*/

		try {
			factory = (DataFactory) Naming.lookup("rmi://" + ip + ":" + port + "/DataFactory");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			throw new NetException();
		}

		return factory;
	}

}
