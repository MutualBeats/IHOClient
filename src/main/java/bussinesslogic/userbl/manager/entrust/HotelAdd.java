package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;

import util.resultmessage.ResultMessage_Hotel;
import vo.hotel.HotelVO;

public interface HotelAdd {
	/*
	 * 添加酒店
	 */
	public ResultMessage_Hotel addHotel(HotelVO vo) throws RemoteException;
}
