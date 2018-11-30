package edu.neu.ccs.cs5004.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import edu.neu.ccs.cs5004.model.battlefield.BattleMap;
import edu.neu.ccs.cs5004.model.battlefield.FleetMap;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.GameObserver;

import static org.junit.Assert.*;

public class AbstractGameTest {
  private Game regularGame;
  private Game regularGame1;
  private Game debugGame;
  private ConsolePrinter printer;
  private GameObserver observer;
  private GameObserver observer1;

  @Before
  public void setUp() throws Exception {
    regularGame = new RegularGame(true);
    regularGame1 = regularGame;
    debugGame = new DebugGame(0,0,0,0,false);
    FleetMap fleetMap = new FleetMap(0, 0, 0, 0);
    BattleMap battleMap = new BattleMap(fleetMap);
    Player user = Player.createUserPlayer(true, fleetMap, battleMap);
    printer = new ConsolePrinter();
    List<GameObserver> observers = new ArrayList<>();
    List<GameObserver> observers1 = new ArrayList<>();
  }

  @Test
  public void getUser() {
    Assert.assertEquals(regularGame.getUser(),regularGame1.getUser());
  }

  @Test
  public void getRobot() {
    Assert.assertEquals(regularGame.getRobot(),regularGame1.getRobot());
  }

//  @Test
//  public void userFire() {
//    Assert.assertEquals(regularGame.userFire(),regularGame1.userFire());
//  }

//  @Test
//  public void robotFire() {
//    Assert.assertTrue(regularGame.robotFire().equals(regularGame1.robotFire()));
//  }
//
//  @Test
//  public void robotSmartFire() {
//    Assert.assertEquals(regularGame.robotSmartFire(),regularGame1.robotSmartFire());
//  }

  @Test
  public void printGame() {
    regularGame.printGame(printer);
  }

  @Test
  public void registerObserver() {
    regularGame.registerObserver(observer);
    regularGame.registerObserver(observer1);
    regularGame1.registerObserver(observer);
  }

  @Test
  public void removeObserver() {
    regularGame.removeObserver(observer1);
  }

  @Test
  public void notifyObservers() {
    regularGame.notifyObservers();
  }

  @Test
  public void endGame() {
    regularGame.endGame();
    regularGame1.endGame();
    debugGame.endGame();
    debugGame.endGame();
  }

  @Test
  public void equals() {
    Game nullGame = null;
    Assert.assertTrue(regularGame.equals(regularGame1));
    Assert.assertTrue(regularGame.equals(regularGame));
    Assert.assertFalse(regularGame.equals(nullGame));
    Assert.assertFalse(regularGame.equals(new Integer(0)));
    Assert.assertFalse(regularGame.equals(debugGame));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(regularGame.hashCode(),regularGame1.hashCode());
  }
}