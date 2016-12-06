package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import vo.user.ClientVO;

public class ClientInformationController extends InformationLookController{
	
	
	
	private ClientVO info;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		info = (ClientVO) resources.getObject("info");
		init();
	}
	
	private void init() {
		this.user_name.setText(info.clientID);
		this.name.setText(info.clientName);
		this.type.setText("客户");
		this.phone.setText(info.contactWay);
	}

	@Override
	public void confirm() {
		
	}
	
}
