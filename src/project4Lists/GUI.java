package project4Lists;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



public class GUI extends Application
{
	private String rankTranslator(Rank rank)
	{
		if(rank.equals(Rank.ACE)) {return "A";}
		else if(rank.equals(Rank.TWO)) {return "2";}
		else if(rank.equals(Rank.THREE)) {return "3";}
		else if(rank.equals(Rank.FOUR)) {return "4";}
		else if(rank.equals(Rank.FIVE)) {return "5";}
		else if(rank.equals(Rank.SIX)) {return "6";}
		else if(rank.equals(Rank.SEVEN)) {return "7";}
		else if(rank.equals(Rank.EIGHT)) {return "8";}
		else if(rank.equals(Rank.NINE)) {return "9";}
		else if(rank.equals(Rank.TEN)) {return "10";}
		else if(rank.equals(Rank.JACK)) {return "J";}
		else if(rank.equals(Rank.QUEEN)) {return "Q";}
		else if(rank.equals(Rank.KING)) {return "K";}
		else {return "lol";}
	}
	private void seeCards(HBox cardWhere, Card[] cards)
	{
		cardWhere.getChildren().clear();
		for (Card temp : cards)
		{
			HBox cardstock = new HBox();
			cardstock.setMinWidth(70); 	cardstock.setMaxWidth(70);
			cardstock.setMinHeight(100); 	cardstock.setMaxHeight(100);
			cardstock.setAlignment(Pos.CENTER);
			cardstock.setBackground( new Background(new BackgroundFill(
					Paint.valueOf("ffffff"), CornerRadii.EMPTY, Insets.EMPTY )) );
			TextField cardstock_rank = new TextField();
			cardstock_rank.setText( rankTranslator(temp.getRank()) );
			cardstock_rank.setMinWidth(30); cardstock_rank.setMaxWidth(30);
			cardstock_rank.setMinHeight(30); cardstock_rank.setMaxHeight(30);
			cardstock_rank.setEditable(false);
			cardstock.getChildren().add(cardstock_rank);
			VBox cardstock_picHold = new VBox();
			cardstock_picHold.setMinWidth(30); cardstock_picHold.setMaxWidth(30);
			cardstock_picHold.setMinHeight(30); cardstock_picHold.setMaxHeight(30);
			cardstock.getChildren().add(cardstock_picHold);
			try {
				Image image = new Image( new FileInputStream(""+temp.getSuite()+".PNG") );
				ImageView imageview = new ImageView(image);
				imageview.setPreserveRatio(true);
				imageview.setFitWidth(cardstock_picHold.getMinWidth());
				cardstock_picHold.getChildren().add(imageview);
			}
			catch (IOException e)
			{
				break;
			}
			cardWhere.getChildren().add(cardstock);
		}
	}
	
