package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.MemberVO;

public interface MemberPromotionBLservice {
	/*
	 * 根据输入的信用值划分等级
	 * */
	public ArrayList <Integer> levelMake (MemberVO vo);
	/*
	 * 返回会员等级信息
	 * */
	public MemberVO getLevel (String userID);
	/*
	 * 获取会员折扣信息
	 * */
	public MemberVO getDiscount (String userID);
	
}