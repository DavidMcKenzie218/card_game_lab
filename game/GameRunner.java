package game;
import java.util.*;
import setup.*;

public class GameRunner{

    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Card> deck = new ArrayList<Card>();

    public void createPlayer(Player player){
      this.players.add(player);
    }

    public Player getPlayer(int playerNumber){
      return players.get(playerNumber);
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

    public void dealHands(){
      for (Player player : players){
        System.out.println(player.getName());
        for (int newCard = 0; newCard < 6; newCard++){
          player.dealPlayer(deck.remove(0));
        }
      }
    }

    public void playerHasPlayedCard(int playerNumber, int cardPlayed){
      Player playersTurn = players.get(playerNumber);
      Card playedCard = playersTurn.playACard(cardPlayed);
        deck.add(playedCard);
    }

}