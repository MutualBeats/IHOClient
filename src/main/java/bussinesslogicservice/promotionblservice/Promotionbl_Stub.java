package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.PromotionVO;

public class Promotionbl_Stub implements PromotionLogicService{
	
	/*
	 * 添加酒店促销策略
	 */
	public ResultMessage hotelAdd (PromotionVO vo){
		if(vo.message.equals("双十一全店特价"))
			return ResultMessage.HotelAddSuccess;
		else
			return ResultMessage.HotelAddFail;
	}
	/*
	 * 添加网站促销策略
	 */
	public ResultMessage webAdd (PromotionVO vo){
		if(vo.message.equals("双十一全网特价"))
			return ResultMessage.HotelAddSuccess;
		else
			return ResultMessage.HotelAddFail;
	}
	
	/*
	 * 计算会员等级制度
	 */
	public void levelCalculate(ArrayList<Integer> levelList) {
		// TODO Auto-generated method stub
		System.out.println("Calculate Successful!");
	}
	@Override
	public ArrayList<PromotionVO> hotelLook(String hotelId) {
		PromotionVO vo1=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
//		PromotionVO vo2=new PromotionVO("123456780", "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		return list;
	}
	@Override
	public ArrayList<PromotionVO> webLook() {
		PromotionVO vo1=new PromotionVO("123456789", "双十一全店特价","1234567890","2016/10/10","2016/10/20",0.1);
		PromotionVO vo2=new PromotionVO("123456780", "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		list.add(vo2);
		return list;
	}
	@Override
	public void levelMake(ArrayList<Integer> level) {
		System.out.println("Make Successful!");
	}
}
