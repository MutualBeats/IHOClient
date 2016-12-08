package presentation.clientui.evaluatehotel;

import java.net.MalformedURLException;
import java.net.URL;

public class EvaluateHotelController {
	private static URL LOGIN_FXML;
    private static URL LOGIN_CSS;
    
    static{
    	try {
			LOGIN_FXML=new URL("file:src/main/resources/ui/loginui/fxml/login.fxml");
			LOGIN_CSS=new URL("file:src/main/resources/ui/loginui/css/login.css");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
