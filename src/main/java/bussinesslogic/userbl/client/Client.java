package bussinesslogic.userbl.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.ClientDataService;
import factory.datahelper.DataHelperFactory;
import po.user.ClientInfoChangePO;
import po.user.ClientPO;
import po.user.MemberPO;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class Client {

	private ClientDataService clientDataService;

	private ClientPO cache;

	public Client() {
		try {
			clientDataService = DataHelperFactory.getDataFactoryHelperInstance().getClientDatabase();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage_User regist(ClientVO registVO, String password) throws RemoteException {
		ResultMessage_User result = ResultMessage_User.Register_Success;
		ClientPO po = ClientVO.transformVOToPO(registVO);
		result = clientDataService.regist(po, password);
		if(result == ResultMessage_User.Register_Success) {
			cache = ClientVO.transformVOToPO(getClientInfo(registVO.clientID));
		}
		return result;
	}

	/**
	 * Get the client data
	 * 
	 * @param clientID
	 * @return the information of client
	 * @throws RemoteException
	 *             : Net Error
	 */
	public ClientVO getClientInfo(String clientID) throws RemoteException {
		if (!checkCacheHit(clientID)) {
			// Reload the cache
			cache = clientDataService.queryClient(clientID);
		}

		ClientVO vo = ClientPO.transformPOToVO(cache);
		return vo;
	}

	/**
	 * 修改个人信息
	 * 
	 * @param clientID
	 * @param clientName
	 * @param contactWay
	 * @return
	 */
	public ResultMessage_User changeClientInfo(ClientInfoChangeVO vo) {
		ResultMessage_User result = ResultMessage_User.UpdateSuccess;
		ClientInfoChangePO changePO = ClientInfoChangeVO.transformVOToPO(vo);
		
		try {
			result = clientDataService.updateClientInfo(changePO);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}
		// Make sure the check is successful
		if (result == ResultMessage_User.UpdateSuccess && checkCacheHit(vo.clientID)) {
			// Update the cache
			cache.updateInfo(vo);
		}
		return result;
	}

	/**
	 * 注册会员
	 * 
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage_User memberRegister(MemberVO vo) {
		ResultMessage_User result = ResultMessage_User.Register_Success;
		
		if (!checkCacheHit(vo.clientID)) {
			try {
				getClientInfo(vo.clientID);
			} catch (RemoteException e) {
				e.printStackTrace();
				return ResultMessage_User.Net_Error;
			}
		}
		
		MemberType existType = cache.getMemberType();
		//检查用户会员状态
		if (existType != MemberType.Not) {
			if (existType == MemberType.Enterprise) {
				return ResultMessage_User.BusinessMember_Exist;
			} else {
				return ResultMessage_User.OriginalMember_Exist;
			}
		}
		MemberPO po = MemberVO.transformVOToPO(vo);

		try {
			result = clientDataService.registerMember(po);
		} catch (RemoteException e) {
			return ResultMessage_User.Net_Error;
		}
		
		//更新Cache
		if(result == ResultMessage_User.Register_Success) {
			cache.setMemberMessage(vo.memberMessage);
			cache.setMemberType(vo.memberType);
		}

		return result;
	}

	/**
	 * 检查Cache状态
	 * 
	 * @param tocheckID
	 * @return
	 */
	private boolean checkCacheHit(String tocheckID) {
		return cache != null && cache.getClientID().equals(tocheckID);
	}
	
	/**
	 * 获取用户列表
	 * 
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<ClientVO> getClientList() throws RemoteException{
		ArrayList<ClientPO> pos = clientDataService.getClientList();
		ArrayList<ClientVO> vos = new ArrayList<>();
		for(ClientPO each : pos) {
			ClientVO vo = ClientPO.transformPOToVO(each);
			vos.add(vo);
		}
		return vos;
	}
	

}
