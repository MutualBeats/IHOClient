package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import po.PromotionPO;
import vo.MemberVO;
import vo.PromotionVO;

public class MemberPromotionbl_Driver {
	public void drive(MemberPromotionBLservice memberPromotionBLservice){
		PromotionVO vo1=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
		PromotionVO vo2=new PromotionVO("123456780", "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		MemberVO vo3=new MemberVO("123456789","腾讯企业",2);
		ArrayList<Integer> list=new ArrayList<Integer>();
		try{
			list=memberPromotionBLservice.levelMake(vo3);
			System.out.println(list);
			memberPromotionBLservice.getLevel(vo3.memberID);
			memberPromotionBLservice.getDiscount(vo3.memberID);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
