package bussinesslogic.usebl.client;

import java.util.ArrayList;

import bussinesslogicservice.userblservice.MemberBLService;
import po.MemberPO;
import util.ResultMessage;
import vo.MemberVO;

public class MemberController implements MemberBLService {

	@Override
	public ResultMessage businessRegister(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage originalRegister(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO get(String memberID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage levelUpdate(ArrayList<Integer> levelList, int level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(String memberID, MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
