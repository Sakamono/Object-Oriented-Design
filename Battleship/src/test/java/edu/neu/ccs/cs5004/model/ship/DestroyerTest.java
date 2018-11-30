package edu.neu.ccs.cs5004.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class DestroyerTest {
  Ship destroyer1;
  Ship destroyer2;
  Ship destroyer3;

  @Before
  public void setUp() throws Exception {
    destroyer1 = new Destroyer();
    destroyer2 = new Destroyer();
    destroyer3 = new Destroyer();
  }

  @Test
  public void testToString() {
    assertEquals("Destroyer{size=1, hitCell=0}", destroyer1.toString());
  }

  @Test
  public void equals() {
    Ship test = new BattleShip();
    Assert.assertTrue(destroyer1.equals(destroyer1));
    Assert.assertTrue(destroyer1.equals(destroyer2));
    Assert.assertTrue(destroyer2.equals(destroyer1));
    Assert.assertTrue(destroyer2.equals(destroyer3));
    Assert.assertTrue(destroyer1.equals(destroyer3));
    Assert.assertFalse(destroyer1.equals(test));
    Assert.assertFalse(destroyer1.equals(null));
  }

  @Test
  public void TestHashCode() {
    assertEquals(destroyer1.equals(destroyer2), destroyer1.hashCode() == destroyer2.hashCode());
  }

  @Test
  public void getSize() {
    assertEquals(new Integer(1), destroyer1.getSize());
  }

  @Test
  public void getHitCells() {
    assertEquals(new Integer(0), destroyer1.getHitCell());
  }

  @Test
  public void hitShip() {
    assertEquals(new Integer(1), destroyer1.hitShip().getHitCell());
  }

  @Test
  public void isSunk() {
    Assert.assertFalse(destroyer1.isSunk());
    Assert.assertTrue(destroyer1.hitShip().isSunk());
  }
}