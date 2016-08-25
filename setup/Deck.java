package setup;
import java.util.*;

public class Deck{

  private ArrayList<Card> deck = new ArrayList<Card>();
  private String suits[] = {"Spades", "Clubs", "Hearts", "Diamonds"};
  private String rank[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

  public void createDeck(){
    for (int i = 0; i < 4; i++){
      for (int j = 0; j <13; j++){
        deck.add(new Card(suits[i], rank[j]));
      }
    }
  }

  public int deckSize(){
    return deck.size();   
  }

  public void shuffleDeck(){
    Collections.shuffle(deck);
  }

  public ArrayList<Card> showDeck(){
    return deck;
  } 

  public Card cardInDeck(int deckPosition){
    return deck.get(deckPosition);
  }

}