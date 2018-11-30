package edu.neu.ccs.cs5004.model.battlefield;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.attackresult.Hit;
import edu.neu.ccs.cs5004.model.attackresult.Miss;
import edu.neu.ccs.cs5004.model.attackresult.Sunk;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.model.ship.BattleShip;
import edu.neu.ccs.cs5004.model.ship.Ship;
import javafx.geometry.HorizontalDirection;

import static org.junit.Assert.*;

public class BattleMapTest {
  private BattleMap battleMap;
  private BattleMap battleMap1;
  private BattleMap battleMap2;
  private BattleMap battleMap3;
  private FleetMap fleetMap;
  private FleetMap fleetMap1;
  private AttackResult attackResult;
  private AttackResult attackResult1;
  private AttackResult attackResult2;
  private Map map;
  private Ship ship;
  private Ship ship1;
  private Ship ship2;
  private Ship ship3;


  @Before
  public void setUp() throws Exception {
    fleetMap = new FleetMap(0,0,0,0);
    fleetMap1 = new FleetMap(4,4,4,4);
    battleMap = new BattleMap(fleetMap);
    battleMap1 = battleMap;
    battleMap2 = battleMap1;
    battleMap3 = new BattleMap(fleetMap1);
    attackResult = new Miss();
    attackResult1 = new Hit();
    attackResult2 = new Sunk();
    map = new Map();
    ship = Ship.createBattleShip();
    ship1 = Ship.createDestroyer();
    ship2 = Ship.createCruiser();
    ship3 = Ship.createSubmarine();
  }

  @Test
  public void attack() {
    battleMap.attack(Row.ROW1,Column.C);
  }

  @Test
  public void randomAttack() {
    Assert.assertEquals(attackResult,battleMap.randomAttack());
  }

  @Test
  public void smartAttack() {
    Assert.assertEquals(attackResult,battleMap.smartAttack());

  }

  @Test
  public void sunkSet() {
    fleetMap1.placeShip(Row.ROW1,Column.C,Direction.Horizontal,ship1);
    fleetMap.placeShip(Row.ROW6,Column.E,Direction.Vertical,ship);
    fleetMap.placeShip(Row.ROW2,Column.C,Direction.Horizontal,ship2);
    fleetMap1.placeShip(Row.ROW4,Column.J,Direction.Vertical,ship3);
    battleMap.sunkSet(ship,fleetMap.getMap());
    battleMap3.sunkSet(ship1,fleetMap1.getMap());
    battleMap.sunkSet(ship2,fleetMap.getMap());
    battleMap3.sunkSet(ship3,fleetMap1.getMap());
  }

  @Test
  public void userAttack() {
    ByteArrayInputStream in;
    ByteArrayInputStream in1;
    in = new ByteArrayInputStream("5".getBytes());
    System.setIn(in);
    Assert.assertEquals(null,battleMap.userAttack());


  }

  @Test
  public void endGame() {
    Assert.assertEquals(battleMap.endGame(),true);
  }

  @Test
  public void equals() {
    BattleMap nullBattleMap = null;
    Assert.assertTrue(battleMap.equals(battleMap1));
    Assert.assertTrue(battleMap1.equals(battleMap));
    Assert.assertTrue(battleMap.equals(battleMap));
    Assert.assertFalse(battleMap.equals(nullBattleMap));
    Assert.assertFalse(battleMap.equals(new Integer(0)));
    Assert.assertEquals(battleMap.equals(battleMap1)&&battleMap1.equals(battleMap2)
                        ,battleMap.equals(battleMap2));
    Assert.assertFalse(battleMap.equals(battleMap3));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(battleMap.hashCode(),battleMap1.hashCode());
  }
}