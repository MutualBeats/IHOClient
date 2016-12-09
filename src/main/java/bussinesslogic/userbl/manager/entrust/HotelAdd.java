package bussinesslogic.userbl.manager.entrust;

import java.rmi.RemoteException;

import util.exception.NetException;
import vo.hotel.HotelVO;

public interface HotelAdd {
	/**
	 * 添加酒店
	 * @throws NullPointerException 
	 * @throws RemoteException 
	 */
	public String addHotel(HotelVO vo) throws NetException;
}
