package bussinesslogicservice.memberblservice;

import java.util.ArrayList;

import po.MemberPO;
import util.ResultMessage;
import vo.MemberVO;

public class Memberbl_Stub implements MemberLogicService{
	
	/*
	 * 注册企业会员
	 */
	public ResultMessage businessRegister (MemberVO vo){
		if(vo.memberMessage.equals("腾讯企业"))
			return ResultMessage.RegisterSuccess;
		else 
			return ResultMessage.RegisterFail;
	}
	/*
	 * 注册普通会员
	 */
	public ResultMessage originalRegister (MemberVO vo){
		if(vo.memberMessage.equals("1997.01.01"))
			return ResultMessage.RegisterSuccess;
		else 
			return ResultMessage.RegisterFail;
	}
	/*
	 * 查看会员等级
	 */
	public void levelLook (String name,MemberVO vo){
		if(name.equals(vo.memberID))
			 System.out.println("The level is "+ vo.level);;
	}
	/*
	 * 查看会员信息
	 */
	@Override
	public MemberPO get(String name,MemberVO vo) {
		// TODO Auto-generated method stub
		if(name.equals(vo.memberID))
			return new MemberPO(name,"腾讯企业",2);
		else 
			return null;
	}
	/*
	 * 更新会员等级信息
	 */
	@Override
	public void levelUpdate(ArrayList<Integer> levelList,int level) {
		// TODO Auto-generated method stub
		int result=levelList.indexOf(level);
		System.out.println("Grade" + result);
	}
	/*
	 * 更新会员信息
	 */
	@Override
	public MemberPO update(String name,MemberVO vo) {
		// TODO Auto-generated method stub
		if(name.equals(vo.memberID))
			return new MemberPO(name,"腾讯企业",2);
		else
			return null;
	}
	
}
