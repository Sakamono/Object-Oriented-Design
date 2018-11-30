package edu.neu.ccs.cs5004.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class SubmarineTest {
  Ship submarine1;
  Ship submarine2;
  Ship submarine3;

  @Before
  public void setUp() throws Exception {
    submarine1 = new Submarine();
    submarine2 = new Submarine();
    submarine3 = new Submarine();
  }

  @Test
  public void testToString() {
    assertEquals("Submarine{size=2, hitCell=0}", submarine1.toString());
  }

  @Test
  public void equals() {
    Ship test = new BattleShip();
    Assert.assertTrue(submarine1.equals(submarine1));
    Assert.assertTrue(submarine1.equals(submarine2));
    Assert.assertTrue(submarine2.equals(submarine1));
    Assert.assertTrue(submarine2.equals(submarine3));
    Assert.assertTrue(submarine1.equals(submarine3));
    Assert.assertFalse(submarine1.equals(test));
    Assert.assertFalse(submarine1.equals(null));
  }

  @Test
  public void testHashCode() {
    assertEquals(submarine1.equals(submarine2), submarine1.hashCode() == submarine2.hashCode());
  }

  @Test
  public void getSize() {
    assertEquals(new Integer(2), submarine1.getSize());
  }

  @Test
  public void getHitCells() {
    assertEquals(new Integer(0), submarine1.getHitCell());
  }

  @Test
  public void hitShip() {
    assertEquals(new Integer(1), submarine1.hitShip().getHitCell());
  }

  @Test
  public void isSunk() {
    Assert.assertFalse(submarine1.isSunk());
    Assert.assertTrue(submarine1.hitShip().hitShip().isSunk());
  }
}