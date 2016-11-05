package bussinesslogicservice.memberblservice;

import java.util.ArrayList;

import po.MemberPO;
import util.ResultMessage;
import vo.MemberVO;

public interface MemberLogicService {
	/*
	 * 注册企业会员
	 */
	public ResultMessage businessRegister (MemberVO vo);
	/*
	 * 注册普通会员
	 */
	public ResultMessage originalRegister (MemberVO vo);
	/*
	 * 查看会员等级信息
	 */
	public void levelLook (String name,MemberVO vo);
	
	/*
	 * 查看会员信息
	 */
	public MemberPO get (String name,MemberVO vo);
	/*
	 * 更新会员等级信息
	 */
	public void levelUpdate (ArrayList<Integer> levelList,int level);
	/*
	 * 更新会员信息
	 */
	public MemberPO update(String name,MemberVO vo);
}
