/**
 * @author huangxiao
 */
package dataservice.userdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.user.ClientInfoChangePO;
import po.user.ClientPO;
import po.user.ClientRegistPO;
import po.user.ManagerPO;
import po.user.MarketerPO;
import po.user.MemberPO;
import po.user.StaffChangePO;
import po.user.StaffPO;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;

public class UserDataService_Stub
		implements ClientDataService, ManagerDataService, StaffDataService, MarketerDataService {

	private ClientPO client;
	private ManagerPO manager;
	private MarketerPO marketer;
	private StaffPO staff;
	
	public UserDataService_Stub() {
		client = new ClientPO("clientTest", "client", "12345678900", 0, MemberType.Not, 0, "");
		manager = new ManagerPO("manager", "manager", "12345678900");
		marketer = new MarketerPO("marketer", "marketer", "12345678900");
		staff = new StaffPO("TestStaff", "staff", "12345678900", "00000001");
	}
	
	@Override
	public MarketerPO getMarketerInfo(String marketerID) throws RemoteException {
		marketer.setMarketerID(marketerID);
		return marketer;
	}

	@Override
	public ResultMessage_User updateData(MarketerPO po) throws RemoteException {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ResultMessage_User insert(MarketerPO po, String password) throws RemoteException {
		return ResultMessage_User.Register_Success;
	}

	@Override
	public ArrayList<MarketerPO> getMarketerList() throws RemoteException {
		ArrayList<MarketerPO> marketers = new ArrayList<>();
		marketers.add(marketer);
		return marketers;
	}

	@Override
	public StaffPO findData(String staffID) throws RemoteException {
		staff.setStaffID(staffID);
		return staff;
	}

	@Override
	public ResultMessage_User updateData(StaffChangePO po) throws RemoteException {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ResultMessage_User insert(StaffPO po, String password) throws RemoteException {
		return ResultMessage_User.Register_Success;
	}

	@Override
	public ArrayList<StaffPO> getStaffList() throws RemoteException {
		ArrayList<StaffPO> staffs = new ArrayList<>();
		staffs.add(staff);
		return staffs;
	}

	@Override
	public ManagerPO getManagerInfo() throws RemoteException {
		return manager;
	}

	@Override
	public ResultMessage_User changeManagerInfo(ManagerPO po) throws RemoteException {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ResultMessage_User regist(ClientRegistPO po) throws RemoteException {
		return ResultMessage_User.Register_Success;
	}

	@Override
	public ClientPO queryClient(String clientID) throws RemoteException {
		return new ClientPO(clientID, "client", "12345678900", 0, MemberType.Not, 0, "");
	}

	@Override
	public ResultMessage_User updateClientInfo(ClientInfoChangePO changePO) throws RemoteException {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ResultMessage_User registerMember(MemberPO po) throws RemoteException {
		return ResultMessage_User.Register_Success;
	}

	@Override
	public ArrayList<ClientPO> getClientList() throws RemoteException {
		ArrayList<ClientPO> clients = new ArrayList<>();
		clients.add(client);
		return clients;
	}

}
