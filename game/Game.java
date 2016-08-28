package game;
import java.util.*;
import setup.*;

public class Game{

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Card> deck = new ArrayList<Card>();
    private ArrayList<Card> discard = new ArrayList<Card>();

    public void createPlayer(Player player){
      this.players.add(player);
    }

    public Player getPlayer(int playerNumber){
      return players.get(playerNumber);
    }

    public ArrayList<Player> getAllPlayers(){
      return this.players;
    }

    public int playerCount(){
      return players.size();
    }

    public void createDeck(Deck deck){
      ArrayList<Card> suffledDeck = deck.showDeck();
      for (int cardNumber = 0; cardNumber <52; cardNumber++){
        this.deck.add(suffledDeck.get(cardNumber));
      }
    }

    public int deckCount(){
      return deck.size();
    }

    public ArrayList<Card> currentDeck(){
      return deck;
    }

    public int discardDeckLength(){
      return discard.size();
    }

    public void dealHands(int handSize){
      for (Player player : players){
        for (int newCard = 0; newCard < handSize; newCard++){
          player.dealPlayer(deck.remove(0));
        }
      }
    }

    public void playerHasPlayedCard(int playerNumber, int cardPlayed){
      Player playersTurn = players.get(playerNumber);      
      Card playedCard = playersTurn.playACard(cardPlayed);
        discard.add(playedCard);
    }

    public void playerHasPlayedAllCards(int playerNumber){
      Player playersTurn = players.get(playerNumber);
      int handSize = playersTurn.handSize();
      for (int card = 0; card < handSize; card++){
       Card playedCard = playersTurn.playACard(0);
         discard.add(playedCard);
      }
    }

    public void shuffleDiscradDeck(){
      Collections.shuffle(discard);
    }

    public void addDiscardToDeck(){
      shuffleDiscradDeck();
      for (int cardNumber = 0; cardNumber <(discardDeckLength()+1); cardNumber++){
        this.deck.add(discard.remove(0));
      }
    }

}