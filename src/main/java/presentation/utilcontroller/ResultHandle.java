package presentation.utilcontroller;

import javafx.stage.Window;
import util.resultmessage.ResultMessage_Verify;

public interface ResultHandle {
	
	public void handleResult(String user_name, ResultMessage_Verify result, Window window);
	
}
