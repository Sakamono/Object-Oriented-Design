package edu.neu.ccs.cs5004.model.ship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class CruiserTest {
  Ship cruiser1;
  Ship cruiser2;
  Ship cruiser3;

  @Before
  public void setUp() throws Exception {
    cruiser1 = new Cruiser();
    cruiser2 = new Cruiser();
    cruiser3 = new Cruiser();
  }

  @Test
  public void testYoString() {
    assertEquals("Cruiser{size=3, hitCell=0}", cruiser1.toString());
  }

  @Test
  public void equals() {
    Ship test = new BattleShip();
    Assert.assertTrue(cruiser1.equals(cruiser1));
    Assert.assertTrue(cruiser1.equals(cruiser2));
    Assert.assertTrue(cruiser2.equals(cruiser3));
    Assert.assertTrue(cruiser1.equals(cruiser3));
    Assert.assertFalse(cruiser1.equals(null));
    Assert.assertFalse(cruiser1.equals(test));
  }

  @Test
  public void TestHashCode() {
    assertEquals(cruiser1.equals(cruiser2), cruiser1.hashCode() == cruiser2.hashCode());
  }

  @Test
  public void getSize() {
    assertEquals(new Integer(3), cruiser1.getSize());
  }

  @Test
  public void getHitCells() {
    assertEquals(new Integer(0), cruiser1.getHitCell());
  }

  @Test
  public void hitShip() {
    assertEquals(new Integer(1), cruiser1.hitShip().getHitCell());
  }

  @Test
  public void isSunk() {
    Assert.assertFalse(cruiser1.isSunk());
    Assert.assertTrue(cruiser1.hitShip().hitShip().hitShip().isSunk());
  }
}