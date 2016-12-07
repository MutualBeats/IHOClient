package bussinesslogicservice.promotionblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.resultmessage.ResultMessage_Promotion;
import vo.promotion.PromotionVO;

public interface PromotionBLService {
	/**
	 * 添加酒店促销策略
	 * @param vo
	 * @return ResultMessage
	 */
	public String addhotelPromotion (PromotionVO vo) throws RemoteException;
	/**
	 * 添加网站促销策略
	 * @param vo
	 * @return ResultMessage
	 */
	public String addWebPromotion (PromotionVO vo) throws RemoteException;
	/**
	 * 获得酒店促销策略列表
	 * @param hotelID
	 * @return ArrayList
	 */
	public ArrayList<PromotionVO> gethotelPromotion(String hotelID) throws RemoteException;
	/**
	 * 获取网站营销策略列表
	 * @return ArrayList
	 */
	public ArrayList<PromotionVO> getWebPromotion() throws RemoteException;
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
	public ArrayList<Integer> getMemberLevel() throws RemoteException;
	/**
	 * 查看不同等级会员折扣
	 * @return ArrayList
	 */
	public ArrayList<Double> getMemberDiscount() throws RemoteException;
	/**
	 * 制定会员等级
	 * @param level
	 * @param discount
	 * @return ResultMessage
	 */
	public ResultMessage_Promotion makeLevel(ArrayList<Integer> level, ArrayList<Double> discount);
	
}
