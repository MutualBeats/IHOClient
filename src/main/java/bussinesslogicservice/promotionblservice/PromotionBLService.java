package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public interface PromotionBLService {
	/**
	 * 添加酒店促销策略
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage_Promotion addhotelPromotion (PromotionVO vo);
	/**
	 * 添加网站促销策略
	 * @param vo
	 * @return ResultMessage
	 */
	public ResultMessage_Promotion addWebPromotion (PromotionVO vo);
	/**
	 * 获得酒店促销策略列表
	 * @param hotelId
	 * @return ArrayList
	 */
	public ArrayList<PromotionVO> gethotelPromotion(String hotelID);
	/**
	 * 获取网站营销策略列表
	 * @return ArrayList
	 */
	public ArrayList<PromotionVO> getWebPromotion();
	/**
	 * 撤销已有促销策略
	 * @param promotionID
	 * @return ResultMessage
	 */
	public ResultMessage_Promotion cancel(String promotionID);
	/**
	 * 查看会员等级划分方案
	 * @return ArrayList
	 */
	public ArrayList<Integer> getMemberLevel();
	/**
	 * 查看不同等级会员折扣
	 * @return ArrayList
	 */
	public ArrayList<Double> getMemberDiscount();
	/**
	 * 制定会员等级
	 * @param level
	 * @param discount
	 * @return ResultMessage
	 */
	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount);
	
}
