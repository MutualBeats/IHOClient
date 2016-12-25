package bussinesslogicservice.userblservice;

import util.exception.NetException;
import util.resultmessage.ResultMessage_User;
import util.user.MemberType;
import vo.user.ClientInfoChangeVO;
import vo.user.ClientRegistVO;
import vo.user.ClientVO;
import vo.user.MemberVO;

public class ClientBLStub implements ClientBLService{

	@Override
	public ResultMessage_User regist(ClientRegistVO info) {
		return ResultMessage_User.Register_Success;
	}

	@Override
	public ClientVO getClientInfo(String clientID) throws NetException {
		return new ClientVO("test_client", "Test", "12345678900", 0, MemberType.Not, 0, "");
	}

	@Override
	public ResultMessage_User changeClientInfo(ClientInfoChangeVO vo) {
		return ResultMessage_User.UpdateSuccess;
	}

	@Override
	public ResultMessage_User registerMember(MemberVO vo) {
		return ResultMessage_User.Register_Success;
	}

}
