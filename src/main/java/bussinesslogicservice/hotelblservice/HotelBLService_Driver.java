/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMessage;
import util.SearchCondition;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class HotelBLService_Driver {
	
	public void drive(HotelBLService hotelBLService) {
		HotelVO vo1 = new HotelVO("00000001", "锦都金鼎大酒店", "如皋市如城镇解放路(如皋市政府对面)", "如皋市", "如城街道", 5, 4.5);
		ResultMessage result;
		result = hotelBLService.addHotel(vo1);
		if(result == ResultMessage.HotelNotExist)
			System.out.println("Add succeed!\n");
		else
			System.out.println("Hotel exist\n");
		
		vo1 = hotelBLService.showHotelData("00000001");
		System.out.println(vo1.hotelName + '\t'  + vo1.address + '\t' + vo1.starLevel + '\t' + vo1.score + '\n');
		
		vo1 = new HotelVO("00000001", "锦都金鼎大酒店", "如皋市如城镇解放路(如皋市政府对面)", "如皋市", "如城街道", 5, 4.5);
		result = hotelBLService.changeHotelData(vo1);
		if(result == ResultMessage.HotelExist)
			System.out.println("Hotel exists\n");
		else
			System.out.println("Change Succeed\n");
		
		SearchCondition sc = new SearchCondition(null, "如皋市", "如城街道", "锦都金鼎大酒店", 0, 0);
		ArrayList<HotelVO> hotelList = hotelBLService.showHotelListData(sc);
		for (HotelVO hotelVO : hotelList)
			System.out.println(hotelVO.hotelName + '\t'  + hotelVO.address + '\t' + hotelVO.starLevel + '\t' + hotelVO.score + '\n');
		
		HotelEvaluationVO vo2 = new HotelEvaluationVO("00000001", "丁二玉", "2016/10/16", 5, "强，无敌！");
		result = hotelBLService.evaluateHotel(vo2);
		if(result == ResultMessage.EvaluateSuccess)
			System.out.println("Evaluate succeed!\n");
		else 
			System.out.println("Hotel doesn't exists\n");
	}

}
