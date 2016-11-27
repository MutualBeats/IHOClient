package bussinesslogic.usebl.staff;

import java.rmi.RemoteException;

import dataservice.userdataservice.StaffDataService;
import factory.datahelper.DataHelperFactory;
import po.user.StaffPO;
import util.LengthOfID;
import util.ResultMessage_For_User;
import vo.user.StaffVO;

public class Staff {
	
	private StaffDataService staffDataService;
	
	public Staff(){
		try {
			staffDataService = DataHelperFactory.getDataFactoryHelperInstance().getStaffDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_For_User Login(String staffID, String password) {
		if(staffID.length()!=LengthOfID.getUserID())
			return ResultMessage_For_User.UserID_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = staffDataService.find(staffID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	/* 
	 * Return null:
	 * 	UserID Invalid
	 * 	Account Not Exist
	 * */
	public StaffVO showData(String staffID) {
		if(staffID.length()!=LengthOfID.getUserID())
			return null;
		
		StaffPO po = new StaffPO();
		try {
			po = staffDataService.findData(staffID);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.GetDataFail);
			e.printStackTrace();
		}
		
		if(po==null)
			return null;
		
		StaffVO vo;
		vo = new StaffVO(po.getStaffID(),po.getStaffname(),po.getHotelId());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	/*
	 * UserName Invalid
	 */
	public ResultMessage_For_User changeData(StaffVO vo) {
		int len = vo.staffname.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_For_User.UserName_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		StaffPO po = new StaffPO();
		po.setStaffID(vo.staffID);
		po.setStaffname(vo.staffname);
		po.setHotelId(vo.hotelId);
		try {
			result = staffDataService.updateData(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * UserID Invalid
	 * UserName Invalid
	 * 
	 * Hotel Not Exist
	 * Hotel Have Staff
	 * Account Exist
	 */
	public ResultMessage_For_User addStaff(StaffVO vo, String password) {
		if(vo.staffID.length()!=LengthOfID.getUserID())
			return ResultMessage_For_User.UserID_Invalid;
		
		int len = vo.staffname.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_For_User.UserName_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		StaffPO po = new StaffPO();
		po.setStaffID(vo.staffID);
		po.setStaffname(vo.staffname);
		po.setHotelId(vo.hotelId);
		try {
			result = staffDataService.insert(po, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
}
