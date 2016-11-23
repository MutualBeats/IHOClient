package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.order.OrderPromotionConditionVO;
import vo.promotion.PromotionVO;

public class Promotionbl_Driver {
	public void drive(PromotionBLService promotionLogicService){
		PromotionVO vo1=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
		PromotionVO vo2=new PromotionVO("123456780", "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		OrderPromotionConditionVO ordervo=new OrderPromotionConditionVO();
		try {
			promotionLogicService.hotelAdd(vo2);
			promotionLogicService.hotelLook("12345678");
			promotionLogicService.webAdd(vo1);
			promotionLogicService.webLook();
			ArrayList<Integer> level=new ArrayList<>();
			level.add(1);
			promotionLogicService.cancel("123456789");
			promotionLogicService.getPromotion(ordervo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
