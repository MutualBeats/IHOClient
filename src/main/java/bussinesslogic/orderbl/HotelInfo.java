/**
 * @author huangxiao
 * @version 2016年12月7日
 */
package bussinesslogic.orderbl;

import java.rmi.RemoteException;

public interface HotelInfo {
	
	public String getBusinessDistrict(String hotelID) throws RemoteException;
	
}
