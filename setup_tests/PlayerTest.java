import static org.junit.Assert.*;
import org.junit.*;
import setup.*;

public class PlayerTest{

  Player playerOne;
  Player playerTwo;
  Card cardAce;

  @Before
  public void before(){
    playerOne = new Player("David");
    playerTwo = new Player("John");
    cardAce = new Card("Spade", "A");
  }

  @Test 
  public void playerHasName__One(){
    assertEquals("David", playerOne.getName());
  }

  @Test 
  public void playerHasName__Two(){
    assertEquals("John", playerTwo.getName());
  }

  @Test
  public void playerHandIsEmpty(){
    assertEquals(0, playerOne.handSize());
  }

  @Test
  public void playerHasOneCard(){
    playerOne.dealPlayer(cardAce);
    assertEquals(1, playerOne.handSize());
  }

  @Test
  public void playerOneHas(){
    playerOne.dealPlayer(cardAce);
    Card card = playerOne.cardInHand(0);
    assertEquals("Spade", card.getSuit());
    assertEquals("A", card.getRank());
  }


}