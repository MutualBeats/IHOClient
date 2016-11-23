package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.ResultMessage_For_Stub;
import vo.ClientVO;
import vo.MarketerVO;
import vo.StaffVO;

public class UserBLService_Stub implements UserBLService{
	
	public String ClientID;
	public String clientname;
	public String client_tel_number;
	public int credit;
	public String memberID;
	public String memberMessage;
	public int level;
	
	public String staffID;
	public String staffname;
	public String hotelname;
	
	public String marketerID;
	public String marketername;
	public String marketer_tel_number;
	
	public UserBLService_Stub(String ClientID,String clientname,String client_tel_number,int credit,
								String memberID,String memberMessage, int level,
								String staffID,String staffname,String hotelname, 
								String marketerID,String marketername,String marketer_tel_number){
		this.ClientID = ClientID;
		this.clientname = clientname;
		this.client_tel_number = client_tel_number;
		this.credit = credit;
		this.memberID = memberID;
		this.memberMessage = memberMessage;
		this.level = level;
		this.staffID = staffID;
		this.staffname = staffname;
		this.hotelname = hotelname;
		this.marketerID = marketerID;
		this.marketername = marketername;
		this.marketer_tel_number = marketer_tel_number;
		}

	@Override
	public ClientVO showClientData(String clientID) {
		return new ClientVO("0000000001", "admin", "123456789", 100, "123456789","腾讯企业",2);
	}

	@Override
	public ResultMessage_For_Stub changeClientData(ClientVO vo) {
		if(vo.clientID=="0000000001")
			return ResultMessage_For_Stub.ChangeSuccess;
		else
			return ResultMessage_For_Stub.ChangeFail;
	}

	@Override
	public StaffVO showStaffData(String staffID) {
		return new StaffVO("0000000001", "admin", "hotel","12345678");
	}

	@Override
	public ResultMessage_For_Stub changeStaffData(StaffVO vo) {
		if(vo.staffID=="0000000001")
			return ResultMessage_For_Stub.ChangeSuccess;
		else
			return ResultMessage_For_Stub.ChangeFail;
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) {
		return new MarketerVO("0000000001", "admin", "123456789");
	}

	@Override
	public ResultMessage_For_Stub changeMarketerData(MarketerVO vo) {
		if(vo.marketerID=="0000000001")
			return ResultMessage_For_Stub.ChangeSuccess;
		else
			return ResultMessage_For_Stub.ChangeFail;
	}

	@Override
	public ResultMessage_For_Stub addMarketer(MarketerVO vo) {
		return ResultMessage_For_Stub.ChangeSuccess;
	}

	@Override
	public ResultMessage_For_Stub addStaff(StaffVO vo) {
		return ResultMessage_For_Stub.ChangeSuccess;
	}

	@Override
	public ResultMessage_For_Stub Login(String ID, String password) {
		return ResultMessage_For_Stub.ChangeSuccess;
	}

	@Override
	public ResultMessage_For_Stub Signup(ClientVO vo) {
		return ResultMessage_For_Stub.ChangeSuccess;
	}
	@Override
	public ResultMessage_For_Stub businessRegister (ClientVO vo){
		if(vo.memberMessage.equals("腾讯企业"))
			return ResultMessage_For_Stub.RegisterSuccess;
		else 
			return ResultMessage_For_Stub.RegisterFail;
	}
	@Override
	public ResultMessage_For_Stub originalRegister (ClientVO vo){
		if(vo.memberMessage.equals("1997.01.01"))
			return ResultMessage_For_Stub.RegisterSuccess;
		else 
			return ResultMessage_For_Stub.RegisterFail;
	}
	@Override
	public void levelLook (String name,ClientVO vo){
		if(name.equals(vo.memberID))
			 System.out.println("The level is "+ vo.level);;
	}
	
	@Override
	public ClientVO get(String name,ClientVO vo) {
		// TODO Auto-generated method stub
		if(name.equals(vo.memberID))
			return new ClientVO("123456789", "admin", "1234567890", 100, name,"腾讯企业",2);
		else 
			return null;
	}
	
	@Override
	public void levelUpdate(ArrayList<Integer> levelList,int level) {
		// TODO Auto-generated method stub
		int result=levelList.indexOf(level);
		System.out.println("Grade" + result);
	}
	
	@Override
	public ClientVO update(String name,ClientVO vo) {
		// TODO Auto-generated method stub
		if(name.equals(vo.memberID))
			return new ClientVO("123456789", "admin", "1234567890", 100, "123456789","腾讯企业",2);
		else
			return null;
	}
}
