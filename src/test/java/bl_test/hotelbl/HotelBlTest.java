/**
 * @author huangxiao
 * 2016年11月6日
 */
package bl_test.hotelbl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.hotelbl.Hotel;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelVO;

public class HotelBlTest {

	private HotelVO nullVO;
	private HotelVO vo1;
//	private HotelEvaluationVO vo2;
	private Hotel hotel;

	@Before
	public void init() {
		nullVO = new HotelVO("invalid", "invalid", "invalid", "invalid invalid invalid", "invalid", 0, 0);
		vo1 = new HotelVO("00000001", "锦都金鼎大酒店", "如皋市政府对面", "江苏省 南通市 如皋市", "如城商圈", 5, 0);
		try {
			hotel = new Hotel();
		} catch (NetException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddHotel() {
		
	}

	@Test
	public void testShowHotelData() {
		HotelVO vo = null;
		try {
			vo = hotel.showHotelInfo("00000001");
			assertEquals(vo1.hotelName, vo.hotelName);
			assertEquals(vo1.region, vo.region);
		} catch (NetException e) {
			System.err.println("Please check your Internet");
		}
	}

	@Test
	public void testChangeHotelData() {
		assertEquals(ResultMessage_Hotel.Hotel_Not_Exists, hotel.changeHotelInfo(nullVO));
		assertEquals(ResultMessage_Hotel.Change_Successful, hotel.changeHotelInfo(vo1));
	}

//	@Test
//	public void testShowHotelListData() {
//		SearchCondition sc = new SearchCondition(null, "如皋市", "如城街道", "锦都金鼎大酒店", 0, 0);
//		ArrayList<HotelVO> hotelList = null;
//		try {
//			hotelList = hotel.getHotelsSatisfyCondition(sc);
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		boolean contain = false;
//		for(HotelVO hotelVO : hotelList) {
//			if (hotelVO.hotelID == vo1.hotelID) {
//				contain = true;
//				break;
//			}
//		}
//		assertEquals(true, contain);
//	}

	@Test
	public void testEvaluateHotelData() {
		
	}

}
