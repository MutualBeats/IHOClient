package factory.datahelper._test;

import java.rmi.RemoteException;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.HotelDataHelper;

public class HotelTest {
	
	public static void main(String[] args) {
		DataHelperFactory helperFactory = DataHelperFactory.getDataFactoryHelperInstance();
		
		try {
			HotelDataHelper hotelHelper = helperFactory.getHotelDatabase();
			System.out.println(hotelHelper == null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
