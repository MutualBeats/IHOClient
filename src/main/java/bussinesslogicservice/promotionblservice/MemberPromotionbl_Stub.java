package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.MemberVO;

public class MemberPromotionbl_Stub implements MemberPromotionBLservice{

	@Override
	public ArrayList<Integer> levelMake(MemberVO vo) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(vo.level);
		return list;
	}

	@Override
	public MemberVO getLevel (String userID) {
		// TODO Auto-generated method stub
		if(userID.equals(new MemberVO("123456789","腾讯企业",2)))
			return new MemberVO("123456789","腾讯企业",2);
		else
			return null;
		
	}

	@Override
	public MemberVO getDiscount (String userID) {
		// TODO Auto-generated method stub
		if(userID.equals(new MemberVO("123456789","腾讯企业",2)))
			return new MemberVO("123456789","腾讯企业",2);
		else
			return null;
	}

}
