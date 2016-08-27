package setup;
import java.util.*;

public class Player{

  private String name;
  private ArrayList<Card> hand = new ArrayList<Card>();

  public Player(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  public int handSize(){
    return hand.size();   
  }

  public void dealPlayer(Card card){
    hand.add(card);
  }

  public Card cardInHand(int handPosition){
    return hand.get(handPosition);
  }

  public Card playACard(int cardToBePlayed){
    return hand.remove(cardToBePlayed);
  }

}