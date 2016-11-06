package bussinesslogic.usebl.client;

import java.util.ArrayList;

import po.MemberPO;
import util.ResultMessage;
import vo.MemberVO;

public class Member {
	/*
	 * 注册企业会员
	 */
	public ResultMessage businessRegister (MemberVO vo){
		return null;
	}
	/*
	 * 注册普通会员
	 */
	public ResultMessage originalRegister (MemberVO vo){
		return null;
	}
	/*
	 * 查看会员信息
	 */
	public MemberVO get (String memberID){
		return null;
	}
	/*
	 * 更新会员等级信息
	 */
	public ResultMessage levelUpdate (ArrayList<Integer> levelList,int level){
		return null;
	}
	/*
	 * 更新会员信息
	 */
	public ResultMessage update(String name,MemberVO vo){
		return null;
	}
}
