import static org.junit.Assert.*;
import org.junit.*;
import setup.*;
import Game.*;

public class GameRunnerTests{

  GameRunner gameRunner;
  Player playerDavid;
  Player playerJohn;

  @Before
  public void before(){
    gameRunner = new GameRunner();
    playerDavid = new Player("David");
    playerJohn = new Player("John");
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

}
