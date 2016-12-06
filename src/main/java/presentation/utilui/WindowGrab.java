package presentation.utilui;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

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

	static {
		try {
			CONFIRM_FXML = new URL("file:src/main/resources/ui/utilui/fxml/confirm.fxml");
			CONFIRM_CSS = new URL("file:src/main/resources/ui/utilui/css/confirm.css");
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
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(fxml_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		initStage(stage, root, owner, title, css_path);
	}

	public static void startConfirmWindow(Window owner, Confirm confirm) {		
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(CONFIRM_FXML, new ConfirmResourceBundle(confirm));
		} catch (IOException e) {
			e.printStackTrace();
		}
		initStage(stage, root, owner, "确认", CONFIRM_CSS);
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
	 * 关闭窗口
	 * 
	 * @param event
	 *            ： 窗口关闭触发事件
	 */
	public static void closeWindow(Event event) {
		Window window_to_close = getWindow(event);
		Event.fireEvent(window_to_close, new WindowEvent(window_to_close, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

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
}
