/**
 * @author huangxiao
 * 2016年11月6日
 */
package hotelbl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bussinesslogic.hotelbl.Hotel;
import util.ResultMessage;
import util.SearchCondition;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class HotelBlTest {

	HotelVO vo1;
	HotelEvaluationVO vo2;
	Hotel hotel;
	
	@Before
	public void init() {
		vo1 = new HotelVO("00000001", "锦都金鼎大酒店", "如皋市如城镇解放路(如皋市政府对面)", "如皋市", "如城街道", 5, 4.5);
		vo2 = new HotelEvaluationVO("00000001", "丁二玉", "2016/10/16", 5, "强，无敌！");
		hotel = new Hotel();
	}
	
	
	@Test
	public void testAddHotelData() {
		assertEquals(ResultMessage.HotelNotExist, hotel.addHotel(vo1));
	}
	
	@Test
	public void testShowHotelData() {
		HotelVO vo = hotel.showHotelData("00000001");
		assertEquals(vo1.hotelName, vo.hotelName);
	}
	
	@Test
	public void testChangeHotelData() {
		assertEquals(ResultMessage.HotelExist, hotel.changeHotelData(vo1));
	}
	
	@Test
	public void testShowHotelListData() {
		SearchCondition sc = new SearchCondition(null, "如皋市", "如城街道", "锦都金鼎大酒店", 0, 0);
		ArrayList<HotelVO> hotelList = hotel.showHotelListData(sc);
		boolean contain = false;
		for (HotelVO hotelVO : hotelList) {
			if(hotelVO.hotelID == vo1.hotelID) {
				contain = true;
				break;
			}
		}
		assertEquals(true, contain);
	}
	
	@Test
	public void testEvaluateHotelData() {
		assertEquals(ResultMessage.EvaluateSuccess, hotel.evaluateHotel(vo2));
	}


}
