package factory_test;

import static org.junit.Assert.*;

import org.junit.Test;

import factory.datahelper.DataHelperFactory;


/**
 * @author Saltwater
 * Test For DataFactoryHelper.
 * Test the connection of rmi service
 * @Warning : Please run the server when you want to run this test-case !
 */
public class DataFactoryHelperTest {
	
	@Test
	public void rmiConnectionTest() {
		DataHelperFactory factory = DataHelperFactory.getDataFactoryHelperInstance();
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
		} catch (Exception e) {
			fail("Connection Error");
		}
		
	}

}
