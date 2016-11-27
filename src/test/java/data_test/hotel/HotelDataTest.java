/**
 * @author huangxiao
 * @version 2016年11月26日
 */
package data_test.hotel;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import dataservice.hoteldataservice.ResultMessage_Hotel;
import factory.datahelper.DataHelperFactory;
import factory.datahelper.HotelDataHelper;
import po.hotel.HotelEvaluationPO;
import po.hotel.HotelPO;

public class HotelDataTest {
	private HotelDataHelper hotelDataHelper;

	@Before
	public void init() {
		try {
			hotelDataHelper = DataHelperFactory.getDataFactoryHelperInstance().getHotelDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetHotelInfo() {
		HotelPO po = null;
		try {
			po = hotelDataHelper.getHotelInfo("00000001");
		} catch (RemoteException e) {
			fail("RemoteException");
			e.printStackTrace();
		}
		assertNotNull(po);
		assertEquals(po.getHotelID(), "00000001");
		assertEquals(po.getHotelName(), "锦都金鼎大酒店");
		assertEquals(po.getRegion(), "如皋市");
		assertEquals(po.getBusinessDistrict(), "如城街道");
	}
	
	@Test
	public void testFindHotelByCondition() {
		// TODO
	}
	
	@Test
	public void testChangeHotelInfo() {
		HotelPO po = new HotelPO();
		po.setHotelID("00000001");
		po.setHotelName("锦都金鼎大酒店");
		po.setAddress("市政府对面");
		po.setRegion("如皋市");
		po.setBusinessDistrict("如城街道");
		
		ResultMessage_Hotel res = hotelDataHelper.changeHotelInfo(po);
		assertEquals(res, ResultMessage_Hotel.Change_Successful);
		
		String newAdress = null;
		try {
			newAdress = hotelDataHelper.getHotelInfo("00000001").getAddress();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertNotNull(newAdress);
		assertEquals(newAdress, "市政府对面");
	}
	
	@Test
	public void testEvaluate() {
		HotelEvaluationPO po = new HotelEvaluationPO();
		po.setClientID("00000001");
		po.setClientID("0000000000000001");
		po.setEvaluateTime("2016/11/27 00:15:30");
		po.setEvaluateScore(3);
		po.setEvaluateInfo("测试评论");
		
		hotelDataHelper.evaluate(po);
		double newScore = 0;
		try {
			newScore = hotelDataHelper.getHotelInfo("00000001").getScore();
		} catch (RemoteException e) {
			fail("RemoteException");
			e.printStackTrace();
		}
		if(newScore != 3.75)
			fail();
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
		
		hotelDataHelper.addHotel(po);
		
		HotelPO res = null;
		try {
			res = hotelDataHelper.getHotelInfo("11111111");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertNotNull(res);
		assertEquals("11111111", res.getHotelID());
		assertEquals("测试宾馆", res.getHotelName());
	}
	
	@Test
	public void testGetHotelEvaluation() {
		Iterator<HotelEvaluationPO> it = null;
		try {
			it = hotelDataHelper.getHotelEvaluation("00000001");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		assertNotNull(it);
		assertEquals("测试评论", it.next().getEvaluateInfo());
	}
	
}







