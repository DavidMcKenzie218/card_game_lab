package game;
import java.util.*;
import setup.*;

public class GameRunner{

  private Game game;
  private Deck deck;

  public GameRunner(Game game, Deck deck){
    this.game = game;
    this.deck = deck;
  }

  //RUN GAME

  public void createGame(){
    createPlayers();
    this.game.createDeck(deck);
    this.game.dealHands();
  }

  public void playTurn(int playerNumber, int cardToBePlayed){
    this.game.playerHasPlayedCard(playerNumber, cardToBePlayed);
  }

  public void createPlayers(){
    for (int playerCount = 0; playerCount < 2; playerCount ++){
      String playerName = String.format("Player %d", (playerCount+1));      
      Player player = new Player(playerName);
      this.game.createPlayer(player);
    }
  }



  //FOR TESTING

  public String returnPlayerName(int playerNumber){
    Player player = game.getPlayer(playerNumber);
    return player.getName();
  }

  public int returnDeckSize(){
    return this.game.deckCount();
  }

  public int discardSize(){
    return this.game.discardDeckLength();
  }

}