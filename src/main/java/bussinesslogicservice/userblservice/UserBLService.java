package bussinesslogicservice.userblservice;

import java.util.ArrayList;

import util.ResultMessage;
import vo.ClientVO;
import vo.MarketerVO;
import vo.StaffVO;

public interface UserBLService {
	/*
	 * 获取用户信息
	 */
	public ClientVO showClientData (String clientID);
	/*
	 * 修改用户信息
	 */
	public ResultMessage changeClientData (ClientVO vo);
	/*
	 * 获取酒店工作人员信息
	 */
	public StaffVO showStaffData (String staffID);
	/*
	 * 修改酒店工作人员信息
	 */
	public ResultMessage changeStaffData (StaffVO vo);
	/*
	 * 获取网站营销人员信息
	 */
	public MarketerVO showMarketerData (String marketerID);
	/*
	 * 修改网站营销人员信息
	 */
	public ResultMessage changeMarketerData (MarketerVO vo);
	/*
	 * 添加网站营销人员
	 */
	public ResultMessage addMarketer(MarketerVO vo);
	/*
	 * 添加酒店工作人员
	 */
	public ResultMessage addStaff(StaffVO vo);
	/*
	 * 用户登录
	 */
	public ResultMessage Login(String ID, String password);
	/*
	 * 注册新用户
	 */
	public ResultMessage Signup(ClientVO vo);
	/*
	 * 注册企业会员
	 */
	public ResultMessage businessRegister (ClientVO vo);
	/*
	 * 注册普通会员
	 */
	public ResultMessage originalRegister (ClientVO vo);
	/*
	 * 查看会员等级信息
	 */
	public void levelLook (String name,ClientVO vo);
	
	/*
	 * 查看会员信息
	 */
	public ClientVO get (String name,ClientVO vo);
	/*
	 * 更新会员等级信息
	 */
	public void levelUpdate (ArrayList<Integer> levelList,int level);
	/*
	 * 更新会员信息
	 */
	public ClientVO update(String name,ClientVO vo);
}
