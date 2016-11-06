package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import po.MemberPO;
import util.ResultMessage;
import vo.ClientVO;
import vo.MarketerVO;
import vo.MemberVO;
import vo.StaffVO;

public class UserBLService_Stub implements UserBLService{
	
	public String ClientID;
	public String clientname;
	public String client_tel_number;
	public int credit;
	
	public String staffID;
	public String staffname;
	public String hotelname;
	
	public String marketerID;
	public String marketername;
	public String marketer_tel_number;
	
	public UserBLService_Stub(String ClientID,String clientname,String client_tel_number,int credit,
								String staffID,String staffname,String hotelname, 
								String marketerID,String marketername,String marketer_tel_number){
		this.ClientID = ClientID;
		this.clientname = clientname;
		this.client_tel_number = client_tel_number;
		this.credit = credit;
		this.staffID = staffID;
		this.staffname = staffname;
		this.hotelname = hotelname;
		this.marketerID = marketerID;
		this.marketername = marketername;
		this.marketer_tel_number = marketer_tel_number;
		}

	@Override
	public ClientVO showClientData(String clientID) {
		return new ClientVO("0000000001", "admin", "123456789", 100, new ArrayList<String>());
	}

	@Override
	public ResultMessage changeClientData(ClientVO vo) {
		if(vo.clientID=="0000000001")
			return ResultMessage.ChangeSuccess;
		else
			return ResultMessage.ChangeFail;
	}

	@Override
	public StaffVO showStaffData(String staffID) {
		return new StaffVO("0000000001", "admin", "hotel","12345678");
	}

	@Override
	public ResultMessage changeStaffData(StaffVO vo) {
		if(vo.staffID=="0000000001")
			return ResultMessage.ChangeSuccess;
		else
			return ResultMessage.ChangeFail;
	}

	@Override
	public MarketerVO showMarketerData(String marketerID) {
		return new MarketerVO("0000000001", "admin", "123456789");
	}

	@Override
	public ResultMessage changeMarketerData(MarketerVO vo) {
		if(vo.marketerID=="0000000001")
			return ResultMessage.ChangeSuccess;
		else
			return ResultMessage.ChangeFail;
	}

	@Override
	public ResultMessage addMarketer(MarketerVO vo) {
		return ResultMessage.ChangeSuccess;
	}

	@Override
	public ResultMessage addStaff(StaffVO vo) {
		return ResultMessage.ChangeSuccess;
	}

	@Override
	public ResultMessage Login(String ID, String password) {
		return ResultMessage.ChangeSuccess;
	}

	@Override
	public ResultMessage Signup(ClientVO vo) {
		return ResultMessage.ChangeSuccess;
	}
	@Override
	public ResultMessage businessRegister (MemberVO vo){
		if(vo.memberMessage.equals("腾讯企业"))
			return ResultMessage.RegisterSuccess;
		else 
			return ResultMessage.RegisterFail;
	}
	@Override
	public ResultMessage originalRegister (MemberVO vo){
		if(vo.memberMessage.equals("1997.01.01"))
			return ResultMessage.RegisterSuccess;
		else 
			return ResultMessage.RegisterFail;
	}
	@Override
	public void levelLook (String name,MemberVO vo){
		if(name.equals(vo.memberID))
			 System.out.println("The level is "+ vo.level);;
	}
	
	@Override
	public MemberPO get(String name,MemberVO vo) {
		// TODO Auto-generated method stub
		if(name.equals(vo.memberID))
			return new MemberPO(name,"腾讯企业",2);
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
	public MemberPO update(String name,MemberVO vo) {
		// TODO Auto-generated method stub
		if(name.equals(vo.memberID))
			return new MemberPO(name,"腾讯企业",2);
		else
			return null;
	}
}