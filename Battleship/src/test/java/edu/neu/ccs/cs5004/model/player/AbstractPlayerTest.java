package edu.neu.ccs.cs5004.model.player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.battlefield.BattleMap;
import edu.neu.ccs.cs5004.model.battlefield.FleetMap;
import edu.neu.ccs.cs5004.view.ConsolePrinter;


public class AbstractPlayerTest {
  private BattleMap battleMap;
  private BattleMap battleMap1;
  private FleetMap fleetMap;
  private FleetMap fleetMap1;
  private Player player;
  private Player player1;
  private Player player2;
  private Player player3;
  private Player robPlayer;
  private Player robPlayer1;
  private ConsolePrinter printer;

  @Before
  public void setUp() throws Exception {
    fleetMap = new FleetMap(0,0,0,0);
    fleetMap1 = new FleetMap(1,1,1,1);
    battleMap = new BattleMap(fleetMap);
    battleMap1 = new BattleMap(fleetMap1);
    player = Player.createUserPlayer(false,fleetMap,battleMap);
    player1 = player;
    player2 = player1;
    player3= Player.createUserPlayer(true,fleetMap,battleMap);
    robPlayer = Player.createRobotPlayer(fleetMap1,battleMap1);
    robPlayer1 = robPlayer;
    printer = new ConsolePrinter();

  }

  @Test
  public void randomAttack() {
    Assert.assertEquals(player.randomAttack(),player1.randomAttack());
  }

  @Test
  public void userAttack() {
    Assert.assertEquals(player.userAttack(),player1.userAttack());
  }

  @Test
  public void smartAttack() {
    Assert.assertEquals(player.smartAttack(),player1.smartAttack());
  }

  @Test
  public void winGame() {
    Assert.assertEquals(player.winGame(),player1.winGame());
  }

  @Test
  public void printFleet() {
    player.printFleet(printer);
  }

  @Test
  public void printBattle() {
    player.printBattle(printer);
  }

  @Test
  public void equals() {
    Player nullPlayer = null;
    Assert.assertTrue(player.equals(player1));
    Assert.assertTrue(player.equals(player));
    Assert.assertFalse(player.equals(robPlayer));
    Assert.assertFalse(player.equals(nullPlayer));
    Assert.assertFalse(player.equals(new Integer(0)));
    Assert.assertEquals(player.equals(player1)&&player1.equals(player2)
                        ,player.equals(player2));
    Assert.assertEquals(battleMap,battleMap);
    Assert.assertEquals(fleetMap,fleetMap);
    Assert.assertEquals(player,player3);

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(player.hashCode(),player1.hashCode());
  }
}