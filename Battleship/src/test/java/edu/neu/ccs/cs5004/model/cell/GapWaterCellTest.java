package edu.neu.ccs.cs5004.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.cell.Cell;
import edu.neu.ccs.cs5004.model.cell.GapWaterCell;
import edu.neu.ccs.cs5004.model.cell.OpenSeaWaterCell;

import static org.junit.Assert.*;

public class GapWaterCellTest {
  Cell gapCell1;
  Cell gapCell2;
  Cell gapCell3;
  GapWaterCell gapCell4;

  @Before
  public void setUp() throws Exception {
    gapCell1 = new GapWaterCell();
    gapCell2 = new GapWaterCell();
    gapCell3 = new GapWaterCell();
    gapCell4 = new GapWaterCell();
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertFalse(gapCell1.placeShipOnCell());
  }

  @Test
  public void testToString() {
    assertEquals("GapWaterCell", gapCell1.toString());
  }

  @Test
  public void equals() {
    Cell test = new OpenSeaWaterCell();
    Assert.assertTrue(gapCell1.equals(gapCell1));
    Assert.assertTrue(gapCell1.equals(gapCell2));
    Assert.assertTrue(gapCell2.equals(gapCell1));
    Assert.assertTrue(gapCell2.equals(gapCell3));
    Assert.assertTrue(gapCell1.equals(gapCell3));
    Assert.assertFalse(gapCell1.equals(null));
    Assert.assertFalse(gapCell1.equals(test));
  }

  @Test
  public void testHashCode() {
    assertEquals(gapCell1.equals(gapCell2), gapCell1.hashCode() == gapCell2.hashCode());
  }

  @Test
  public void attackCell() {
    Assert.assertFalse(gapCell1.isCellHit());
    Assert.assertTrue(gapCell1.attackCell().isCellHit());
  }

  @Test
  public void attackResult() {
    assertEquals("Miss", gapCell1.attackResult().toString());
  }

  @Test
  public void setHit() {
    gapCell4.setHit(true);
    Assert.assertTrue(gapCell4.isCellHit());
    gapCell4.setHit(false);
    Assert.assertFalse(gapCell4.isCellHit());
  }
}