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

  public void playerTurn(Game game){
    for (Player player : game.getAllPlayers()){
      handTotals.add(totalHandTotal(player));
    }
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

    //FOR TESTING

    public int totalArraySize(){
      return handTotals.size();
    }
  }
