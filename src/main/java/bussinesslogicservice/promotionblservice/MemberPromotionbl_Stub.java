package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.MemberVO;
import vo.PromotionVO;

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
	public PromotionVO getDiscount (String userID) {
		// TODO Auto-generated method stub
		if(userID.equals(new MemberVO("123456789","腾讯企业",2)))
			return new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
		else
			return null;
	}

}
