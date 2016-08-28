import static org.junit.Assert.*;
import org.junit.*;
import setup.*;
import game.*;
import rules.*;

public class GameRunnerTests{

  GameRunner gameRunner;
  Game game;
  Deck deck;
  Rules rules;

  @Before
  public void before(){
    game = new Game();
    deck = new Deck();
    rules = new Pontoon();
    gameRunner = new GameRunner(game, deck, rules);    
  }

  @Test
  public void playersHaveNames(){
    gameRunner.createGame(2);
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
    gameRunner.createGame(2);
    assertEquals(48, gameRunner.returnDeckSize());
  }

  @Test
  public void playerHasPlayedATurn(){
    gameRunner.createGame(2);
    gameRunner.playTurn(0, 1);
    assertEquals(1, gameRunner.discardSize());
  }

}