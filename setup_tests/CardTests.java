import static org.junit.Assert.*;
import org.junit.*;
import setup.*;

public class CardTests{

  Card faceCard;
  Card numberCard;

  @Before
  public void before(){
    faceCard = new Card("Spades", "A");
    numberCard = new Card("Hearts", "3");
  }

  @Test
  public void hasFaceCardSuit(){
    assertEquals("Spades", faceCard.getSuit());
  }

  @Test
  public void hasNumberCardSuit(){
    assertEquals("Hearts", numberCard.getSuit());
  }

  @Test
  public void hasFaceCardRank(){
    assertEquals("A", faceCard.getRank());
  }

  @Test
  public void hasNumberCardRank(){
    assertEquals("3", numberCard.getRank());
  }

} 