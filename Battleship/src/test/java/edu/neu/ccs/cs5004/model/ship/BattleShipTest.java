package edu.neu.ccs.cs5004.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class BattleShipTest {
  Ship battleship1;
  Ship battleship2;
  Ship battleship3;

  @Before
  public void setUp() throws Exception {
    battleship1 = new BattleShip();
    battleship2 = new BattleShip();
    battleship3 = new BattleShip();
  }

  @Test
  public void testToString() {
    assertEquals("BattleShip{size=4, hitCell=0}", battleship1.toString());
  }

  @Test
  public void equals() {
    Ship test = new Submarine();
    Assert.assertTrue(battleship1.equals(battleship1));
    Assert.assertTrue(battleship1.equals(battleship2));
    Assert.assertTrue(battleship2.equals(battleship3));
    Assert.assertTrue(battleship1.equals(battleship3));
    Assert.assertFalse(battleship1.equals(null));
    Assert.assertFalse(battleship1.equals(test));

  }

  @Test
  public void TestHashCode() {
    assertEquals(battleship1.equals(battleship2), battleship1.hashCode() == battleship2.hashCode());
  }

  @Test
  public void getSize() {
    assertEquals(new Integer(4), battleship1.getSize());
  }

  @Test
  public void getHitCells() {
    assertEquals(new Integer(0), battleship1.getHitCell());
  }

  @Test
  public void hitShip() {
    assertEquals(new Integer(1), battleship1.hitShip().getHitCell());
  }

  @Test
  public void isSunk() {
    Assert.assertFalse(battleship1.isSunk());
    Assert.assertTrue(battleship1.hitShip().hitShip().hitShip().hitShip().isSunk());
  }
}