/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMessage_For_Stub;
import util.SearchCondition;
import vo.HotelEvaluationVO;
import vo.HotelVO;

public interface HotelBLService {

	/**
	 * 显示酒店信息
	 */
	public HotelVO showHotelData (String hotelID);
	
	/**
	 * 修改酒店信息
	 */
	public ResultMessage_For_Stub changeHotelData (HotelVO vo);
	
	/**
	 * 显示酒店列表
	 */
	public ArrayList<HotelVO> showHotelListData  (SearchCondition sc);
	
	/**
	 * 显示酒店评价列表
	 */
	public ArrayList<HotelEvaluationVO> showHotelEvaluationListData(String hotelID);
	
	/**
	 * 评价酒店
	 */
	public ResultMessage_For_Stub evaluateHotel (HotelEvaluationVO vo);
	
	/**
	 * 添加酒店
	 */
	public ResultMessage_For_Stub addHotel (HotelVO vo);
	
}
