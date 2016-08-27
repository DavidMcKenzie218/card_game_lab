package setup;
import java.util.*;

public class Deck{

  private ArrayList<Card> deck = new ArrayList<Card>();
  private String suits[] = {"Spades", "Clubs", "Hearts", "Diamonds"};
  private String rank[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

  public void createDeck(){
    for (int cardCount = 0; cardCount < 52; cardCount++){
        deck.add(new Card(suits[cardCount/13], rank[cardCount%13]));
    }
  }

  public int deckSize(){
    return deck.size();   
  }

  public void shuffleDeck(){
    Collections.shuffle(deck);
  }

  public ArrayList<Card> showDeck(){
    createDeck();
    shuffleDeck();
    return deck;
  } 

  public Card cardInDeck(int deckPosition){
    return deck.get(deckPosition);
  }

}