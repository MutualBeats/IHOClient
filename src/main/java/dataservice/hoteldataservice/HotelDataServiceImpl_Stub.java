/**
 * @author huangxiao
 * 2016年10月16日
 */
package dataservice.hoteldataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluationPO;
import po.HotelPO;
import util.ResultMessage_For_Stub;
import util.SearchCondition;

public class HotelDataServiceImpl_Stub implements HotelDataService {

	@Override
	public HotelPO findHotelData(String hotelID) throws RemoteException {
		System.out.println("Find Succeed!\n");
		HotelPO po = new HotelPO(hotelID, "锦都金鼎大酒店", "如皋市如城镇解放路(如皋市政府对面)", "如皋市", "如城街道", 5, 4.5);
		return po;
	}

	@Override
	public ArrayList<HotelPO> findHotelListData(SearchCondition sc) throws RemoteException {
		System.out.println("Find Succeed!\n");
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		HotelPO po = new HotelPO("00000001", sc.hotelName == null ? "锦都金鼎大酒店" : sc.hotelName,
					"如皋市如城镇解放路(如皋市政府对面)", sc.region, sc.businessDistrict, sc.starLevel > 0 ? sc.starLevel : 5,
						sc.score > 0 ? sc.score : 4.5);
		hotelList.add(po);
		return hotelList;
	}

	@Override
	public ResultMessage_For_Stub updateHotelData(HotelPO po) throws RemoteException {
		System.out.println("Update Hotel Data Succeed!\n");
		return ResultMessage_For_Stub.UpdateSucceed;
	}

	@Override
	public ResultMessage_For_Stub insertHotelEvaluation(HotelEvaluationPO po) throws RemoteException {
		System.out.println("Insert Hotel Evaluation Succeed!\n");
		return ResultMessage_For_Stub.InsertSucceed;
	}

	@Override
	public ResultMessage_For_Stub insertHotel(HotelPO po) throws RemoteException {
		System.out.println("Insert Hotel Succeed!");
		return ResultMessage_For_Stub.InsertSucceed;
	}

	@Override
	public ArrayList<HotelEvaluationPO> findHotelEvaluation(String hotelID) throws RemoteException {
		return null;
	}

}
