package bussinesslogic.memberbl;

import java.util.ArrayList;

import bussinesslogicservice.memberblservice.MemberLogicService;
import po.MemberPO;
import util.ResultMessage;
import vo.MemberVO;

public class MemberController implements MemberLogicService{

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
	public void levelLook(String name, MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberPO get(String name, MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void levelUpdate(ArrayList<Integer> levelList, int level) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberPO update(String name, MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

}
