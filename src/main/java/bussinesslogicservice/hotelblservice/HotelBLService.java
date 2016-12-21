/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.exception.NetException;
import util.hotel.SearchCondition;
import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

public interface HotelBLService {

	/**
	 * 显示酒店信息
	 * 
	 * @throws RemoteException
	 *             : Net Error
	 */
	public HotelVO showHotelInfo(String hotelID) throws NetException;

	/**
	 * 修改酒店信息
	 */
	public ResultMessage_Hotel changeHotelInfo(HotelVO vo);

	/**
	 * 显示酒店列表
	 * 
	 * @throws RemoteException
	 */
	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) throws NetException;

	/**
	 * 显示酒店评价列表
	 * 
	 * @throws RemoteException
	 */
	public ArrayList<HotelEvaluationVO> getHotelEvalutions(String hotelID) throws NetException;

	/**
	 * 评价酒店
	 */
	public ResultMessage_Hotel evaluate(HotelEvaluationVO vo);

}
