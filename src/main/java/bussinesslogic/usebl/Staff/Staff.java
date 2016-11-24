package bussinesslogic.usebl.staff;

import java.rmi.RemoteException;

import dataservice.userdataservice.StaffDataService;
import factory.datahelper.DataHelperFactory;
import po.StaffPO;
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
	
	public ResultMessage_For_User Login(String staffID, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = staffDataService.find(staffID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public StaffVO showData(String staffID) {
		StaffPO po = new StaffPO();
		try {
			po = staffDataService.findData(staffID);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.GetDataFail);
			e.printStackTrace();
		}
		StaffVO vo;
		vo = new StaffVO(po.getStaffID(),po.getStaffname(),po.getHotelId());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	public ResultMessage_For_User changeData(StaffVO vo) {
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

	public ResultMessage_For_User addStaff(StaffVO vo, String password) {
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
