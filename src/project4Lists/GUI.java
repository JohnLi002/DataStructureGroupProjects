package project4Lists;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application
{
	
	public void start(Stage primaryStage) throws Exception
	{
		VBox complete = new VBox();
		
		
		Scene scene = new Scene(complete, 400, 600);
		primaryStage.setTitle("Blackjack");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
