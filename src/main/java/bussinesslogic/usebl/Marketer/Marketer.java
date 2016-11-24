package bussinesslogic.usebl.marketer;

import java.rmi.RemoteException;

import dataservice.userdataservice.MarketerDataService;
import factory.datahelper.DataHelperFactory;
import po.MarketerPO;
import util.ResultMessage_For_User;
import vo.user.MarketerVO;

public class Marketer {

	private MarketerDataService marketerDataService;
	
	public Marketer(){
		try{
			marketerDataService = DataHelperFactory.getDataFactoryHelperInstance().getMarketerDatabase();
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
	
	public ResultMessage_For_User Login(String marketerID, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.LoginSuccess;
		try {
			result = marketerDataService.find(marketerID, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public MarketerVO showData(String marketerID) {
		MarketerPO po = new MarketerPO();
		try {
			po = marketerDataService.findData(marketerID);
		} catch (RemoteException e) {
			System.out.println(ResultMessage_For_User.GetDataFail);
			e.printStackTrace();
		}
		MarketerVO vo;
		vo = new MarketerVO(po.getMarketerID(), po.getMarketername(), po.getTel_number());
		System.out.println(ResultMessage_For_User.GetDataSuccess);
		return vo;
	}

	public ResultMessage_For_User changeData(MarketerVO vo) {
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketername);
		po.setTel_number(vo.tel_number);
		try {
			result = marketerDataService.updateData(po);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultMessage_For_User addMarketer(MarketerVO vo, String password) {
		ResultMessage_For_User result = ResultMessage_For_User.UpdateSuccess;
		MarketerPO po = new MarketerPO();
		po.setMarketerID(vo.marketerID);
		po.setMarketername(vo.marketername);
		po.setTel_number(vo.tel_number);
		try {
			result = marketerDataService.insert(po, password);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return result;
	}
}
