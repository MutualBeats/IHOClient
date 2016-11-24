package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.MemberType;
import util.ResultMessage_For_Stub;
import vo.user.ClientVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class UserBLService_Driver {
	public void drive(UserBLService userBLService){
		ResultMessage_For_Stub result;
		
		/*
		 * 获取用户信息
		 */
		ClientVO vo1 = userBLService.showClientData("0000000001");
		System.out.println(vo1.clientID);
		System.out.println(vo1.clientName);
		System.out.println(vo1.credit);
		System.out.println(vo1.contactWay);
		/*
		 * 修改用户信息
		 */
		result = userBLService.changeClientData(new ClientVO("123456789", "admin", "1234567890",100, MemberType.Ordinary, 2, "腾讯企业"));
		if(result==ResultMessage_For_Stub.ChangeSuccess)
			System.out.println("Change successfully");
		else
			System.out.println("Change failed");
		/*
		 * 获取酒店工作人员信息
		 */
		StaffVO vo2 = userBLService.showStaffData("0000000001");
		System.out.println(vo2.staffID);
		System.out.println(vo2.staffname);
		System.out.println(vo2.hotelname);
		/*
		 * 修改酒店工作人员信息
		 */
		result = userBLService.changeStaffData(new StaffVO("0000000001", "admin", "hotel","12345678"));
		if(result==ResultMessage_For_Stub.ChangeSuccess)
			System.out.println("Change successfully");
		else
			System.out.println("Change failed");
		/*
		 * 获取网站营销人员信息
		 */
		MarketerVO vo3 = userBLService.showMarketerData("0000000001");
		System.out.println(vo3.marketerID);
		System.out.println(vo3.marketername);
		System.out.println(vo3.tel_number);
		/*
		 * 修改网站营销人员信息
		 */
		result = userBLService.changeMarketerData(new MarketerVO("0000000001", "admin", "123456789"));
		if(result==ResultMessage_For_Stub.ChangeSuccess)
			System.out.println("Change successfully");
		else
			System.out.println("Change failed");
		/*
		 * 添加网站营销人员
		 */
		result = userBLService.addMarketer(new MarketerVO("0000000001", "admin", "123456789"));
		if(result==ResultMessage_For_Stub.ChangeSuccess)
			System.out.println("Add successfully");
		else
			System.out.println("Add failed");
		/*
		 * 添加酒店工作人员
		 */
		result = userBLService.addStaff(new StaffVO("0000000001", "admin", "Hotel","12345678"));
		if(result==ResultMessage_For_Stub.ChangeSuccess)
			System.out.println("Add successfully");
		else
			System.out.println("Add failed");
		/*
		 * 用户登录
		 */
		result = userBLService.Login("0000000001", "123456");
		if(result==ResultMessage_For_Stub.ChangeSuccess)
			System.out.println("Login successfully");
		else
			System.out.println("Login failed");
		/*
		 * 注册新用户
		 */
		result = userBLService.Signup(new ClientVO("123456789", "admin", "1234567890",100, MemberType.Ordinary, 2, "腾讯企业"));
		if(result==ResultMessage_For_Stub.ChangeSuccess)
			System.out.println("Signup successfully");
		else
			System.out.println("Signup failed");
		
		ClientVO vo5=new ClientVO("123456789", "admin", "1234567890",100, MemberType.Ordinary, 2, "腾讯企业");
		ClientVO vo4=new ClientVO("123456789", "admin", "1234567890",100, MemberType.Ordinary, 2, "腾讯企业");
		
			result=userBLService.businessRegister(vo5);
			System.out.println(result.toString());
			
			result=userBLService.originalRegister(vo4);
			System.out.println(result.toString());
			
			userBLService.get("1234567890", vo5);
			
			userBLService.levelLook("1234567891", vo4);
			
			ArrayList<Integer> levelList = new ArrayList<>();
			levelList.add(20);
			levelList.add(1);
			userBLService.levelUpdate(levelList, 20);
		
	
	}
	
}

