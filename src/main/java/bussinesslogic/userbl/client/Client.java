package bussinesslogic.userbl.client;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.ClientDataService;
import factory.datahelper.DataHelperFactory;
import po.user.ClientInfoChangePO;
import po.user.ClientPO;
import po.user.ClientRegistPO;
import po.user.MemberPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_Credit;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientRegistVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class Client {

	private ClientDataService clientDataService;

	private ClientPO cache;

	private CreditRegister credit;

	public Client(CreditRegister credit) throws NetException {
		clientDataService = DataHelperFactory.getDataFactoryHelperInstance().getClientDatabase();

		this.credit = credit;
	}

	public ResultMessage_User regist(ClientRegistVO registVO) {
		ResultMessage_User result = ResultMessage_User.Register_Success;
		ClientRegistPO po = ClientRegistVO.transformVOToPO(registVO);
		try {
			result = clientDataService.regist(po);
			if (result == ResultMessage_User.Register_Success) {
				ResultMessage_Credit re_result = credit.addCreditRegister(registVO.id);
				if(re_result != ResultMessage_Credit.Update_Successful) {
					return ResultMessage_User.Regitster_Failed;
				}
				//Cache update
				cache = ClientVO.transformVOToPO(getClientInfo(registVO.id));
			}
		} catch (NetException | RemoteException e) {
			return ResultMessage_User.Net_Error;
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
	public ClientVO getClientInfo(String clientID) throws NetException {
		if (!checkCacheHit(clientID)) {
			// Reload the cache
			try {
				cache = clientDataService.queryClient(clientID);
			} catch (RemoteException e) {
				e.printStackTrace();
				throw new NetException();
			}
		}

		ClientVO vo = ClientPO.transformPOToVO(cache);
		return vo;
	}

	/**
	 * 修改个人信息
	 * 
	 * @param id
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
			} catch (NetException e) {
				e.printStackTrace();
				return ResultMessage_User.Net_Error;
			}
		}

		MemberType existType = cache.getMemberType();
		// 检查用户会员状态
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

		// 更新Cache
		if (result == ResultMessage_User.Register_Success) {
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
	public ArrayList<ClientVO> getClientList() throws NetException {
		ArrayList<ClientPO> pos;
		try {
			pos = clientDataService.getClientList();
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new NetException();
		}
		ArrayList<ClientVO> vos = new ArrayList<>();
		for (ClientPO each : pos) {
			ClientVO vo = ClientPO.transformPOToVO(each);
			vos.add(vo);
		}
		return vos;
	}

}
