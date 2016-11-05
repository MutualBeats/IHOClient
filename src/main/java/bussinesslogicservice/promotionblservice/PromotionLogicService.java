package bussinesslogicservice.promotionblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.PromotionVO;

public interface PromotionLogicService {

	/*
	 * 添加酒店促销策略
	 */
	public ResultMessage hotelAdd (PromotionVO vo);
	/*
	 * 添加网站促销策略
	 */
	public ResultMessage webAdd (PromotionVO vo);
	/*
	 * 查看酒店促销策略
	 */
	public ArrayList<PromotionVO> hotelLook(String hotelId);
	/*
	 * 查看网站促销策略
	 */
	public ArrayList<PromotionVO> webLook();
	/*
	 * 计算会员等级制度
	 */
	public void levelMake (ArrayList <Integer> level);
}
