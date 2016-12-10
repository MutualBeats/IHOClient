package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotion.PromotionPO;
import util.resultmessage.ResultMessage_Promotion;

public interface PromotionDataService extends Remote {
	/**
	 * 添加促销策略
	 * @param po
	 * @return promotionID
	 * @throws RemoteException
	 */
	public String addPromotion(PromotionPO po) throws RemoteException;
	/**
	 * 查看酒店促销策略
	 * @param hotelID
	 * @return ArrayList<PromotionPO>
	 * @throws RemoteException
	 */
	public ArrayList<PromotionPO> getHotelPromotion(String hotelID) throws RemoteException;
	/**
	 * 查看网站促销策略
	 * @return ArrayList<PromotionPO>
	 * @throws RemoteException
	 */
	public ArrayList<PromotionPO> getWebPromotion() throws RemoteException;
	/**
	 * 根据id获取促销策略
	 * @param promotionID
	 * @return PromotionPO
	 * @throws RemoteException
	 */
	public PromotionPO getPromotionById(String promotionID) throws RemoteException;
	/**
	 * 删除促销策略
	 * @param promotionID
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage_Promotion deletePromotion(String promotionID) throws RemoteException;
	/**
	 * 查看会员等级划分方案
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getMemberLevel() throws RemoteException;
	/**
	 * 查看不同等级会员折扣
	 * @return ArrayList<Double>
	 */
	public ArrayList<Double> getMemberDiscount() throws RemoteException;
	/**
	 * 制定会员等级制度
	 * @param level
	 * @return ResultMessage
	 * @throws RemoteException
	 */
	public ResultMessage_Promotion levelMake(ArrayList<Integer> level, ArrayList<Double> discount) throws RemoteException;
	
}
