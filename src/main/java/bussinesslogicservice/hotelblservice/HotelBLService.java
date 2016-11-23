/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.util.ArrayList;

import util.SearchCondition;
import util.result_message.hotel.ResultMessage_HotelBLService;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

public interface HotelBLService {

	/**
	 * 显示酒店信息
	 */
	public HotelVO showHotelInfo(String hotelID);

	/**
	 * 修改酒店信息
	 */
	public ResultMessage_HotelBLService changeHotelInfo(HotelVO vo);

	/**
	 * 显示酒店列表
	 */
	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc);

	/**
	 * 显示酒店评价列表
	 */
	public ArrayList<HotelEvaluationVO> getHotelEvalutions(String hotelID);

	/**
	 * 评价酒店
	 */
	public ResultMessage_HotelBLService evaluate(HotelEvaluationVO vo);

	/**
	 * 添加酒店
	 */
	public ResultMessage_HotelBLService addHotel(HotelVO vo);

}
