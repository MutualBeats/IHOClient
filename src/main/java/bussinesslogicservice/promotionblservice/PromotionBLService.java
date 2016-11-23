package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import util.ResultMessage_For_Stub;
import vo.OrderPromotionConditionVO;
import vo.PromotionVO;

public interface PromotionBLService {

	/*
	 * 添加酒店促销策略
	 */
	public ResultMessage_For_Stub hotelAdd (PromotionVO vo);
	/*
	 * 添加网站促销策略
	 */
	public ResultMessage_For_Stub webAdd (PromotionVO vo);
	/*
	 * 查看酒店促销策略
	 */
	public ArrayList<PromotionVO> hotelLook(String hotelId);
	/*
	 * 查看网站促销策略
	 */
	public ArrayList<PromotionVO> webLook();
	/*
	 * 撤销促销策略
	 */
	public ResultMessage_For_Stub cancel(String promotionID);
	/*
	 * 获得当前可用的促销策略
	 */
	public ArrayList<PromotionVO> getPromotion(OrderPromotionConditionVO ordervo);
}
