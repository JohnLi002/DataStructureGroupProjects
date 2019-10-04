package project2Stacks;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Calculator_javafx extends Application
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
			
				HBox buttons_1 = new HBox();
				buttons.getChildren().add(buttons_1);
				buttons_1.setPrefHeight(64);
				buttons_1.setAlignment(Pos.TOP_CENTER);
				
					Button button_C = new Button("C");
					buttons_1.getChildren().add(button_C);
					button_C.setPrefWidth(70);
					button_C.setPrefHeight(64);
					button_C.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_C.setAlignment(Pos.CENTER);
				
				HBox buttons_2 = new HBox();
				buttons.getChildren().add(buttons_2);
				buttons_2.setPrefHeight(64);
				buttons_2.setAlignment(Pos.TOP_CENTER);
				
				HBox buttons_3 = new HBox();
				buttons.getChildren().add(buttons_3);
				buttons_3.setPrefHeight(64);
				buttons_3.setAlignment(Pos.TOP_CENTER);
				
				HBox buttons_4 = new HBox();
				buttons.getChildren().add(buttons_4);
				buttons_4.setPrefHeight(64);
				buttons_4.setAlignment(Pos.TOP_CENTER);
				
				HBox buttons_5 = new HBox();
				buttons.getChildren().add(buttons_5);
				buttons_5.setPrefHeight(64);
				buttons_5.setAlignment(Pos.TOP_CENTER);
		
		Scene scene = new Scene(complete, 300, 410);
		primaryStage.setTitle("CALCULATOR ~ AJ, John, & Tony");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
