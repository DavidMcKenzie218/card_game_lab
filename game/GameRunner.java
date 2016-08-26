package Game;
import java.util.*;
import setup.*;

public class GameRunner{

    private ArrayList<Player> players = new ArrayList<Player>();

    public void createPlayer(Player player){
      this.players.add(player);
    }

    public Player getPlayer(int playerNumber){
      return players.get(playerNumber);
    }

}