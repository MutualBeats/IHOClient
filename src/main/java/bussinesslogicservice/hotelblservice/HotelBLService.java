/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.util.ArrayList;

import util.SearchCondition;
import util.result_message.hotel.ResultMessage_HotelBLService;
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
	public ResultMessage_HotelBLService changeHotelData (HotelVO vo);
	
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
	public ResultMessage_HotelBLService evaluateHotel (HotelEvaluationVO vo);
	
	/**
	 * 添加酒店
	 */
	public ResultMessage_HotelBLService addHotel (HotelVO vo);
	
}
