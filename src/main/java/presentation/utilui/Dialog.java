package presentation.utilui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * Warning Dialog
 * 
 * @author heleninsa
 *
 */
public class Dialog extends Stage implements EventHandler<ActionEvent>{
	
	public Dialog(String title, Stage owner, String message) {  
        setTitle(title);  
        initStyle(StageStyle.UTILITY);  
        initModality(Modality.APPLICATION_MODAL);  
        initOwner(owner);  
        setResizable(false);  
        init(message);
    } 
	
	/**
	 * Style init
	 * 
	 * @param message : Message to show
	 */
	private void init(String message) {
		VBox vBox = new VBox();
		Scene scene = new Scene(vBox);
		setScene(scene);
		vBox.setPadding(new Insets(10));
		vBox.setSpacing(10);
		Button ok = new Button("确认");
		ok.setAlignment(Pos.CENTER);
		ok.setOnAction(this);
		BorderPane bp = new BorderPane();  
		bp.setCenter(ok);
		Text error_message = new Text(message);
		error_message.setTextAlignment(TextAlignment.CENTER);
		error_message.setWrappingWidth(250);
		error_message.setFont(new Font(17));
		BorderPane mbp = new BorderPane();  
		mbp.setPrefSize(250, 70);
		mbp.setCenter(error_message);
		vBox.getChildren().addAll(mbp, bp);
		
	}
	
	public void showDialog(){
		sizeToScene();
		centerOnScreen();
		showAndWait();
	}

	@Override
	public void handle(ActionEvent event) {
		this.close();
	}
	

}
