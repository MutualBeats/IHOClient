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
	
	public Staff() throws RemoteException{
		staffDataService = DataHelperFactory.getDataFactoryHelperInstance().getStaffDatabase();
	}
	
	/*
	 * UserID Invalid
	 * 
	 * Account Not Exist
	 * Password Wrong
	 * */
	public ResultMessage_For_User Login(String staffID, String password) throws RemoteException {
		if(staffID.length()!=LengthOfID.getUserID())
			return ResultMessage_For_User.UserID_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;

		result = staffDataService.find(staffID, password);
		
		return result;
		}

	/* 
	 * Return null:
	 * 	UserID Invalid
	 * 	Account Not Exist
	 * */
	public StaffVO showData(String staffID) throws RemoteException {
		if(staffID.length()!=LengthOfID.getUserID())
			return null;
		
		StaffPO po = new StaffPO();
		
		po = staffDataService.findData(staffID);

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
	public ResultMessage_For_User changeData(StaffVO vo) throws RemoteException {
		int len = vo.staffname.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_For_User.UserName_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		StaffPO po = new StaffPO();
		po.setStaffID(vo.staffID);
		po.setStaffname(vo.staffname);
		po.setHotelId(vo.hotelId);
		
		result = staffDataService.updateData(po);
			
		return result;
	}

	/*
	 * UserID Invalid
	 * UserName Invalid
	 * HotelID Invalid
	 * 
	 * Hotel Not Exist
	 * Hotel Have Staff
	 * Account Exist
	 */
	public ResultMessage_For_User addStaff(StaffVO vo, String password) throws RemoteException {
		if(vo.staffID.length()!=LengthOfID.getUserID())
			return ResultMessage_For_User.UserID_Invalid;
		
		int len = vo.staffname.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_For_User.UserName_Invalid;
		
		if(vo.hotelId.length()!=LengthOfID.getHotelID())
			return ResultMessage_For_User.HotelID_Invalid;
		
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		StaffPO po = new StaffPO();
		po.setStaffID(vo.staffID);
		po.setStaffname(vo.staffname);
		po.setHotelId(vo.hotelId);
		
		result = staffDataService.insert(po, password);

		return result;
	}
}
