package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.PromotionVO;

public class Promotionbl_Drive {
	public void drive(PromotionLogicService promotionLogicService){
		PromotionVO vo1=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
		PromotionVO vo2=new PromotionVO("123456780", "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		
		try {
			promotionLogicService.hotelAdd(vo2);
			promotionLogicService.hotelLook("12345678");
			promotionLogicService.webAdd(vo1);
			promotionLogicService.webLook();
			ArrayList<Integer> level=new ArrayList<>();
			level.add(1);
			promotionLogicService.levelMake(level);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
