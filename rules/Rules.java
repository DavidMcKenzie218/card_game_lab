package rules;
import game.*;

public interface Rules{
  public int numberOfCardsHand();
  public int maximumNumberOfPlayers();
  public String playerTurn(Game game);
}