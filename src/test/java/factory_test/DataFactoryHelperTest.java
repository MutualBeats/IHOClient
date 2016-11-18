package factory_test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import dataservice.datafactory.DataFactory;
import factory.DataFactoryHelper;

/**
 * @author Saltwater
 * Test For DataFactoryHelper.
 * Test the connection of rmi service
 * @Warning : Please run the server when you want to run this test-case !
 */
public class DataFactoryHelperTest {
	
	@Test
	public void rmiConnectionTest() {
		DataFactory factory = DataFactoryHelper.getDataFactoryInstance();
		assertNotNull(factory);
		try {
			assertNotNull(factory.getCreditDatabase());
			assertNotNull(factory.getHotelDatabase());
			assertNotNull(factory.getOrderDatabase());
			assertNotNull(factory.getPromotionDatabase());
			assertNotNull(factory.getRoomDatabase());
			assertNotNull(factory.getClientDatabase());
			assertNotNull(factory.getManagerDatabase());
			assertNotNull(factory.getMarketerDatabase());
			assertNotNull(factory.getStaffDatabase());
		} catch (RemoteException e) {
			fail("Connection Error");
		}
	}

}
