/**
 * @author huangxiao
 * @author Saltwater
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
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

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
	public HotelVO showHotelInfo(String hotelID) {
		if (hotelPO == null || !hotelPO.getHotelID().equals(hotelID)) {
			// Update Hotel Info
			hotelPO = hotel_data_service.getHotelInfo(hotelID);
		}
		// Return the copy
		HotelVO hotelInfo = new HotelVO(hotelPO);
		return hotelInfo;
	}

	/**
	 * Change The Hotel Info
	 * 
	 * @param vo : Satisfy the format
	 * @return operation result
	 */
	public ResultMessage_HotelBLService changeHotelInfo(HotelVO vo) {
		HotelPO po = new HotelPO(vo);
		// Update local cache:
		this.hotelPO = po;
		return hotel_data_service.changeHotelInfo(po);
	}

	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) {
		return null;
	}

	public ArrayList<HotelEvaluationVO> getHotelEvalutions(String hotelID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_HotelBLService evaluate(HotelEvaluationVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage_HotelBLService addHotel(HotelVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 检测本地Hotel缓存是否所需
	 * 
	 * @author Saltwater
	 * @param hotelID
	 * @return
	 */
	private boolean checkHotelMatch(String hotelID) {
		return hotelPO != null && hotelPO.getHotelID().equals(hotelID);
	}

}
