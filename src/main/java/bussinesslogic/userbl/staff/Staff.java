package bussinesslogic.userbl.staff;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.StaffDataService;
import factory.datahelper.DataHelperFactory;
import po.user.StaffPO;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffVO;

/**
 * 
 * Staff具体逻辑实现类，注释参考Client
 * 
 * @author heleninsa
 *
 */
public class Staff {
	
	private StaffDataService staffDataService;
	
	private StaffPO cache;
	
	public Staff(){
		try {
			staffDataService = DataHelperFactory.getDataFactoryHelperInstance().getStaffDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public StaffVO showData(String staffID) throws RemoteException {		
		if(!checkCacheHit(staffID)) {
		 cache = staffDataService.findData(staffID);
		}
		
		StaffVO vo = StaffPO.transformPOToVO(cache);
		return vo;
	}

	public ResultMessage_User changeData(StaffVO vo) {
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		
		StaffPO po = StaffVO.transformVOToPO(vo);
		
		try {
			result = staffDataService.updateData(po);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}
			
		return result;
	}

	public ResultMessage_User addStaff(StaffVO registVO, String password) {				
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		StaffPO po = StaffVO.transformVOToPO(registVO); 
		try {
			result = staffDataService.insert(po, password);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}
		return result;
	}
	
	public ArrayList<StaffVO> getStaffList() throws RemoteException{
		ArrayList<StaffPO> pos = staffDataService.getStaffList();
		ArrayList<StaffVO> vos = new ArrayList<>();
		for(StaffPO each : pos) {
			StaffVO vo = StaffPO.transformPOToVO(each);
			vos.add(vo);
		}
		return vos;
	}
	
	private boolean checkCacheHit(String tocheckID) {
		return cache != null && cache.getStaffID().equals(tocheckID);
	}
}
