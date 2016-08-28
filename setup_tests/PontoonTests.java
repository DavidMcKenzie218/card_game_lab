import static org.junit.Assert.*;
import org.junit.*;
import setup.*;
import game.*;
import rules.*;

public class PontoonTests{

  Pontoon pontoon;
  Player player;
  Player playerTwo;
  Card cardTwo;
  Card cardThree;
  Card cardAce;
  Card cardQueen;
  Card cardTen;
  Game game;
  Deck deck;

  @Before
  public void before(){
    pontoon = new Pontoon();
    player = new Player("David");
    playerTwo = new Player("John");
    cardTwo = new Card("Hearts", "2");
    cardThree = new Card("Hearts", "3");
    cardAce = new Card("Hearts", "A");
    cardQueen = new Card("Hearts", "Q");
    cardTen = new Card("Hearts", "10");
    game = new Game();
    deck = new Deck();
  }

  @Test
  public void handSizeIs2(){
    assertEquals(2, pontoon.numberOfCardsHand());
  }

  @Test
  public void maximumPlayerSizeIs8(){
    assertEquals(8, pontoon.maximumNumberOfPlayers());
  }

  @Test
  public void playersHandScore__NoCards(){
    player.dealPlayer(cardTwo);
    player.dealPlayer(cardThree);
    assertEquals(5, pontoon.totalHandTotal(player));
  }

  @Test
  public void playersHandScore__FaceCard(){
    player.dealPlayer(cardAce);
    player.dealPlayer(cardQueen);
    assertEquals(12, pontoon.totalHandTotal(player));
  }

  @Test
  public void playersHAndScore__Ten(){
    player.dealPlayer(cardTen);
    assertEquals(10, pontoon.totalHandTotal(player));
  }

  @Test
  public void thereAreTwoHandTotals(){
    game.createPlayer(player);
    game.createPlayer(playerTwo);
    game.createDeck(deck);
    player.dealPlayer(cardTwo);
    player.dealPlayer(cardQueen);
    playerTwo.dealPlayer(cardAce);
    playerTwo.dealPlayer(cardThree);
    pontoon.playerTurn(game);
    assertEquals(2, pontoon.totalArraySize());
  }

  @Test
  public void checkWinner__David(){
    game.createPlayer(player);
    game.createPlayer(playerTwo);
    player.dealPlayer(cardTwo);
    player.dealPlayer(cardQueen);
    playerTwo.dealPlayer(cardAce);
    playerTwo.dealPlayer(cardThree);
    pontoon.playerTurn(game);
    assertEquals("David won this round", pontoon.winner(game));
  }
  @Test
  public void playerDiscardsCards(){
    game.createPlayer(player);
    game.createPlayer(playerTwo);
    game.createDeck(deck);
    player.dealPlayer(cardTwo);
    player.dealPlayer(cardQueen);
    playerTwo.dealPlayer(cardAce);
    playerTwo.dealPlayer(cardThree);
    pontoon.playerTurn(game);
    System.out.println(game.deckCount());
    assertEquals(4, game.discardDeckLength());
  }

}