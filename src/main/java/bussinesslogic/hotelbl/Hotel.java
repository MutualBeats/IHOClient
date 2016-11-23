/**
 * @author huangxiao
 * 2016年11月6日
 */
package bussinesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.HotelDataHelper;
import po.HotelPO;
import util.ResultMessage_For_Stub;
import util.SearchCondition;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public class Hotel {
	
	private HotelPO hotelPO = null;
	private HotelDataHelper hotel_data_service; 
	
	public Hotel() {
		try {
			hotel_data_service = DataHelperFactory.getDataFactoryHelperInstance().getHotelDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public HotelVO showHotelData(String hotelID) {
		if(hotelPO == null || !hotelPO.getHotelID().equals(hotelID)) {
			//Update Hotel Info
			hotelPO = hotel_data_service.getHotelInfo(hotelID);
		}
		//Return the copy
		HotelVO hotelInfo = new HotelVO(hotelPO);
		return hotelInfo;
	}

	public ResultMessage_For_Stub changeHotelData(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HotelVO> showHotelListData(SearchCondition sc) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<HotelEvaluationVO> showHotelEvaluationListData(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ResultMessage_For_Stub evaluateHotel(HotelEvaluationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_For_Stub addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
