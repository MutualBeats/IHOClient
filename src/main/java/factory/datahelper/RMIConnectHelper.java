package factory.datahelper;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;

import dataservice.datafactoryservice.DataFactory;


public class RMIConnectHelper {
	
	private final static int port = 8888;
	
	public static DataFactory connect() throws Exception {
		DataFactory factory = null;
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.err.println("Fail To Get LocalHost");
			System.exit(3);
		}
		/*-------------------*/
		
		factory = (DataFactory) Naming.lookup("rmi://"+ ip + ":"+port+"/DataFactory");
		
		return factory;
	}
	
}
