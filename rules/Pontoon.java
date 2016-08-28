package rules;

import setup.*;
import game.*;
import java.util.*;
import java.util.regex.*;

public class Pontoon implements Rules{

  private ArrayList<Integer> handTotals = new ArrayList<Integer>();

  public int numberOfCardsHand(){
    return 2;
  }

  public int maximumNumberOfPlayers(){
    return 8;
  }

  public String playerTurn(Game game){
    for (Player player : game.getAllPlayers()){
      handTotals.add(totalHandTotal(player));  
    }   
    playerPlayedCards(game); 
    return winner(game);
  }

  public int totalHandTotal(Player player){
    Integer handTotal = 0;

    for (int cardNumber = 0; cardNumber < player.handSize(); cardNumber++){

      Card card = player.cardInHand(cardNumber);
      String cardRank = card.getRank();

      if (cardRank.matches("-?[0-9]+")){

        handTotal += Integer.parseInt(cardRank);
      } else {
        if (cardRank == "A"){
          handTotal += 1;
        }else{
          handTotal +=11;
        }
      }
      }
      return handTotal;
    }

    public void playerPlayedCards(Game game){
      for (int playerNumber = 0; playerNumber < game.playerCount(); playerNumber++){
        // System.out.println(game.playerCount());
        Player player = game.getPlayer(playerNumber);
        // System.out.println(player.handSize());
        // for (int cardNumber = 0; cardNumber < player.handSize(); cardNumber++){
          game.playerHasPlayedAllCards(playerNumber);
        }
    }
    

    public String winner(Game game){
      int winnerNumber = 0;
      for (int handTotalNumber = 0; handTotalNumber < totalArraySize(); handTotalNumber++){
        int newTotal = handTotals.get(handTotalNumber);
        if (newTotal > handTotals.get(winnerNumber)){
          winnerNumber = newTotal;
        }
      }

      Player winner = game.getPlayer(winnerNumber);
      winnerNumber = 0;
      return winner.getName() + " won this round";

    }

    //FOR TESTING

    public int totalArraySize(){
      return handTotals.size();
    }
  }

