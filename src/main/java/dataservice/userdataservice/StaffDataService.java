package dataservice.userdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.user.StaffChangePO;
import po.user.StaffPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;

public interface StaffDataService extends Remote{
	
	public StaffPO findData(String staffID) throws NetException;
	
	public ResultMessage_User updateData(StaffChangePO po) throws NetException;
	
	public ResultMessage_User insert(StaffPO po, String password) throws NetException;
	
	public ArrayList<StaffPO> getStaffList() throws NetException;
	
}
