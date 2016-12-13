/**
 * @author huangxiao
 * @version 2016年11月26日
 */
package data_test.credit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import factory.datahelper.CreditDataHelper;
import factory.datahelper.DataHelperFactory;
import vo.credit.CreditVO;

public class CreditDataTest {
	private CreditDataHelper creditDataHelper;
	
	@Before
	public void init() {
		try {
			creditDataHelper = DataHelperFactory.getDataFactoryHelperInstance().getCreditDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testIncrease() {
	}
	
	@Test
	public void testFind() {
		try {
			ArrayList<CreditVO> list = creditDataHelper.find("1234567890");
			Iterator<CreditVO> it = list.iterator();
			for(; it.hasNext();) {
				if(!it.next().clientID.equals("1234567890"))
					fail("Find Error!");
				// TODO
			}
		} catch (Exception e) {
			fail("Exception!");
			e.printStackTrace();
		}
	}
	
	

}
