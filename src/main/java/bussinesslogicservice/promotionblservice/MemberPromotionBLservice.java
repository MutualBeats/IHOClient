package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.MemberVO;

public interface MemberPromotionBLservice {
	public ArrayList <Integer> levelMake (MemberVO vo);
	
	public void getLevel(MemberVO vo);
	
	public void getDiscount(MemberVO vo);
	
}