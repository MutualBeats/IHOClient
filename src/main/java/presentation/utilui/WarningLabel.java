package presentation.utilui;

import javafx.scene.control.Label;

public class WarningLabel {


	public static boolean checkWarningBefore(Label label) {
		String warning = label.getText();
		if(warning.length() != 0) {
			label.setText("");
			return true;
		}
		return false;
	}

	
}
