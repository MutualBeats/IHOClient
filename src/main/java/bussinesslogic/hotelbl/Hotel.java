/**
 * @author huangxiao
 * @author Saltwater
 * 2016年11月6日
 */
package bussinesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import factory.datahelper.DataHelperFactory;
import factory.datahelper.HotelDataHelper;
import po.hotel.HotelEvaluationPO;
import po.hotel.HotelPO;
import util.exception.NetException;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

/**
 * Hotel Logic Impl
 * 
 * Time : 2016/11/24
 * 
 * @author Saltwater
 * @version 3.0 :
 * 		构建界面层Cache 设计。接口更改。
 */
public class Hotel {

	private HotelPO hotelPO = null;
	private HotelDataHelper hotel_data_service;

	public Hotel() throws NetException {
		hotel_data_service = DataHelperFactory.getDataFactoryHelperInstance().getHotelDatabase();
	}

	/**
	 * 获得酒店信息
	 * 
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 *             ： Net Error. Please Check Your Internet
	 */
	public HotelVO showHotelInfo(String hotelID) throws NetException {
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
	 * @return Iterator of hotels
	 * @throws RemoteException
	 *             : Net Exception
	 */
	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) throws NetException {
		ArrayList<HotelVO> hotels = new ArrayList<>();
		Iterator<HotelPO> iterator = hotel_data_service.findHotelByCondition(sc);
		int count = 0;
		//Only choose part of data
		while (iterator.hasNext() && count++ < 50) {
			//Change hotel_po to hotel_vo
			HotelVO each = new HotelVO(iterator.next());
			hotels.add(each);
		}
		return hotels;
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
	public Iterator<HotelEvaluationVO> getHotelEvalutions(String hotelID) throws NetException {
		Iterator<HotelEvaluationPO> iterator = hotel_data_service.getHotelEvaluation(hotelID);
		ArrayList<HotelEvaluationVO> evaluationVOs = new ArrayList<>();
		int count = 0;
		//Only choose part of data
		while (iterator.hasNext()&& count++ < 50) {
			//Change evaluation_po to vo
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
	 * @throws NullPointerException 
	 * @throws RemoteException 
	 */
	public String addHotel(HotelVO vo) throws NetException {
		return hotel_data_service.addHotel(new HotelPO(vo));
	}

}
