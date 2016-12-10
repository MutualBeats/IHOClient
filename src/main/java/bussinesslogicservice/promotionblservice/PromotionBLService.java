package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import util.exception.NetException;
import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public interface PromotionBLService {
	/**
	 * 添加酒店促销策略
	 * @param vo
	 * @return ResultMessage
	 */
	public String addhotelPromotion (PromotionVO vo) throws NetException;
	/**
	 * 添加网站促销策略
	 * @param vo
	 * @return ResultMessage
	 */
	public String addWebPromotion (PromotionVO vo) throws NetException;
	/**
	 * 获得酒店促销策略列表
	 * @param hotelID
	 * @return ArrayList<PromotionVO>
	 */
	public ArrayList<PromotionVO> getHotelPromotion(String hotelID) throws NetException;
	/**
	 * 获取网站营销策略列表
	 * @return ArrayList<PromotionVO>
	 */
	public ArrayList<PromotionVO> getWebPromotion() throws NetException;
	/**
	 * 根据id获取促销策略
	 * @param promotionID
	 * @return PromotionVO
	 * @throws NetException
	 */
	public PromotionVO getPromotionById(String promotionID) throws NetException;
	/**
	 * 撤销已有促销策略
	 * @param promotionID
	 * @return ResultMessage
	 */
	public ResultMessage_Promotion cancel(String promotionID);
	/**
	 * 查看会员等级划分方案
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getMemberLevel() throws NetException;
	/**
	 * 查看不同等级会员折扣
	 * @return ArrayList<Double>
	 */
	public ArrayList<Double> getMemberDiscount() throws NetException;
	/**
	 * 制定会员等级
	 * @param level
	 * @param discount
	 * @return ResultMessage
	 */
	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount);
	
}
