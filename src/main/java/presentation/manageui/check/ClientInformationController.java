package presentation.manageui.check;

import java.net.URL;
import java.util.ResourceBundle;

import vo.user.ClientVO;

public class ClientInformationController extends InformationLookController{
	
	private ClientVO clientInfo;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clientInfo = (ClientVO) resources.getObject("info");
		init();
	}
	
	private void init() {
		
	}

	@Override
	public void confirm() {
		// TODO Auto-generated method stub
		
	}

}
