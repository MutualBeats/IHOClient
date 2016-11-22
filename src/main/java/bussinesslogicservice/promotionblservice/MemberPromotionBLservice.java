package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.ClientVO;
import vo.PromotionVO;

public interface MemberPromotionBLservice {
	/*
	 * 根据输入的信用值划分等级
	 * */
	public ArrayList <Integer> levelMake (ClientVO vo);
	/*
	 * 返回会员等级信息
	 * */
	public ClientVO getLevel (String userID);
	/*
	 * 获取会员折扣信息
	 * */
	public PromotionVO getDiscount (String userID);
	
}