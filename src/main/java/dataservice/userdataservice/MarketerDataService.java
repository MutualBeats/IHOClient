package dataservice.userdataservice;

import java.rmi.Remote;
import java.util.ArrayList;

import po.user.MarketerPO;
import util.exception.NetException;
import util.resultmessage.ResultMessage_User;

public interface MarketerDataService extends Remote{
	/*
	 * 获取MarketerPO内部数据
	 */
	public MarketerPO getMarketerInfo(String marketerID) throws NetException;
	/*
	 * 在数据库中更新一个MarketerPO记录
	 */
	public ResultMessage_User updateData(MarketerPO po) throws NetException;
	/*
	 * 检测是否允许登陆
	 */
	public ResultMessage_User find(String marketerID, String password) throws NetException;
	/*
	 * 在数据库中生成一个marketerPO记录
	 */
	public ResultMessage_User insert (MarketerPO po, String password) throws NetException;
	
	public ArrayList<MarketerPO> getMarketerList() throws NetException;
}
