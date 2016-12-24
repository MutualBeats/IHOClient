/**
 * @author huangxiao
 */
package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.user.MarketerPO;
import util.resultmessage.ResultMessage_User;

public class MarketerDataService_Driver {
	
	public void driver(MarketerDataService marketerDataService) throws RemoteException {
		ResultMessage_User result;
		
		// 添加人员
		MarketerPO marketer = new MarketerPO("marketer", "marketer", "12345678900");
		result = marketerDataService.insert(marketer, "12345678");
		System.out.println("Insert result: " + result);
		
		// 获取人员信息
		marketer = marketerDataService.getMarketerInfo("marketer");
		System.out.println(marketer.getMarketerName() + " " + marketer.getContactWay());
		
		// 更新信息
		marketer.setContactWay("98765432100");
		result = marketerDataService.updateData(marketer);
		System.out.println("Change result: " + result);
	
		// 获取所有营销人员
		ArrayList<MarketerPO> marketers = marketerDataService.getMarketerList();
		System.out.println("Total marketer number: " + marketers.size());
		
	}

}
