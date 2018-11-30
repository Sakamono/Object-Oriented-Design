package edu.neu.ccs.cs5004.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class OpenSeaWaterCellTest {
  Cell openCell1;
  Cell openCell2;
  Cell openCell3;
  OpenSeaWaterCell openCell4;

  @Before
  public void setUp() throws Exception {
    openCell1 = new OpenSeaWaterCell();
    openCell2 = new OpenSeaWaterCell();
    openCell3 = new OpenSeaWaterCell();
    openCell4 = new OpenSeaWaterCell();
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertTrue(openCell1.placeShipOnCell());
  }

  @Test
  public void testToString() {
    assertEquals("OpenSeaWaterCell", openCell1.toString());
  }

  @Test
  public void equals() {
    Cell test = new GapWaterCell();
    Assert.assertTrue(openCell1.equals(openCell1));
    Assert.assertTrue(openCell1.equals(openCell2));
    Assert.assertTrue(openCell2.equals(openCell1));
    Assert.assertTrue(openCell2.equals(openCell3));
    Assert.assertTrue(openCell1.equals(openCell3));
    Assert.assertFalse(openCell1.equals(null));
    Assert.assertFalse(openCell1.equals(test));
  }

  @Test
  public void testHashCode() {
    assertEquals(openCell1.equals(openCell2), openCell1.hashCode() == openCell2.hashCode());
  }

  @Test
  public void attackCell() {
    Assert.assertFalse(openCell1.isCellHit());
    Assert.assertTrue(openCell1.attackCell().isCellHit());
  }

  @Test
  public void attackResult() {
    assertEquals("Miss", openCell1.attackResult().toString());
  }

  @Test
  public void setHit() {
    openCell4.setHit(true);
    Assert.assertTrue(openCell4.isCellHit());
    openCell4.setHit(false);
    Assert.assertFalse(openCell4.isCellHit());
  }
}