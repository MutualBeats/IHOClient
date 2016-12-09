package presentation.utilui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import com.sun.javafx.robot.impl.FXRobotHelper;

import config.urlconfig.ManageUIURLConfig;
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
import presentation.utilcontroller.ResultHandle;

/**
 * 
 * UITitl for window
 * 
 * @author heleninsa
 *
 */
@SuppressWarnings("restriction")
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

	public static void startNetErrorWindow(Window owner) {
		startErrorWindow(owner, "网络连接失败，请检查网络");
	}

	public static void startErrorWindow(Window owner, String message) {
		startWindowWithBundle(owner, "警告", ERROR_FXML, ERROR_CSS, new ErrorMessageBundle(message));
	}

	public static void startNoticeWindow(Window owner, String message) {
		startWindowWithBundle(owner, "提示", ERROR_FXML, ERROR_CSS, new ErrorMessageBundle(message));
	}

	public static void startIDInputWindow(Window owner, ResultHandle handle) {
		startWindowWithBundle(owner, "请输入用户名", ManageUIURLConfig.manage_ID_input_fxml(),
				ManageUIURLConfig.manage_ID_input_css(), new IDResourceBundle(handle));
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
		return getScene(event).getWindow();
	}

	/**
	 * 获取当前场景
	 * 
	 * @param event
	 * @return
	 */
	public static Scene getScene(Event event) {
		return ((Node) event.getSource()).getScene();
	}

	/**
	 * 更改当前场景图
	 * 
	 * @param fxml_path
	 *            : 新展示界面路径
	 * @param css_path
	 *            : css样式表
	 * @param frame
	 *            : 展示界面承载
	 */
	public static void changeScene(URL fxml_path, URL css_path, Scene frame) {
		Parent root = null;
		try {
			root = FXMLLoader.load(fxml_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		frame.getStylesheets().clear();
		frame.getStylesheets().add(css_path.toExternalForm());
		frame.setRoot(root);
	}

	public static Scene getSceneByStage(int index) {
		return getStage(index).getScene();
	}

	/**
	 * 这个方法需要谨慎使用
	 * 
	 * @return
	 */
	public static Window getWindowByStage(int index) {
		return getSceneByStage(index).getWindow();
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
		closeWindow(window_to_close);
	}

	public static void closeWindow(Window window_to_close) {
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

	static class IDResourceBundle extends ResourceBundle {
		private ResultHandle handle;
		private final static String HANDLE_KEY = "handle";

		public IDResourceBundle(ResultHandle handle) {
			this.handle = handle;
		}

		@Override
		protected Object handleGetObject(String key) {
			if (HANDLE_KEY.equals(key)) {
				return handle;
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
