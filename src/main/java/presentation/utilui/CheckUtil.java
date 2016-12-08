package presentation.utilui;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CheckUtil {


	public static boolean checkWarningBefore(Label label) {
		String warning = label.getText();
		if(warning.length() != 0) {
			label.setText("");
			return true;
		}
		return false;
	}
	
	public static boolean checkSelect(ComboBox<?> comboBox) {
		return comboBox.getSelectionModel().getSelectedIndex() != -1;
	}
	
	public static boolean checkText(TextField text) {
		return text.getText().length() == 0;
	}
	
}
