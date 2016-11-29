package bussinesslogic.userbl.manager.entrust;

import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelVO;

public interface Hotel2Manager {
	/*
	 * 添加酒店
	 */
	public ResultMessage_Hotel addHotel(HotelVO vo);
}
