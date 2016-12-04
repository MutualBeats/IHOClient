package bussinesslogic.userbl.marketer;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.MarketerDataService;
import factory.datahelper.DataHelperFactory;
import po.user.MarketerPO;
import util.resultmessage.ResultMessage_User;
import vo.user.MarketerVO;

/**
 * 
 * Maketer具体逻辑实现，注释参考Client
 * 
 * @author heleninsa
 *
 */
public class Marketer {

	private MarketerDataService marketerDataService;
	
	private MarketerPO cache;
	
	public Marketer(){
		try {
			marketerDataService = DataHelperFactory.getDataFactoryHelperInstance().getMarketerDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public MarketerVO showData(String marketerID) throws RemoteException {
		if(!checkCacheHit(marketerID)) {
			cache = marketerDataService.getMarketerInfo(marketerID);
		}
		MarketerVO vo = MarketerPO.transformPOToVO(cache);
		return vo;
	}
		
	
	public ResultMessage_User changeData(MarketerVO vo) {
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		MarketerPO po = MarketerVO.transformVOToPO(vo);
		try {
			result = marketerDataService.updateData(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage_User.Net_Error;
		}
		if(result == ResultMessage_User.UpdateSuccess) {
			cache.updateInfo(vo);
		}
		return result;
	}

	public ResultMessage_User addMarketer(MarketerVO registVO, String password) {
		ResultMessage_User result = ResultMessage_User.AddSucccess;
		MarketerPO po = MarketerVO.transformVOToPO(registVO);
		try {
			result = marketerDataService.insert(po, password);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}
		
		return result;
	}
	
	public ArrayList<MarketerVO> getMarketerList() throws RemoteException{
		ArrayList<MarketerPO> pos = marketerDataService.getMarketerList();
		ArrayList<MarketerVO> vos = new ArrayList<>();
		for(MarketerPO each : pos) {
			MarketerVO vo = MarketerPO.transformPOToVO(each);
			vos.add(vo);
		}
		return vos;
	}

	private boolean checkCacheHit(String tocheckID) {
		return cache != null && cache.getMarketerID().equals(tocheckID);
	}
	
}
