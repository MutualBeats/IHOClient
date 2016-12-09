/**
 * @author huangxiao
 * @version 2016年12月7日
 */
package bussinesslogic.orderbl;

import util.exception.NetException;

public interface HotelInfo {
	
	public String getBusinessDistrict(String hotelID) throws NetException;
	
}
