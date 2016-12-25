package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.promotion.PromotionType;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public class PromotionStub implements PromotionBLService {

	/*
	 * 添加酒店促销策略
	 */
	public String addhotelPromotion(PromotionVO vo) {
		if (vo.promotionName.equals("双十一全店特价"))
			return "000001";
		else
			return "";
	}

	/*
	 * 添加网站促销策略
	 */
	public String addWebPromotion(PromotionVO vo) {
		if (vo.promotionName.equals("双十一全网特价"))
			return "000001";
		else
			return "";
	}

	/*
	 * 计算会员等级制度
	 */
	public void levelCalculate(ArrayList<Integer> levelList) {
		System.out.println("Calculate Successful!");
	}

	@Override
	public ArrayList<PromotionVO> getHotelPromotion(String hotelId) {
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(10.0);
		discount.add(9.0);
		discount.add(8.0);
		discount.add(7.0);
		PromotionVO vo1 = new PromotionVO("123456789", "双十一全店特价", PromotionType.Room, discount, "00000001","2016/10/10", "2016/10/20");
		// PromotionVO vo2=new PromotionVO("123456780",
		// "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		return list;
	}

	@Override
	public ArrayList<PromotionVO> getWebPromotion() {
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(10.0);
		discount.add(9.0);
		discount.add(8.0);
		discount.add(7.0);
		PromotionVO vo1 = new PromotionVO("123456789", "双十一全店特价", PromotionType.BusinessDistrict, discount, "江苏省 南京市 南京市 栖霞商圈","2016/10/10", "2016/10/20");
		// PromotionVO vo2=new PromotionVO("123456780",
		// "双十一全网特价","123456","2016/10/10","2016/10/20",0.1);
		ArrayList<PromotionVO> list = new ArrayList<>();
		list.add(vo1);
		return list;
	}

	@Override
	public ResultMessage_Promotion  makeLevel(ArrayList<Integer> level, ArrayList<Double> discount) {
		return ResultMessage_Promotion.Level_Make_Successful;
	}

	@Override
	public PromotionVO getPromotionById(String promotionID) throws NetException {
		if(promotionID.equals("123456789")) {
			ArrayList<Double> discount = new ArrayList<>();
			discount.add(10.0);
			discount.add(9.0);
			discount.add(8.0);
			discount.add(7.0);
			return new PromotionVO("123456789", "双十一全店特价", PromotionType.BusinessDistrict, discount, "江苏省 南京市 南京市 栖霞商圈","2016/10/10", "2016/10/20");
		} else {
			return null;
		}
	}

	@Override
	public ResultMessage_Promotion cancel(String promotionID) {
		return ResultMessage_Promotion.Delete_Successful;
	}

	@Override
	public ArrayList<Integer> getMemberLevel() throws NetException {
		ArrayList<Integer> level = new ArrayList<>();
		level.add(1000);
		level.add(900);
		level.add(800);
		level.add(700);
		return level;
	}

	@Override
	public ArrayList<Double> getMemberDiscount() throws NetException {
		ArrayList<Double> discount = new ArrayList<>();
		discount.add(10.0);
		discount.add(9.0);
		discount.add(8.0);
		discount.add(7.0);
		return discount;
	}

}
