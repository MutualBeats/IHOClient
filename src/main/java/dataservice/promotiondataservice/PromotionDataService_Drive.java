package dataservice.promotiondataservice;

import po.MemberPO;
import po.PromotionVO;

public class PromotionDataService_Drive {
	
		public void drive(PromotionDataService promotionDS){
			PromotionVO po1=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
			PromotionVO po2=new PromotionVO("123456780", "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
			MemberPO po3=new MemberPO("1234567890", "腾讯企业",2);
			try {
				promotionDS.hotelAdd(po1);
				promotionDS.webAdd(po2);
				promotionDS.hotelLook("12345678");
				promotionDS.webLook();
				promotionDS.levelMake(po1,po3);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
}
