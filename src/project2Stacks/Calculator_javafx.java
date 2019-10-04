package project2Stacks;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator_javafx
{
	
	public void start(Stage primaryStage) throws Exception
	{
		VBox complete = new VBox();
		complete.setPrefWidth(300);
		complete.setPrefHeight(410);
		complete.setAlignment(Pos.TOP_CENTER);
		complete.setPadding(new Insets(10,10,10,10));
		
			TextField screen = new TextField();
			complete.getChildren().add(screen);
			screen.setPrefHeight(60);
			
			VBox buttons = new VBox();
			complete.getChildren().add(buttons);
			buttons.setPrefHeight(320);
			buttons.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(complete, 300, 410);
		primaryStage.setTitle("CALCULATOR ~ AJ, John, & Tony");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
