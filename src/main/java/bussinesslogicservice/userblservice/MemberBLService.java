package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.MemberVO;

public interface MemberBLService {
	/*
	 * 注册企业会员
	 */
	public ResultMessage businessRegister (MemberVO vo);
	/*
	 * 注册普通会员
	 */
	public ResultMessage originalRegister (MemberVO vo);
	/*
	 * 查看会员信息
	 */
	public MemberVO get (String memberID);
	/*
	 * 更新会员等级信息
	 */
	public ResultMessage levelUpdate (ArrayList<Integer> levelList,int level);
	/*
	 * 更新会员信息
	 */
	public ResultMessage update(String memberID,MemberVO vo);
}
