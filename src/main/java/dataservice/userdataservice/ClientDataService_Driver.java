/**
 * @author huangxiao
 */
package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.user.ClientInfoChangePO;
import po.user.ClientPO;
import po.user.ClientRegistPO;
import po.user.MemberPO;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;

public class ClientDataService_Driver {
	
	public void driver(ClientDataService clientDataService) throws RemoteException {
		ResultMessage_User result;
		
		// 注册
		ClientRegistPO clientRegistPO = new ClientRegistPO("TestClient", "test", "12345678900", "12345678");
		result = clientDataService.regist(clientRegistPO);
		System.out.println("Register result: " + result);
		
		// 查询用户
		ClientPO client = clientDataService.queryClient("huangxiao");
		System.out.println(client.getClientName());
		
		// 更新用户信息
		ClientInfoChangePO changePO = new ClientInfoChangePO("huangxiao", "huangxiao", "12345678999");
		result = clientDataService.updateClientInfo(changePO);
		System.out.println("Change Result: " + result);
		
		// 注册会员
		MemberPO memberPO = new MemberPO("huangxiao", MemberType.Ordinary, 0, "1997/10/14");
		result = clientDataService.registerMember(memberPO);
		System.out.println("Regist member result: " + result);
		
		// 获取所有客户信息
		ArrayList<ClientPO> clients = clientDataService.getClientList();
		System.out.println("Total client number: " + clients.size());
		
	}

}
