package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import vo.user.MarketerVO;

public class MarketerInformationController extends InformationLookController{

	private MarketerVO info;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (MarketerVO) resources.getObject("info");
		init();
	}

	private void init() {
		this.user_name.setText(info.marketerID);
		this.name.setText(info.marketerName);
		this.type.setText("网站管理人员");
		this.phone.setText(info.contactWay);
	}
	

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

}
