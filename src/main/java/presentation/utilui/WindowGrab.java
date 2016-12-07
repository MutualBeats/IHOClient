package presentation.utilui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import com.sun.javafx.robot.impl.FXRobotHelper;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.stage.WindowEvent;
import presentation.utilcontroller.Confirm;

/**
 * 
 * UITitl for window
 * 
 * @author heleninsa
 *
 */
public class WindowGrab {

	private static URL CONFIRM_FXML;
	private static URL CONFIRM_CSS;
	private static URL ERROR_FXML;
	private static URL ERROR_CSS;
	
	static {
		try {
			CONFIRM_FXML = new URL("file:src/main/resources/ui/utilui/fxml/confirm.fxml");
			CONFIRM_CSS = new URL("file:src/main/resources/ui/utilui/css/confirm.css");
			ERROR_FXML = new URL("file:src/main/resources/ui/utilui/fxml/error.fxml");
			ERROR_CSS = new URL("file:src/main/resources/ui/utilui/css/error.css");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private WindowGrab() {
	}

	/**
	 * 窗口启动
	 * 
	 * @param owner
	 *            ： 父窗口
	 * 
	 * @param title
	 *            ： 窗口标题
	 * @param fxml_path
	 *            ： fxml文件URL
	 * @throws IOException
	 *             ： File not found
	 */
	public static void startWindow(Window owner, String title, URL fxml_path, URL css_path) {
		startWindowWithBundle(owner, title, fxml_path, css_path, null);
	}
	
	public static void startConfirmWindow(Window owner, Confirm confirm) {
		startWindowWithBundle(owner, "确认", CONFIRM_FXML, CONFIRM_CSS, new ConfirmResourceBundle(confirm));
	}
	
	public static void startErrorWindow(Window owner, String message) {
		startWindowWithBundle(owner, "警告", ERROR_FXML, ERROR_CSS, new ErrorMessageBundle(message));
	}
	
	public static void startNoticeWindow(Window owner, String message) {
		startWindowWithBundle(owner, "提示", ERROR_FXML, ERROR_CSS, new ErrorMessageBundle(message));
	}

	public static void startWindowWithBundle(Window owner, String title, URL fxml_path, URL css_path,
			ResourceBundle bundle) {
		Stage stage = new Stage();
		Parent root = null;
		try {
			if (bundle == null) {
				root = FXMLLoader.load(fxml_path);
			} else {
				root = FXMLLoader.load(fxml_path, bundle);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		initStage(stage, root, owner, title, css_path);
	}
	
	/**
	 * 界面初始
	 * 
	 * @param stage
	 * @param root
	 * @param owner
	 * @param title
	 * @param css_path
	 */
	private static void initStage(Stage stage, Parent root, Window owner, String title, URL css_path) {
		Scene scene = new Scene(root);
		scene.getStylesheets().add(css_path.toExternalForm());
		stage.setScene(scene);
		stage.initStyle(StageStyle.UTILITY);
		stage.initModality(Modality.APPLICATION_MODAL);
		// 设置父窗口
		stage.initOwner(owner);
		stage.requestFocus();
		stage.setResizable(false);
		stage.setTitle(title);
		stage.centerOnScreen();
		stage.sizeToScene();
		stage.showAndWait();
	}


	/**
	 * 获取当前窗口
	 * 
	 * @param event
	 *            ： 窗口触发事件
	 * @return
	 */
	public static Window getWindow(Event event) {
		return ((Node) event.getSource()).getScene().getWindow();
	}
	
	/**
	 * 这个方法需要谨慎使用
	 * 
	 * @return
	 */
	public static Window getWindowByStage(int index) {
		Stage stage = getStage(index);
		Window window = stage.getScene().getWindow();
		return window;
	}
	
	/**
	 * 这个方法需要谨慎使用
	 * 
	 * @return
	 */
	public static Stage getStage(int index) {
		ObservableList<Stage> stages = FXRobotHelper.getStages();
		Stage stage = stages.get(index);
		return stage;
	}

	/**
	 * 关闭窗口
	 * 
	 * @param event
	 *            ： 窗口关闭触发事件
	 */
	public static void closeWindow(Event event) {
		Window window_to_close = getWindow(event);
		Event.fireEvent(window_to_close, new WindowEvent(window_to_close, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	
	
	/**
	 * 
	 * Bundle for confirm view
	 * 
	 * @author heleninsa
	 *
	 */
	static class ConfirmResourceBundle extends ResourceBundle {
		private Confirm confirm;
		private final static String CONFIRM_KEY = "confirm";

		public ConfirmResourceBundle(Confirm confirm) {
			this.confirm = confirm;
		}

		@Override
		protected Object handleGetObject(String key) {
			if (CONFIRM_KEY.equals(key)) {
				return confirm;
			}
			return null;
		}

		@Override
		public Enumeration<String> getKeys() {
			return null;
		}

	}
	/**
	 * 
	 * Bundle for error view
	 * 
	 * @author heleninsa
	 *
	 */
	static class ErrorMessageBundle extends ResourceBundle {
		private final static String MESSAGE_KEY = "error_message";
		
		private String error_message;

		public ErrorMessageBundle(String error_message) {
			super();
			this.error_message = error_message;
		}

		@Override
		protected Object handleGetObject(String key) {
			if (MESSAGE_KEY.equals(key)) {
				return error_message;
			}
			return null;
		}

		@Override
		public Enumeration<String> getKeys() {
			return null;
		}

	}
}
