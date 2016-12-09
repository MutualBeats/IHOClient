package bussinesslogic.userbl.staff;

import java.util.ArrayList;

import dataservice.userdataservice.StaffDataService;
import factory.datahelper.DataHelperFactory;
import po.user.StaffChangePO;
import po.user.StaffPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import vo.user.StaffChangeVO;
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
	
	public Staff() throws NetException{
		staffDataService = DataHelperFactory.getDataFactoryHelperInstance().getStaffDatabase();
	}
	
	public StaffVO showData(String staffID) throws NetException {		
		if(!checkCacheHit(staffID)) {
		 cache = staffDataService.findData(staffID);
		}
		
		StaffVO vo = StaffPO.transformPOToVO(cache);
		return vo;
	}

	public ResultMessage_User changeData(StaffChangeVO vo) {
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		
		StaffChangePO po = new StaffChangePO(vo);
		
		try {
			result = staffDataService.updateData(po);
		} catch (NetException e) {
			return ResultMessage_User.Net_Error;
		}
			
		return result;
	}

	public ResultMessage_User addStaff(StaffVO registVO, String password) {				
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		StaffPO po = StaffVO.transformVOToPO(registVO); 
		try {
			result = staffDataService.insert(po, password);
		} catch (NetException e) {
			return ResultMessage_User.Net_Error;
		}
		return result;
	}
	
	public ArrayList<StaffVO> getStaffList() throws NetException{
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
