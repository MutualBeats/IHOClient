/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMessage;
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
	public ResultMessage changeHotelData (HotelVO vo);
	
	/**
	 * 显示酒店列表
	 */
	public ArrayList<HotelVO> showHotelListData  (SearchCondition sc);
	
	/**
	 * 评价酒店
	 */
	public ResultMessage evaluateHotel (HotelEvaluationVO vo);
	
	/**
	 * 添加酒店
	 */
	public ResultMessage addHotel (HotelVO vo);
	
}
