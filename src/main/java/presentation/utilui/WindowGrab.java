package presentation.utilui;

import java.io.IOException;
import java.net.URL;

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

/**
 * 
 * UITitl for window
 * 
 * @author heleninsa
 *
 */
public class WindowGrab {

	/**
	 * 窗口启动
	 * 
	 * @param owner
	 *            ： 父窗口
	 * @param fxml_path
	 *            ： fxml文件URL
	 * @throws IOException
	 *             ： File not found
	 */
	public static void startWindow(Window owner, URL fxml_path,URL css_path){
		Stage stage = new Stage();
		Parent root = null;
		try {
			root = FXMLLoader.load(fxml_path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(root);
		scene.getStylesheets().add(css_path.toExternalForm());
		stage.setScene(scene);
		stage.initStyle(StageStyle.UTILITY);
		stage.initModality(Modality.APPLICATION_MODAL);
		// 设置父窗口
		stage.initOwner(owner);
		stage.requestFocus();
		stage.setResizable(false);
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
	 * 关闭窗口
	 * 
	 * @param event
	 *            ： 窗口关闭触发事件
	 */
	public static void closeWindow(Event event) {
		Window window_to_close = getWindow(event);
		Event.fireEvent(window_to_close, new WindowEvent(window_to_close, WindowEvent.WINDOW_CLOSE_REQUEST));
	}
}
