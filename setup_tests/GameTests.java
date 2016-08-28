import static org.junit.Assert.*;
import org.junit.*;
import setup.*;
import game.*;

public class GameTests{

  Game gameRunner;
  Player playerDavid;
  Player playerJohn;
  Deck deck;

  @Before
  public void before(){
    gameRunner = new Game();
    playerDavid = new Player("David");
    playerJohn = new Player("John");
    deck = new Deck();
  }

  @Test
  public void gameHasOnePlayer(){
    gameRunner.createPlayer(playerDavid);
    Player runnerPlayer = gameRunner.getPlayer(0);
    assertEquals("David", runnerPlayer.getName());
  }

  @Test
  public void gameHasMultiplePlayers(){
    gameRunner.createPlayer(playerDavid);
    gameRunner.createPlayer(playerJohn);
    Player runnerPlayerTwo = gameRunner.getPlayer(1);
    assertEquals("John", runnerPlayerTwo.getName());
  }

  @Test
  public void gameHasDeck(){
    gameRunner.createDeck(deck);
    assertEquals(52, gameRunner.deckCount());
  }

  @Test
  public void playerHas6InHand(){
    gameRunner.createPlayer(playerJohn);
    gameRunner.createDeck(deck);
    gameRunner.dealHands(6);
    Player runnerPlayer = gameRunner.getPlayer(0);
    assertEquals(6, runnerPlayer.handSize());
  }

  @Test
  public void playerHas6InHandAndDeckIs6Down(){
    gameRunner.createPlayer(playerJohn);
    gameRunner.createDeck(deck);
    gameRunner.dealHands(6);
    Player runnerPlayer = gameRunner.getPlayer(0);
    assertEquals(1, gameRunner.playerCount());
    assertEquals(6, runnerPlayer.handSize());
    assertEquals(46, gameRunner.deckCount());
  }

  @Test
  public void playerHasPlayedACard(){
    gameRunner.createPlayer(playerJohn);
    gameRunner.createDeck(deck);
    gameRunner.dealHands(6);
    gameRunner.playerHasPlayedCard(0, 2);
    Player runnerPlayer = gameRunner.getPlayer(0);
    assertEquals(5, runnerPlayer.handSize());
    assertEquals(46, gameRunner.deckCount());
    assertEquals(1, gameRunner.discardDeckLength());
  }

  @Test
  public void reAddDiscardToDeck(){
    gameRunner.createPlayer(playerJohn);
    gameRunner.createDeck(deck);
    gameRunner.dealHands(6);
    gameRunner.playerHasPlayedCard(0, 2);
    gameRunner.playerHasPlayedCard(0, 2);
    assertEquals(2, gameRunner.discardDeckLength());
    gameRunner.addDiscardToDeck();
    assertEquals(48, gameRunner.deckCount());
    assertEquals(0, gameRunner.discardDeckLength());
  }

}