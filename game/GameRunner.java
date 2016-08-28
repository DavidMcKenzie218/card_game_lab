package game;
import java.util.*;
import setup.*;

import rules.*;

public class GameRunner{

  private Game game;
  private Deck deck;
  private Rules rules;

  public GameRunner(Game game, Deck deck, Rules rules){
    this.game = game;
    this.deck = deck;
    this.rules = rules;
  }

  //RUN GAME

  public void createGame(int playerCount){
    int maxPlayers = rules.maximumNumberOfPlayers();
    int handSize = rules.numberOfCardsHand();
    createPlayers(maxPlayers, playerCount);
    this.game.createDeck(deck);
    this.game.dealHands(handSize);
  }

  public void playTurn(int playerNumber, int cardToBePlayed){
    int numberOfCardsInDeck = this.game.deckCount();   
    this.game.playerHasPlayedCard(playerNumber, cardToBePlayed);
    if (numberOfCardsInDeck == 0){
      this.game.addDiscardToDeck();
    }
  }

  public void createPlayers(int maxPlayers, int playerCount){
    for (int players = 0; players < playerCount; players ++){
      String playerName = String.format("Player %d", (players+1));      
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