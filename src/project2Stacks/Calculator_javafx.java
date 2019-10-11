package project2Stacks;

/*
 * Group Members: John Li, Tony Lei, AJ Kreuzkamp
 */

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
		aButt.setPrefWidth(70);
		aButt.setPrefHeight(64);
		aButt.setFont(Font.font("System", FontWeight.BOLD, 24));
		aButt.setAlignment(Pos.CENTER);
		aButt.setTextFill(Paint.valueOf("333333"));
		aButt.setBackground( new Background(new BackgroundFill(
		/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
	}
	private Button mostRecent = new Button();
	private void setMostRecent(Button aButt)
	{
		if( !(mostRecent.getTextFill().equals( Paint.valueOf("000000") )) )
		{
			mostRecent.setTextFill(Paint.valueOf("333333"));
			mostRecent.setBackground( new Background(new BackgroundFill(
			/*cont.*/	Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY )) );
		}
		aButt.setTextFill(Paint.valueOf("222222"));
		aButt.setBackground( new Background(new BackgroundFill(
		/*cont.*/	Paint.valueOf("cecece"), CornerRadii.EMPTY, Insets.EMPTY )) );
		mostRecent = aButt;
	}
	private boolean checkBalance(String aString)
	{
		/*	@returns TRUE if the string still needs more ")"
		 *	@returns FALSE if the string has an equal number of "(" and ")"
		 */
		int count_open = 0;
		int count_close = 0;
		String aStringTemp = aString;
		while(!aStringTemp.isEmpty())
		{
			if( aStringTemp.substring(0,1).contentEquals("(") )
			{
				count_open++;
			}
			else if( aStringTemp.substring(0,1).contentEquals(")") )
			{
				count_close++;
			}
			aStringTemp = aStringTemp.substring(1, (aStringTemp.length()) );
		}
		if (count_open > count_close)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void start(Stage primaryStage) throws Exception
	{
		VBox complete = new VBox();
		complete.setPrefWidth(320);
		complete.setPrefHeight(410);
		complete.setAlignment(Pos.TOP_CENTER);
		complete.setPadding(new Insets(10,10,10,10));
		complete.setBackground( new Background(new BackgroundFill(
				Paint.valueOf("696969"), CornerRadii.EMPTY, Insets.EMPTY )) );
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
					standard(button_C);
					button_C.setOnAction( e -> {
						screen.setText("");
						setMostRecent(button_C);
					});
					
					Button button_less = new Button("<");
					buttons_1.getChildren().add(button_less);
					standard(button_less);
					//	button_less.setOnAction needs to be after other objects have been created
					
					Button button_Q = new Button("Q");
					buttons_1.getChildren().add(button_Q);
					standard(button_Q);
					button_Q.setOnAction( e -> {
						screen.setText("");
						setMostRecent(button_Q);
					});
					
					Button button_div = new Button("/");
					buttons_1.getChildren().add(button_div);
					standard(button_div);
					button_div.setPrefWidth(70);
					button_div.setOnAction( e -> {
						screen.setText( screen.getText() + "/" );
						setMostRecent(button_div);
					});
				
				HBox buttons_2 = new HBox();
				buttons.getChildren().add(buttons_2);
				buttons_2.setPrefHeight(64);
				buttons_2.setAlignment(Pos.TOP_CENTER);
				buttons_2.setSpacing(5);
				
					Button button_7 = new Button("7");
					buttons_2.getChildren().add(button_7);
					standard(button_7);
					button_7.setOnAction( e -> {
						screen.setText( screen.getText() + "7" );
						setMostRecent(button_7);
					});
					
					Button button_8 = new Button("8");
					buttons_2.getChildren().add(button_8);
					standard(button_8);
					button_8.setOnAction( e -> {
						screen.setText( screen.getText() + "8" );
						setMostRecent(button_8);
					});
					
					Button button_9 = new Button("9");
					buttons_2.getChildren().add(button_9);
					standard(button_9);
					button_9.setOnAction( e -> {
						screen.setText( screen.getText() + "9" );
						setMostRecent(button_9);
					});
					
					Button button_mult = new Button("*");
					buttons_2.getChildren().add(button_mult);
					standard(button_mult);
					button_mult.setOnAction( e -> {
						screen.setText( screen.getText() + "*" );
						setMostRecent(button_mult);
					});
				
				HBox buttons_3 = new HBox();
				buttons.getChildren().add(buttons_3);
				buttons_3.setPrefHeight(64);
				buttons_3.setAlignment(Pos.TOP_CENTER);
				buttons_3.setSpacing(5);
				
					Button button_4 = new Button("4");
					buttons_3.getChildren().add(button_4);
					standard(button_4);
					button_4.setOnAction( e -> {
						screen.setText( screen.getText() + "4" );
						setMostRecent(button_4);
					});
					
					Button button_5 = new Button("5");
					buttons_3.getChildren().add(button_5);
					standard(button_5);
					button_5.setOnAction( e -> {
						screen.setText( screen.getText() + "5" );
						setMostRecent(button_5);
					});
					
					Button button_6 = new Button("6");
					buttons_3.getChildren().add(button_6);
					standard(button_6);
					button_6.setOnAction( e -> {
						screen.setText( screen.getText() + "6" );
						setMostRecent(button_6);
					});
					
					Button button_sub = new Button("-");
					buttons_3.getChildren().add(button_sub);
					standard(button_sub);
					button_sub.setOnAction( e -> {
						screen.setText( screen.getText() + "-" );
						setMostRecent(button_sub);
					});
				
				HBox buttons_4 = new HBox();
				buttons.getChildren().add(buttons_4);
				buttons_4.setPrefHeight(64);
				buttons_4.setAlignment(Pos.TOP_CENTER);
				buttons_4.setSpacing(5);
				
					Button button_1 = new Button("1");
					buttons_4.getChildren().add(button_1);
					standard(button_1);
					button_1.setOnAction( e -> {
						screen.setText( screen.getText() + "1" );
						setMostRecent(button_1);
					});
					
					Button button_2 = new Button("2");
					buttons_4.getChildren().add(button_2);
					standard(button_2);
					button_2.setOnAction( e -> {
						screen.setText( screen.getText() + "2" );
						setMostRecent(button_2);
					});
					
					Button button_3 = new Button("3");
					buttons_4.getChildren().add(button_3);
					standard(button_3);
					button_3.setOnAction( e -> {
						screen.setText( screen.getText() + "3" );
						setMostRecent(button_3);
					});
					
					Button button_add = new Button("+");
					buttons_4.getChildren().add(button_add);
					standard(button_add);
					button_add.setOnAction( e -> {
						screen.setText( screen.getText() + "+" );
						setMostRecent(button_add);
					});
				
				HBox buttons_5 = new HBox();
				buttons.getChildren().add(buttons_5);
				buttons_5.setPrefHeight(64);
				buttons_5.setAlignment(Pos.TOP_CENTER);
				buttons_5.setSpacing(5);
				
					Button button_0 = new Button("0");
					buttons_5.getChildren().add(button_0);
					standard(button_0);
					button_0.setOnAction( e -> {
						screen.setText( screen.getText() + "0" );
						setMostRecent(button_0);
					});
					
					Button button_open = new Button("(");
					buttons_5.getChildren().add(button_open);
					standard(button_open);
					
					Button button_close = new Button(")");
					buttons_5.getChildren().add(button_close);
					standard(button_close);
					button_close.setTextFill(Paint.valueOf("000000"));
					button_close.setBackground( new Background(new BackgroundFill(
							Paint.valueOf("f3a0a0"), CornerRadii.EMPTY, Insets.EMPTY)));
					
					//	I need to interact with the buttons AFTER they have been created
					button_open.setOnAction( e -> {
						screen.setText( screen.getText() + "(" );
						button_close.setTextFill(Paint.valueOf("333333"));
						button_close.setBackground( new Background(new BackgroundFill(
								Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY)));
						setMostRecent(button_open);
					});
					button_close.setOnAction( e -> {
						if (!button_close.getTextFill().equals(Paint.valueOf("000000")))
						{
							screen.setText( screen.getText() + ")" );
							setMostRecent(button_close);
							if( !(checkBalance( screen.getText()) ) )
							{	//	if balanced parenthesis
								button_close.setTextFill(Paint.valueOf("000000"));
								button_close.setBackground( new Background(new BackgroundFill(
										Paint.valueOf("f3a0a0"), CornerRadii.EMPTY, Insets.EMPTY)));
							}
						}
					});
					
					Button button_equals = new Button("=");
					buttons_5.getChildren().add(button_equals);
					standard(button_equals);
					button_equals.setOnAction( e -> {
						//	call class/method to handle calculations
						screen.setText( "  =  " + CalculatingAnswer.evaluate(screen.getText()) );
						setMostRecent(button_equals);
					});
					
					//	BACKSPACE BUTTON
					button_less.setOnAction( e -> {
						if(screen.getText().length() > 0)
						{
							if ( screen.getText().substring( screen.getText().length()-1 ).contentEquals("(") )
							{
								if ( button_close.getTextFill().equals(Paint.valueOf("333333")) )
								{
									if (checkBalance(screen.getText()))
									{
										button_close.setTextFill(Paint.valueOf("000000"));
										button_close.setBackground( new Background(new BackgroundFill(
												Paint.valueOf("f3a0a0"), CornerRadii.EMPTY, Insets.EMPTY)));
									}
								}
							}
							else if ( screen.getText().substring( screen.getText().length()-1 ).contentEquals(")") )
							{
								if (button_close.getTextFill().equals(Paint.valueOf("000000")))
								{
									button_close.setTextFill(Paint.valueOf("333333"));
									button_close.setBackground( new Background(new BackgroundFill(
											Paint.valueOf("f3f3f3"), CornerRadii.EMPTY, Insets.EMPTY)));
								}
							}
							screen.setText( screen.getText().substring(0, screen.getText().length()-1) );
						}
						setMostRecent(button_less);
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
