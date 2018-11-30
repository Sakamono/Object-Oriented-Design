package edu.neu.ccs.cs5004.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EnemyShipCellTest {
  Cell enemyShipCell1;
  Cell enemyShipCell2;
  Cell enemyShipCell3;
  EnemyShipCell enemyShipCell4;

  @Before
  public void setUp() throws Exception {
    enemyShipCell1 = new EnemyShipCell();
    enemyShipCell2 = new EnemyShipCell();
    enemyShipCell3 = new EnemyShipCell();
    enemyShipCell4 = new EnemyShipCell();
  }

  @Test
  public void equals() {
    Cell test = new GapWaterCell();
    Assert.assertTrue(enemyShipCell1.equals(enemyShipCell1));
    Assert.assertTrue(enemyShipCell1.equals(enemyShipCell2));
    Assert.assertTrue(enemyShipCell2.equals(enemyShipCell1));
    Assert.assertTrue(enemyShipCell2.equals(enemyShipCell3));
    Assert.assertTrue(enemyShipCell1.equals(enemyShipCell3));
    Assert.assertFalse(enemyShipCell1.equals(null));
    Assert.assertFalse(enemyShipCell1.equals(test));
  }

  @Test
  public void testHashCode() {
    assertEquals(enemyShipCell1.equals(enemyShipCell2), enemyShipCell1.hashCode() == enemyShipCell2.hashCode());
  }

  @Test
  public void attackCell() {
    Assert.assertEquals(null, enemyShipCell1.attackCell());
  }

  @Test
  public void attackResult() {
    assertEquals(null, enemyShipCell1.attackResult());
  }

  @Test
  public void testToString() {
    Assert.assertEquals("EnemyShipCell{, isSunk=false, isHit=false}", enemyShipCell1.toString());
  }
}