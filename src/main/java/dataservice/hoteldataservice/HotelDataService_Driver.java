/**
 * @author huangxiao
 */
package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.hotel.HotelEvaluationPO;
import po.hotel.HotelPO;
import util.Time;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;
import util.room.RoomType;

public class HotelDataService_Driver {
	
	public void drive(HotelDataService hotelDataService) throws RemoteException {
		ResultMessage_Hotel result;
		
		// 添加酒店
		HotelPO hotelPO = new HotelPO();
		hotelPO.setHotelName("测试酒店");
		hotelPO.setRegion("江苏省 南通市 如皋市");
		hotelPO.setBusinessDistrict("如城商圈");
		hotelPO.setAddress("测试地址");
		hotelPO.setScore(5);
		hotelPO.setStarLevel(5);
		
		String hotelID = hotelDataService.addHotel(hotelPO);
		System.out.println("Generate hotelID: " + hotelID);
		hotelPO.setHotelID(hotelID);
		
		// 评价酒店
		HotelEvaluationPO evaluationPO = new HotelEvaluationPO();
		evaluationPO = new HotelEvaluationPO();
		evaluationPO.setClientID("huangxiao");
		evaluationPO.setHotelID("00000001");
		evaluationPO.setOrderID("0000000000000001");
		evaluationPO.setEvaluateTime(Time.getCurrentTime());
		evaluationPO.setEvaluateScore(3);
		evaluationPO.setEvaluateInfo("测试评价");
		
		result = hotelDataService.evaluation(evaluationPO);
		System.out.println(result.toString());
		
		// 更改酒店信息
		hotelPO.setAddress("测试修改酒店信息");
		result = hotelDataService.changeHotelInfo(hotelPO);
		System.out.println(result.toString());
		
		// 获取酒店信息
		hotelPO = hotelDataService.getHotelInfo("00000001");
		System.out.println("Hotel Name: " + hotelPO.getHotelName());
		
		// 搜索酒店
		SearchCondition sc = new SearchCondition("huangxiao", "江苏省 南通市 如皋市", "如城商圈", null, -1, -1, null, null, -1, Integer.MAX_VALUE, RoomType.ALL, false);
		ArrayList<HotelPO> hotelList = hotelDataService.findHotelByCondition(sc);
		System.out.println("Search" + hotelList.size() + "results");
		
		// 获取酒店评价
		ArrayList<HotelEvaluationPO> evaluations = hotelDataService.getHotelEvaluation("00000001");
		System.out.println("Find " + evaluations.size() + "evaluations");
		
	}

}
