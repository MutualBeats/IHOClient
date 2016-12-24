/**
 * @author huangxiao
 */
package dataservice.promotiondataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotion.PromotionPO;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;

public class PromotionDataService_Driver {
	
	public void drive(PromotionDataService promotionDataService) throws RemoteException {
		
		ResultMessage_Promotion result;
		
		PromotionPO po = new PromotionPO();
		
		ArrayList<Integer> memberLevel = new ArrayList<>();
		memberLevel.add(512);
		memberLevel.add(2048);
		memberLevel.add(8192);
		
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(10.0);
		discount.add(9.5);
		discount.add(9.0);
		discount.add(8.5);
		
		// 添加促销策略
		po.setPromotionName("测试限时普通促销策略");
		po.setDiscount(discount);
		po.setHotelID("");
		po.setStartDate("2016/11/01");
		po.setFinishDate("2016/11/02");
		po.setType(PromotionType.Holiday);
		
		String promotionID = promotionDataService.addPromotion(po);
		System.out.println("Generate pomotionID: " + promotionID);
		po.setPromotionID(promotionID);
		
		// 删除促销策略
		result = promotionDataService.deletePromotion(promotionID);
		System.out.println(result.toString());
		
		ArrayList<PromotionPO> promotionList = new ArrayList<>();
		// 查看酒店促销策略
		promotionList = promotionDataService.getHotelPromotion("00000001");
		System.out.println("HotelID: 00000001 has" + promotionList.size() +  "promotion");
		
		// 查看网站促销策略
		promotionList = promotionDataService.getWebPromotion();
		System.out.println("Web has " + promotionList.size() + " promotion");
		
		// 根据id获取促销策略
		po = promotionDataService.getPromotionById("000001");
		System.out.println("Name: " + po.getPromotionName());
		
		// 制定会员等级
		result = promotionDataService.levelMake(memberLevel, discount);
		System.out.println(result.toString());
		
		// 查看会员等级划分方案
		memberLevel = promotionDataService.getMemberLevel();
		System.out.println(memberLevel.get(0) + " " + memberLevel.get(1) + " " + memberLevel.get(2));
		
		// 查看不同等级折扣
		discount = promotionDataService.getMemberDiscount();
		System.out.println(discount.get(0) + " " + discount.get(1) + " " + discount.get(2) + " " + discount.get(3));
	
	}

}
