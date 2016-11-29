/**
 * @author huangxiao
 * @version 2016年11月26日
 */
package data_test.hotel;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.HotelDataHelper;
import po.hotel.HotelEvaluationPO;
import po.hotel.HotelPO;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;

public class HotelDataTest {
	private HotelDataHelper hotelDataHelper;

	@Before
	public void init() {
		try {
			hotelDataHelper = DataHelperFactory.getDataFactoryHelperInstance().getHotelDatabase();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void testGetHotelInfo() {
		HotelPO po = null;
		try {
			po = hotelDataHelper.getHotelInfo("00000001");

			assertNotNull(po);
			assertEquals(po.getHotelID(), "00000001");
			assertEquals(po.getHotelName(), "锦都金鼎大酒店");
			assertEquals(po.getRegion(), "如皋市");
			assertEquals(po.getBusinessDistrict(), "如城街道");
			
		} catch (Exception e) {
			System.out.println("RemoteException");
		}
	}
	
	@Test
	public void testFindHotelByCondition() {
		SearchCondition sc = new SearchCondition(null, "如皋市", "如城街道", null, 5, 4);
		Iterator<HotelPO> it = null;
		try {
			it = hotelDataHelper.findHotelByCondition(sc);

			assertNotNull(it);
			assertEquals("00000001", it.next().getHotelID());
		} catch (Exception e) {
			System.out.println("RemoteException");

		}
	}
	
	@Test
	public void testChangeHotelInfo() {
		HotelPO po = new HotelPO();
		po.setHotelID("00000001");
		po.setHotelName("锦都金鼎大酒店");
		po.setAddress("市政府对面");
		po.setRegion("如皋市");
		po.setBusinessDistrict("如城街道");
		
		
		String newAdress = null;
		try {
			ResultMessage_Hotel res = hotelDataHelper.changeHotelInfo(po);
			assertEquals(res, ResultMessage_Hotel.Change_Successful);
			
			newAdress = hotelDataHelper.getHotelInfo("00000001").getAddress();
			assertNotNull(newAdress);
			assertEquals(newAdress, "市政府对面");
		} catch (Exception e) {
			System.out.println("RemoteException");
		}
		
	}
	
	@Test
	public void testEvaluate() {
		HotelEvaluationPO po = new HotelEvaluationPO();
		po.setHotelID("00000001");
		po.setClientID("0000000001");
		po.setEvaluateTime("2999/11/27 00:15:30");
		po.setEvaluateScore(3);
		po.setEvaluateInfo("测试评论");
		
		
		double newScore = 0;
		try {
			ResultMessage_Hotel res = hotelDataHelper.evaluate(po);
			assertEquals(ResultMessage_Hotel.Evaluate_Successful, res);
			newScore = hotelDataHelper.getHotelInfo("00000001").getScore();
			if(newScore != 3.75)
				fail("New Score Error!");
		} catch (Exception e) {
			System.out.println("RemoteException");
		}
	
	}
	
	@Test
	public void testAddHotel() {
		HotelPO po = new HotelPO();
		po.setHotelID("11111111");
		po.setRegion("南京市");
		po.setBusinessDistrict("栖霞区");
		po.setAddress("南大和园");
		po.setHotelName("测试宾馆");
		po.setScore(3.56);
		po.setStarLevel(3);
		
		
		HotelPO res = null;
		try {
			hotelDataHelper.addHotel(po);
			
			res = hotelDataHelper.getHotelInfo("11111111");
			assertNotNull(res);
			assertEquals("11111111", res.getHotelID());
			assertEquals("测试宾馆", res.getHotelName());
		} catch (Exception e) {
			System.out.println("RemoteException");

		}
	}
	
	@Test
	public void testGetHotelEvaluation() {
		Iterator<HotelEvaluationPO> it = null;
		try {
			it = hotelDataHelper.getHotelEvaluation("00000001");
			assertNotNull(it);
			assertEquals("测试评论", it.next().getEvaluateInfo());
		} catch (Exception e) {
			System.out.println("RemoteException");

		}
	}

}
