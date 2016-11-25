/**
 * @author huangxiao
 * 2016年10月16日
 */
package bussinesslogicservice.hotelblservice;

import java.util.ArrayList;
import java.util.Iterator;

import dataservice.hoteldataservice.ResultMessage_Hotel;
import util.SearchCondition;
import vo.hotel.HotelEvaluationVO;
import vo.hotel.HotelVO;

public class HotelBLService_Stub implements HotelBLService {

	public String hotelID;
	public String hotelName;
	public String address;
	public String region;
	public String businessDistrict;
	public int starLevel;
	public double score;

	/**
	 * 构造方法
	 * @param hotelID
	 * @param hotelName
	 * @param address
	 * @param region
	 * @param businessDistrict
	 * @param starLevel
	 * @param score
	 */
	public HotelBLService_Stub(String hotelID, String hotelName, String address, String region, String businessDistrict,
			int starLevel, double score) {
		super();
		this.hotelID = hotelID;
		this.hotelName = hotelName;
		this.address = address;
		this.region = region;
		this.businessDistrict = businessDistrict;
		this.starLevel = starLevel;
		this.score = score;
	}

	@Override
	public HotelVO showHotelInfo(String hotelID) {
		HotelVO vo = new HotelVO(hotelID, hotelName, address, region, businessDistrict, starLevel, score);
		return vo;
	}

	@Override
	public ResultMessage_Hotel changeHotelInfo(HotelVO vo) {
		if(vo.hotelID.equals("00000001"))
			return ResultMessage_Hotel.Change_Successful;
		else return ResultMessage_Hotel.Hotel_Not_Exist;
	}

	@Override
	public ArrayList<HotelVO> getHotelsSatisfyCondition(SearchCondition sc) {
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		HotelVO vo = new HotelVO(hotelID, sc.hotelName == null ? hotelName : sc.hotelName,
					address, sc.region, sc.businessDistrict, sc.starLevel > 0 ? sc.starLevel : starLevel,
						sc.score > 0 ? sc.score : score);
		hotelList.add(vo);
		return hotelList;
	}

	@Override
	public ResultMessage_Hotel evaluate(HotelEvaluationVO vo) {
		if(vo.hotelID.equals("00000001"))
			return ResultMessage_Hotel.Evaluate_Successful;
		else return ResultMessage_Hotel.Hotel_Not_Exist;
	}

	@Override
	public ResultMessage_Hotel addHotel(HotelVO vo) {
		if(vo.hotelID.equals("00000001"))
			return ResultMessage_Hotel.Evaluate_Successful;
		else return ResultMessage_Hotel.Hotel_Not_Exist;
	}

	@Override
	public Iterator<HotelEvaluationVO> getHotelEvalutions(String hotelID) {
		return null;
	}

}
