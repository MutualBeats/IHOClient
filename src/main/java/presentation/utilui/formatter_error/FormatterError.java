package presentation.utilui.formatter_error;

import javafx.stage.Stage;
import presentation.utilui.Dialog;

public class FormatterError{

	public static void showErrorDialog(Stage owner, String error_message) {
		Dialog dialog = new Dialog("Error", owner, error_message);
		dialog.showDialog();
	}
	
	
}
