/**
 * @author huangxiao
 * @version 2016年12月23日
 */
package bussinesslogic.promotionbl;

import util.exception.NetException;

public interface MemberLevelGet {
	
	public int getLevelInfo(int credit) throws NetException;

}
