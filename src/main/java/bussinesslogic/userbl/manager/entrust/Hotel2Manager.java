package bussinesslogic.userbl.manager.entrust;

import dataservice.hoteldataservice.ResultMessage_Hotel;
import vo.hotel.HotelVO;

public interface Hotel2Manager {
	/*
	 * 添加酒店
	 */
	public ResultMessage_Hotel addHotel(HotelVO vo);
}
