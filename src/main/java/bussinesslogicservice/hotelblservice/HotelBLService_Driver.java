/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.hoteldataservice.ResultMessage_Hotel;
import util.SearchCondition;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

public class HotelBLService_Driver {

	public void drive(HotelBLService hotelBLService) {
		HotelVO vo1 = new HotelVO("00000001", "锦都金鼎大酒店", "如皋市如城镇解放路(如皋市政府对面)", "如皋市", "如城街道", 5, 4.5);
		ResultMessage_Hotel result;
		result = hotelBLService.addHotel(vo1);
		if (result == ResultMessage_Hotel.Hotel_Not_Exist)
			System.out.println("Add succeed!\n");
		else
			System.out.println("Hotel exist\n");

		try {
			vo1 = hotelBLService.showHotelInfo("00000001");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(vo1.hotelName + '\t' + vo1.address + '\t' + vo1.starLevel + '\t' + vo1.score + '\n');

		vo1 = new HotelVO("00000001", "锦都金鼎大酒店", "如皋市如城镇解放路(如皋市政府对面)", "如皋市", "如城街道", 5, 4.5);
		result = hotelBLService.changeHotelInfo(vo1);
		if (result == ResultMessage_Hotel.Change_Successful)
			System.out.println("Hotel exists\n");
		else
			System.out.println("Change Succeed\n");

		SearchCondition sc = new SearchCondition(null, "如皋市", "如城街道", "锦都金鼎大酒店", 0, 0);
		ArrayList<HotelVO> hotelList = null;
		try {
			hotelList = hotelBLService.getHotelsSatisfyCondition(sc);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (HotelVO hotelVO : hotelList)
			System.out.println(hotelVO.hotelName + '\t' + hotelVO.address + '\t' + hotelVO.starLevel + '\t'
					+ hotelVO.score + '\n');

		HotelEvaluationVO vo2 = new HotelEvaluationVO("00000001", "丁二玉", "2016/10/16", 5, "强，无敌！");
		result = hotelBLService.evaluate(vo2);
		if (result == ResultMessage_Hotel.Evaluate_Successful)
			System.out.println("Evaluate succeed!\n");
		else
			System.out.println("Hotel doesn't exists!\n");
	}

}
