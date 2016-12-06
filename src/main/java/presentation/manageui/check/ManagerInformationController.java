package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import vo.user.ManagerVO;

public class ManagerInformationController extends InformationLookController {

	private ManagerVO info;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ManagerVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.managerID);
		this.name.setText(info.managerName);
		this.type.setText("网站管理人员");
		this.phone.setText(info.contactWay);
	}

	@Override
	public void confirm() {
		
	}
	

}
