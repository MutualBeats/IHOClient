/**
 * @author huangxiao
 */
package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.user.StaffChangePO;
import po.user.StaffPO;
import util.resultmessage.ResultMessage_User;

public class StaffDataService_Driver {
	
	public void driver(StaffDataService staffDataService) throws RemoteException {
		ResultMessage_User result;
		
		// 添加人员
		StaffPO staff = new StaffPO("TestStaff", "staff", "12345678900", "00000001");
		staffDataService.insert(staff, "12345678");
		
		// 获取酒店工作人员信息
		staff = staffDataService.findData("TestStaff");
		System.out.println(staff.getStaffName() + " " + staff.getContactWay());
		
		// 更新信息
		StaffChangePO changePO = new StaffChangePO("TestStaff", "staff", "98765432100");
		result = staffDataService.updateData(changePO);
		System.out.println("Change result: " + result);
		
		// 获取所有酒店工作人员
		ArrayList<StaffPO> staffs = staffDataService.getStaffList();
		System.out.println("Total staff number: " + staffs.size());
		
	}

}
