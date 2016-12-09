package presentation.utilui;

import javafx.stage.Window;
import util.resultmessage.ResultMessage_User;

public class ResultHandle {
	
	/**
	 * 检查人员注册结果
	 * 
	 * @param result ： 注册结果
	 * @param window ： 信息承载窗口
	 */
	public static void checkResult(ResultMessage_User result, Window window) {
		if (result == ResultMessage_User.Net_Error) {
			WindowGrab.startErrorWindow(window, "网络异常，请检查网络连接");
		} else if (result == ResultMessage_User.Register_Success) {
			WindowGrab.startNoticeWindow(window, "注册用户成功");
		} else {
			WindowGrab.startErrorWindow(window, "注册用户失败");
		}
	}
	
}
