import static org.junit.Assert.*;
import org.junit.*;
import setup.*;

public class DeckTests{

  Deck deck;

  @Before
  public void before(){
    deck = new Deck();
  }

  @Test
  public void deckIsEmpty(){
    assertEquals(0, deck.deckSize());
  }

  @Test
  public void deckIsFull(){
    deck.createDeck();
    assertEquals(52, deck.deckSize());
  }

  @Test
  public void deckAtPostion__14(){
    deck.createDeck();
    Card card = deck.cardInDeck(13);
    assertEquals("Clubs", card.getSuit());
    assertEquals("2", card.getRank());
  }

}