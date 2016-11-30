package bussinesslogic.userbl.staff;

import java.rmi.RemoteException;

import dataservice.userdataservice.StaffDataService;
import factory.datahelper.DataHelperFactory;
import po.user.StaffPO;
import util.LengthOfID;
import util.resultmessage.ResultMessage_User;
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
	public ResultMessage_User Login(String staffID, String password) throws RemoteException {
		if(staffID.length()!=LengthOfID.getUserID())
			return ResultMessage_User.UserID_Invalid;
		
			ResultMessage_User result = ResultMessage_User.LoginSuccess;

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
		return vo;
	}

	/*
	 * UserName Invalid
	 */
	public ResultMessage_User changeData(StaffVO vo) throws RemoteException {
		int len = vo.staffName.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_User.UserName_Invalid;
		
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		StaffPO po = new StaffPO();
		po.setStaffID(vo.staffID);
		po.setStaffname(vo.staffName);
		po.setHotelId(vo.hotelID);
		
		result = staffDataService.updateData(po);
			
		return result;
	}

	/*
	 * UserName Invalid
	 * HotelID Invalid
	 * 
	 * Hotel Not Exist
	 * Hotel Have Staff
	 */
	public ResultMessage_User addStaff(String staffName, String hotelID, String password) throws RemoteException {
		int len = staffName.length();
		if(len<LengthOfID.getMinUserName()||len>LengthOfID.getMaxUserName())
			return ResultMessage_User.UserName_Invalid;
		
		if(hotelID.length()!=LengthOfID.getHotelID())
			return ResultMessage_User.HotelID_Invalid;
		
		String ID = "STF" + hotelID;
		
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		StaffPO po = new StaffPO();
		po.setStaffID(ID);
		po.setStaffname(staffName);
		po.setHotelId(hotelID);
		
		result = staffDataService.insert(po, password);

		return result;
	}
}
