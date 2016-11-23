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
import util.SearchCondition;
import util.result_message.hotel.ResultMessage_HotelBLService;
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
	
	/**
	 * 获得酒店信息
	 * 
	 * @param hotelID
	 * @return
	 */
	public HotelVO showHotelData(String hotelID) {
		if(hotelPO == null || !hotelPO.getHotelID().equals(hotelID)) {
			//Update Hotel Info
			hotelPO = hotel_data_service.getHotelInfo(hotelID);
		}
		//Return the copy
		HotelVO hotelInfo = new HotelVO(hotelPO);
		return hotelInfo;
	}

	public ResultMessage_HotelBLService changeHotelData(HotelVO vo) {
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
	
	public ResultMessage_HotelBLService evaluateHotel(HotelEvaluationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_HotelBLService addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
