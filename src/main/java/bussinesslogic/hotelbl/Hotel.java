/**
 * @author huangxiao
 * @author Saltwater
 * 2016年11月6日
 */
package bussinesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.hoteldataservice.ResultMessage_Hotel;
import factory.datahelper.DataHelperFactory;
import factory.datahelper.HotelDataHelper;
import po.HotelEvaluationPO;
import po.HotelPO;
import util.SearchCondition;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

/**
 * @author Saltwater
 * @version 2.0
 */
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
	 * @throws RemoteException
	 *             ： Net Error. Please Check Your Internet
	 */
	public HotelVO showHotelInfo(String hotelID) throws RemoteException {
		if (!checkHotelMatch(hotelID)) {
			// Update Hotel Info
			hotelPO = hotel_data_service.getHotelInfo(hotelID);
		}
		// Return the copy
		HotelVO hotelInfo = new HotelVO(hotelPO);
		return hotelInfo;
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

	/**
	 * Change The Hotel Info
	 * 
	 * @param vo
	 *            : Satisfy the format
	 * @return operation result
	 */
	public ResultMessage_Hotel changeHotelInfo(HotelVO vo) {
		HotelPO po = new HotelPO(vo);
		ResultMessage_Hotel result = hotel_data_service.changeHotelInfo(po);
		return result;
	}

	/**
	 * @param sc
	 *            Search Condition
	 * @return
	 * @throws RemoteException
	 *             : Net Exception
	 */
	public Iterator<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) throws RemoteException {
		ArrayList<HotelVO> hotels = new ArrayList<>();
		Iterator<HotelPO> iterator = hotel_data_service.findHotelByCondition(sc);
		while (iterator.hasNext()) {
			HotelVO each = new HotelVO(iterator.next());
			hotels.add(each);
		}
		return hotels.iterator();
	}

	/**
	 * 获取酒店评价
	 * 
	 * @author Saltwater
	 * @param hotelID
	 * @return 酒店评价迭代器
	 * @throws RemoteException
	 *             : Net Error
	 */
	public Iterator<HotelEvaluationVO> getHotelEvalutions(String hotelID) throws RemoteException {
		Iterator<HotelEvaluationPO> iterator = hotel_data_service.getHotelEvaluation(hotelID);
		ArrayList<HotelEvaluationVO> evaluationVOs = new ArrayList<>();
		while (iterator.hasNext()) {
			HotelEvaluationVO each = new HotelEvaluationVO(iterator.next());
			evaluationVOs.add(each);
		}
		return evaluationVOs.iterator();
	}

	/**
	 * 评价酒店
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage_Hotel evaluate(HotelEvaluationVO vo) {
		return hotel_data_service.evaluate(new HotelEvaluationPO(vo));
	}

	/**
	 * 添加酒店
	 * 
	 * @param vo
	 * @return
	 */
	public ResultMessage_Hotel addHotel(HotelVO vo) {
		return hotel_data_service.addHotel(new HotelPO(vo));
	}

}
