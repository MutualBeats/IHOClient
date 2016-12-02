package presentation.manageui.addpeople;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AddPeopleMenu {
	public static Stage stage;
	public void start(Stage stage)throws Exception{
		this.stage=stage;
		 Parent root = FXMLLoader.load(getClass().getResource("addpeoplemenu.fxml"));  
		  
	     Scene scene = new Scene(root, 1000 , 750);  
	     scene.getStylesheets().add(AddPeople.class.getResource("addpeoplemenu.css").toExternalForm());
	     stage.initStyle(StageStyle.DECORATED);  
	     stage.setScene(scene);  
	     stage.setTitle("添加人员");  
	     stage.show();
	}
}
