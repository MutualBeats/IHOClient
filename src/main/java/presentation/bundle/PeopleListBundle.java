/**
 * @author huangxiao
 * @version 2016年12月18日
 */
package presentation.bundle;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import vo.user.ClientVO;
import vo.user.ManagerVO;
import vo.user.MarketerVO;
import vo.user.StaffVO;

public class PeopleListBundle extends ResourceBundle {

	ArrayList<ClientVO> clientVOs;

	ArrayList<StaffVO> staffVOs;

	ArrayList<MarketerVO> marketerVOs;

	ManagerVO managerVO;

	private final static String CLIENT = "client";
	private final static String STAFF = "staff";
	private final static String MARKETER = "marketer";
	private final static String MANAGER = "manager";

	/**
	 * @param clientVOs
	 * @param staffVOs
	 * @param marketerVOs
	 * @param managerVO
	 */
	public PeopleListBundle(ArrayList<ClientVO> clientVOs, ArrayList<StaffVO> staffVOs,
			ArrayList<MarketerVO> marketerVOs, ManagerVO managerVO) {
		super();
		this.clientVOs = clientVOs;
		this.staffVOs = staffVOs;
		this.marketerVOs = marketerVOs;
		this.managerVO = managerVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ResourceBundle#handleGetObject(java.lang.String)
	 */
	@Override
	protected Object handleGetObject(String key) {
		if (CLIENT.equals(key)) {
			return clientVOs;
		} else if (STAFF.equals(key)) {
			return staffVOs;
		} else if (MANAGER.equals(key)) {
			return managerVO;
		} else if (MARKETER.equals(key)) {
			return marketerVOs;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.ResourceBundle#getKeys()
	 */
	@Override
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return null;
	}

}
