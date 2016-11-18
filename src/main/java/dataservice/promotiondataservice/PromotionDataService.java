package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.MemberPO;
import po.PromotionVO;
import util.ResultMessage;

public interface PromotionDataService extends Remote{
	/*
	 * 添加酒店促销策略
	 */
	public ResultMessage hotelAdd (PromotionVO po) throws RemoteException;
	/*
	 * 添加网站促销策略
	 */
	public ResultMessage webAdd (PromotionVO po) throws RemoteException;
	/*
	 * 查看酒店促销策略
	 */
	public ArrayList<PromotionVO> hotelLook (String hotelId) throws RemoteException;
	/*
	 * 查看网站促销策略
	 */
	public ArrayList<PromotionVO> webLook () throws RemoteException;
	/*
	 * 制定会员等级制度
	 */
	public  void  levelMake (PromotionVO po,MemberPO po2)throws RemoteException ;
}
