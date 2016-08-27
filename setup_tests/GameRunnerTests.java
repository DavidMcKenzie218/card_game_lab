import static org.junit.Assert.*;
import org.junit.*;
import setup.*;
import game.*;

public class GameRunnerTests{

  GameRunner gameRunner;
  Game game;
  Deck deck;

  @Before
  public void before(){
    game = new Game();
    deck = new Deck();
    gameRunner = new GameRunner(game, deck);    
  }

  @Test
  public void playersHaveNames(){
    gameRunner.createGame();
    assertEquals("Player 1",gameRunner.returnPlayerName(0));
    assertEquals("Player 2", gameRunner.returnPlayerName(1));
  }

  //TEST BEFORE ADDING THE DEALHANDS TO MAKE SURE THAT A DECK IS BEING MADE 

  // @Test
  // public void gameHasAFullDeck(){
  //   gameRunner.createGame();
  //   assertEquals(52, gameRunner.returnDeckSize());
  // }

  @Test
  public void handsHaveBeenDealt(){
    gameRunner.createGame();
    assertEquals(40, gameRunner.returnDeckSize());
  }

  @Test
  public void playerHasPlayedATurn(){
    gameRunner.createGame();
    gameRunner.playTurn(0, 3);
    assertEquals(1, gameRunner.discardSize());
  }

}