	public void start(Stage primaryStage) throws Exception
	{
		Game blackjack = new Game();
		
		HBox complete = new HBox();
		complete.setAlignment(Pos.CENTER_RIGHT);
		
			VBox table = new VBox();
			complete.getChildren().add(table);
			table.setAlignment(Pos.TOP_CENTER);
			table.setSpacing(50);
			table.setPadding(new Insets(10,10,10,10));
			
				VBox dealer = new VBox();
				table.getChildren().add(dealer);
				dealer.setBackground( new Background(new BackgroundFill(
				/**/	Paint.valueOf("e28282"), CornerRadii.EMPTY, Insets.EMPTY )) );
				dealer.setPrefWidth(800);
				dealer.setMinHeight(200); dealer.setMaxHeight(200);
				dealer.setAlignment(Pos.TOP_CENTER);
				
					TextField dealer_nameplate = new TextField("Dealer");
					dealer.getChildren().add(dealer_nameplate);
					dealer_nameplate.setMinHeight(75);	dealer_nameplate.setMaxHeight(75);
					dealer_nameplate.setFont(Font.font("System", FontWeight.BOLD, 48));
					dealer_nameplate.setAlignment(Pos.CENTER);
					dealer_nameplate.setBackground( dealer.getBackground() );
					dealer_nameplate.setEditable(false);
					
					HBox dealer_cards = new HBox();
					dealer.getChildren().add(dealer_cards);
					dealer_cards.setMinWidth(50);
					dealer_cards.setMinHeight(100);
					dealer_cards.setBackground( dealer.getBackground() );
					dealer_cards.setAlignment(Pos.CENTER);
					dealer_cards.setSpacing(5);
				
				VBox player = new VBox();
				table.getChildren().add(player);
				player.setBackground( new Background(new BackgroundFill(
				/**/	Paint.valueOf("8282e2"), CornerRadii.EMPTY, Insets.EMPTY )) );
				player.setPrefWidth(800);
				player.setMinHeight(230); player.setMaxHeight(230);
				player.setAlignment(Pos.TOP_CENTER);
				
					TextField player_nameplate = new TextField("Player");
					player.getChildren().add(player_nameplate);
					player_nameplate.setMinHeight(75);	dealer_nameplate.setMaxHeight(75);
					player_nameplate.setFont(Font.font("System", FontWeight.BOLD, 48));
					player_nameplate.setAlignment(Pos.CENTER);
					player_nameplate.setBackground( player.getBackground() );
					player_nameplate.setEditable(false);
					
					HBox player_cards = new HBox();
					player.getChildren().add(player_cards);
					player_cards.setMinWidth(50);
					player_cards.setMinHeight(130);
					player_cards.setBackground( player.getBackground() );
					player_cards.setAlignment(Pos.CENTER);
					player_cards.setSpacing(5);
			
			VBox buttons = new VBox();
			complete.getChildren().add(buttons);
			buttons.setMinWidth(200); buttons.setMaxWidth(200);
			buttons.setMinHeight(500); buttons.setMaxHeight(500);
			buttons.setBackground( new Background(new BackgroundFill(
					Paint.valueOf("b2b2b2"), CornerRadii.EMPTY, Insets.EMPTY )) );
			buttons.setAlignment(Pos.TOP_CENTER);
			buttons.setPadding(new Insets(10,10,10,10));
			
				HBox playerScore = new HBox();
				buttons.getChildren().add(playerScore);
				playerScore.setMinWidth(180); 	playerScore.setMaxWidth(180);
				playerScore.setMinHeight(30); 	playerScore.setMaxHeight(30);
				playerScore.setAlignment(Pos.CENTER_LEFT);
				playerScore.setSpacing(10);
				
					Label playerScore_label = new Label("Player Score:  ");
					playerScore.getChildren().add(playerScore_label);
					playerScore_label.setMinWidth(100); 	playerScore_label.setMaxWidth(100);
					playerScore_label.setMinHeight(30); 	playerScore_label.setMaxHeight(30);
					playerScore_label.setAlignment(Pos.CENTER_LEFT);
					
					TextField playerScore_num = new TextField("0");
					playerScore.getChildren().add(playerScore_num);
					playerScore_num.setMinWidth(70); 	playerScore_num.setMaxWidth(70);
					playerScore_num.setMinHeight(30); 	playerScore_num.setMaxHeight(30);
					playerScore_num.setAlignment(Pos.CENTER_LEFT);
					playerScore_num.setBackground( buttons.getBackground() );
				
				HBox computerScore = new HBox();
				buttons.getChildren().add(computerScore);
				computerScore.setMinWidth(180); 	computerScore.setMaxWidth(180);
				computerScore.setMinHeight(30); 	computerScore.setMaxHeight(30);
				computerScore.setAlignment(Pos.CENTER_LEFT);
				computerScore.setSpacing(10);
				
					Label computerScore_label = new Label("Computer Score:  ");
					computerScore.getChildren().add(computerScore_label);
					computerScore_label.setMinWidth(100); 	computerScore_label.setMaxWidth(100);
					computerScore_label.setMinHeight(30); 	computerScore_label.setMaxHeight(30);
					computerScore_label.setAlignment(Pos.CENTER_LEFT);
					
					TextField computerScore_num = new TextField("0");
					computerScore.getChildren().add(computerScore_num);
					computerScore_num.setMinWidth(70); 		computerScore_num.setMaxWidth(70);
					computerScore_num.setMinHeight(30); 	computerScore_num.setMaxHeight(30);
					computerScore_num.setAlignment(Pos.CENTER_LEFT);
					computerScore_num.setBackground( buttons.getBackground() );
			
				Button startGame = new Button("RESTART");
				buttons.getChildren().add(startGame);
				startGame.setMinWidth(180); 	startGame.setMaxWidth(180);
				startGame.setMinHeight(50); 	startGame.setMaxHeight(50);
				startGame.setFont(Font.font("System", FontWeight.NORMAL, 20));
				startGame.setOnAction( e -> {
					blackjack.restart(0);
					seeCards(player_cards, blackjack.getUser().getHand().getHand() );
				});
				
				TextField yourTurn = new TextField("Hit or Hold?");
				buttons.getChildren().add(yourTurn);
				yourTurn.setEditable(false);
				yourTurn.setAlignment(Pos.CENTER);
				yourTurn.setFont(Font.font("System", FontWeight.NORMAL, 20));
				yourTurn.setBackground( buttons.getBackground() );
				
				HBox hitNhold = new HBox();
				buttons.getChildren().add(hitNhold);
				hitNhold.setSpacing(10);
				hitNhold.setPadding( new Insets(0,10,0,10) );
				
					Button youHit = new Button("HIT");
					hitNhold.getChildren().add(youHit);
					youHit.setMinWidth(85);	youHit.setMaxWidth(85);
					youHit.setMinHeight(40); 	youHit.setMaxHeight(40);
					youHit.setFont(Font.font("System", FontWeight.NORMAL, 20));
					youHit.setOnAction( e -> {
						playerScore_num.setText( "" + blackjack.drawCard() );		//player draws a card
						seeCards(player_cards, blackjack.getUser().getHand().getHand() );
					});
					
					Button youHold = new Button("HOLD");
					hitNhold.getChildren().add(youHold);
					youHold.setMinWidth(85); 	youHold.setMaxWidth(85);
					youHold.setMinHeight(40); 	youHold.setMaxHeight(40);
					youHold.setFont(Font.font("System", FontWeight.NORMAL, 20));
					youHold.setOnAction( e -> {
						//	runs the stuff for the AI opponant
					});
				
				
		Scene scene = new Scene(complete, 1000, 500);
		primaryStage.setTitle("Blackjack");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}
}
