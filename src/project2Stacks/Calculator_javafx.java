package project2Stacks;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Calculator_javafx extends Application
{
	private void standard(Button aButt)
	{
		/*
		 * This is something I am adding after the fact in order to simplify
		 * the code below/remove +-a hundred lines of code.
		 */
	}
	
	public void start(Stage primaryStage) throws Exception
	{
		VBox complete = new VBox();
		complete.setPrefWidth(320);
		complete.setPrefHeight(410);
		complete.setAlignment(Pos.TOP_CENTER);
		complete.setPadding(new Insets(10,10,10,10));
		complete.setBackground( new Background(new BackgroundFill(
				Paint.valueOf("a2a2a2"), CornerRadii.EMPTY, Insets.EMPTY )) );
		complete.setSpacing(10);
		
			TextField screen = new TextField();
			complete.getChildren().add(screen);
			screen.setPrefHeight(60);
			screen.setAlignment(Pos.CENTER_RIGHT);
			screen.setEditable(false);
			screen.setBackground( new Background(new BackgroundFill(
					Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
			screen.setFont( Font.font("System", FontWeight.BOLD, 18));
			
			VBox buttons = new VBox();
			complete.getChildren().add(buttons);
			buttons.setPrefHeight(320);
			buttons.setAlignment(Pos.TOP_CENTER);
			buttons.setSpacing(5);
			
				HBox buttons_1 = new HBox();
				buttons.getChildren().add(buttons_1);
				buttons_1.setPrefHeight(64);
				buttons_1.setAlignment(Pos.TOP_CENTER);
				buttons_1.setSpacing(5);
				
					Button button_C = new Button("C");
					buttons_1.getChildren().add(button_C);
					button_C.setPrefWidth(70);
					button_C.setPrefHeight(64);
					button_C.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_C.setAlignment(Pos.CENTER);
					button_C.setTextFill(Paint.valueOf("333333"));
					button_C.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_C.setOnAction( e -> {
						screen.setText("");
					});
					
					Button button_less = new Button("<");
					buttons_1.getChildren().add(button_less);
					button_less.setPrefWidth(70);
					button_less.setPrefHeight(64);
					button_less.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_less.setAlignment(Pos.CENTER);
					button_less.setTextFill(Paint.valueOf("333333"));
					button_less.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_less.setOnAction( e -> {
						if(screen.getText().length() > 0)
						{
							screen.setText( screen.getText().substring(0, screen.getText().length()-1) );
						}
					});
					
					Button button_Q = new Button("Q");
					buttons_1.getChildren().add(button_Q);
					button_Q.setPrefWidth(70);
					button_Q.setPrefHeight(64);
					button_Q.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_Q.setAlignment(Pos.CENTER);
					button_Q.setTextFill(Paint.valueOf("333333"));
					button_Q.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_Q.setOnAction( e -> {
						screen.setText("");
					});
					
					Button button_div = new Button("/");
					buttons_1.getChildren().add(button_div);
					button_div.setPrefWidth(70);
					button_div.setPrefHeight(64);
					button_div.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_div.setAlignment(Pos.CENTER);
					button_div.setTextFill(Paint.valueOf("333333"));
					button_div.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_div.setOnAction( e -> {
						screen.setText( screen.getText() + "/" );
					});
				
				HBox buttons_2 = new HBox();
				buttons.getChildren().add(buttons_2);
				buttons_2.setPrefHeight(64);
				buttons_2.setAlignment(Pos.TOP_CENTER);
				buttons_2.setSpacing(5);
				
					Button button_7 = new Button("7");
					buttons_2.getChildren().add(button_7);
					button_7.setPrefWidth(70);
					button_7.setPrefHeight(64);
					button_7.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_7.setAlignment(Pos.CENTER);
					button_7.setTextFill(Paint.valueOf("333333"));
					button_7.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_7.setOnAction( e -> {
						screen.setText( screen.getText() + "7" );
					});
					
					Button button_8 = new Button("8");
					buttons_2.getChildren().add(button_8);
					button_8.setPrefWidth(70);
					button_8.setPrefHeight(64);
					button_8.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_8.setAlignment(Pos.CENTER);
					button_8.setTextFill(Paint.valueOf("333333"));
					button_8.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_8.setOnAction( e -> {
						screen.setText( screen.getText() + "8" );
					});
					
					Button button_9 = new Button("9");
					buttons_2.getChildren().add(button_9);
					button_9.setPrefWidth(70);
					button_9.setPrefHeight(64);
					button_9.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_9.setAlignment(Pos.CENTER);
					button_9.setTextFill(Paint.valueOf("333333"));
					button_9.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_9.setOnAction( e -> {
						screen.setText( screen.getText() + "9" );
					});
					
					Button button_mult = new Button("*");
					buttons_2.getChildren().add(button_mult);
					button_mult.setPrefWidth(70);
					button_mult.setPrefHeight(64);
					button_mult.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_mult.setAlignment(Pos.CENTER);
					button_mult.setTextFill(Paint.valueOf("333333"));
					button_mult.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_mult.setOnAction( e -> {
						screen.setText( screen.getText() + "*" );
					});
				
				HBox buttons_3 = new HBox();
				buttons.getChildren().add(buttons_3);
				buttons_3.setPrefHeight(64);
				buttons_3.setAlignment(Pos.TOP_CENTER);
				buttons_3.setSpacing(5);
				
					Button button_4 = new Button("4");
					buttons_3.getChildren().add(button_4);
					button_4.setPrefWidth(70);
					button_4.setPrefHeight(64);
					button_4.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_4.setAlignment(Pos.CENTER);
					button_4.setTextFill(Paint.valueOf("333333"));
					button_4.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_4.setOnAction( e -> {
						screen.setText( screen.getText() + "4" );
					});
					
					Button button_5 = new Button("5");
					buttons_3.getChildren().add(button_5);
					button_5.setPrefWidth(70);
					button_5.setPrefHeight(64);
					button_5.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_5.setAlignment(Pos.CENTER);
					button_5.setTextFill(Paint.valueOf("333333"));
					button_5.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_5.setOnAction( e -> {
						screen.setText( screen.getText() + "5" );
					});
					
					Button button_6 = new Button("6");
					buttons_3.getChildren().add(button_6);
					button_6.setPrefWidth(70);
					button_6.setPrefHeight(64);
					button_6.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_6.setAlignment(Pos.CENTER);
					button_6.setTextFill(Paint.valueOf("333333"));
					button_6.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_6.setOnAction( e -> {
						screen.setText( screen.getText() + "6" );
					});
					
					Button button_sub = new Button("-");
					buttons_3.getChildren().add(button_sub);
					button_sub.setPrefWidth(70);
					button_sub.setPrefHeight(64);
					button_sub.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_sub.setAlignment(Pos.CENTER);
					button_sub.setTextFill(Paint.valueOf("333333"));
					button_sub.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_sub.setOnAction( e -> {
						screen.setText( screen.getText() + "-" );
					});
				
				HBox buttons_4 = new HBox();
				buttons.getChildren().add(buttons_4);
				buttons_4.setPrefHeight(64);
				buttons_4.setAlignment(Pos.TOP_CENTER);
				buttons_4.setSpacing(5);
				
					Button button_1 = new Button("1");
					buttons_4.getChildren().add(button_1);
					button_1.setPrefWidth(70);
					button_1.setPrefHeight(64);
					button_1.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_1.setAlignment(Pos.CENTER);
					button_1.setTextFill(Paint.valueOf("333333"));
					button_1.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_1.setOnAction( e -> {
						screen.setText( screen.getText() + "1" );
					});
					
					Button button_2 = new Button("2");
					buttons_4.getChildren().add(button_2);
					button_2.setPrefWidth(70);
					button_2.setPrefHeight(64);
					button_2.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_2.setAlignment(Pos.CENTER);
					button_2.setTextFill(Paint.valueOf("333333"));
					button_2.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_2.setOnAction( e -> {
						screen.setText( screen.getText() + "2" );
					});
					
					Button button_3 = new Button("3");
					buttons_4.getChildren().add(button_3);
					button_3.setPrefWidth(70);
					button_3.setPrefHeight(64);
					button_3.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_3.setAlignment(Pos.CENTER);
					button_3.setTextFill(Paint.valueOf("333333"));
					button_3.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_3.setOnAction( e -> {
						screen.setText( screen.getText() + "3" );
					});
					
					Button button_add = new Button("+");
					buttons_4.getChildren().add(button_add);
					button_add.setPrefWidth(70);
					button_add.setPrefHeight(64);
					button_add.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_add.setAlignment(Pos.CENTER);
					button_add.setTextFill(Paint.valueOf("333333"));
					button_add.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_add.setOnAction( e -> {
						screen.setText( screen.getText() + "+" );
					});
				
				HBox buttons_5 = new HBox();
				buttons.getChildren().add(buttons_5);
				buttons_5.setPrefHeight(64);
				buttons_5.setAlignment(Pos.TOP_CENTER);
				buttons_5.setSpacing(5);
				
					Button button_0 = new Button("0");
					buttons_5.getChildren().add(button_0);
					button_0.setPrefWidth(70);
					button_0.setPrefHeight(64);
					button_0.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_0.setAlignment(Pos.CENTER);
					button_0.setTextFill(Paint.valueOf("333333"));
					button_0.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_0.setOnAction( e -> {
						screen.setText( screen.getText() + "0" );
					});
					
					Button button_open = new Button("(");
					buttons_5.getChildren().add(button_open);
					button_open.setPrefWidth(70);
					button_open.setPrefHeight(64);
					button_open.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_open.setAlignment(Pos.CENTER);
					button_open.setTextFill(Paint.valueOf("333333"));
					button_open.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					
					Button button_close = new Button(")");
					buttons_5.getChildren().add(button_close);
					button_close.setPrefWidth(70);
					button_close.setPrefHeight(64);
					button_close.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_close.setAlignment(Pos.CENTER);
					button_close.setTextFill(Paint.valueOf("333333"));
					button_close.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3c4c4"), CornerRadii.EMPTY, Insets.EMPTY )) );
					
					//	I need to interact with the buttons AFTER they have been created
					button_open.setOnAction( e -> {
						screen.setText( screen.getText() + "(" );
						button_close.setTextFill(Paint.valueOf("000000"));
						button_close.setBackground( new Background(new BackgroundFill(
								Paint.valueOf("d0d0d0"), CornerRadii.EMPTY, Insets.EMPTY)));
					});
					button_close.setOnAction( e -> {
						if (!button_close.getTextFill().equals(Paint.valueOf("333333")))
						{
							screen.setText( screen.getText() + ")" );
						}
					});
					
					Button button_equals = new Button("=");
					buttons_5.getChildren().add(button_equals);
					button_equals.setPrefWidth(70);
					button_equals.setPrefHeight(64);
					button_equals.setFont(Font.font("System", FontWeight.BOLD, 24));
					button_equals.setAlignment(Pos.CENTER);
					button_equals.setTextFill(Paint.valueOf("333333"));
					button_equals.setBackground( new Background(new BackgroundFill(
					/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
					button_equals.setOnAction( e -> {
						screen.setText( screen.getText() + "=" );
					});
		
		Scene scene = new Scene(complete, 320, 410);
		primaryStage.setTitle("CALCULATOR ~ AJ, John, & Tony");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
