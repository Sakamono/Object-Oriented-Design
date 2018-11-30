package edu.neu.ccs.cs5004.model.cell;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.ship.Ship;

import static org.junit.Assert.*;

public class SpecificShipCellTest {
  Ship ship1;
  Ship ship2;
  Cell shipCell1;
  Cell shipCell2;
  Cell shipCell3;
  SpecificShipCell shipCell4;

  @Before
  public void setUp() throws Exception {
    ship1 = Ship.createBattleShip();
    ship2 = Ship.createDestroyer();
    shipCell1 = new SpecificShipCell(ship2);
    shipCell2 = new SpecificShipCell(ship2);
    shipCell3 = new SpecificShipCell(ship2);
    shipCell4 = new SpecificShipCell(ship1);
  }

  @Test
  public void setShip() {
    shipCell4.setShip(ship2);
    Assert.assertEquals(ship2, shipCell4.getShip());
  }

  @Test
  public void getShip() {
    Assert.assertEquals(ship1, shipCell4.getShip());
  }

  @Test
  public void attackCell() {
    Assert.assertFalse(shipCell1.isCellHit());
    Assert.assertTrue(shipCell1.attackCell().isCellHit());
  }

  @Test
  public void attackResult() {
    assertEquals("Sunk", shipCell1.attackCell().attackResult().toString());
    assertEquals("Hit", shipCell4.attackCell().attackResult().toString());
  }

  @Test
  public void equals() {
    Cell test = new OpenSeaWaterCell();
    Assert.assertTrue(shipCell1.equals(shipCell1));
    Assert.assertTrue(shipCell1.equals(shipCell2));
    Assert.assertTrue(shipCell2.equals(shipCell1));
    Assert.assertTrue(shipCell2.equals(shipCell3));
    Assert.assertTrue(shipCell1.equals(shipCell3));
    Assert.assertFalse(shipCell1.equals(null));
    Assert.assertFalse(shipCell1.equals(test));

  }

  @Test
  public void testHashCode() {
    assertEquals(shipCell1.equals(shipCell2), shipCell1.hashCode() == shipCell2.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("SpecificShipCell{ship=Destroyer{size=1, "
        + "hitCell=0}, isSunk=false, isHit=false}", shipCell1.toString());
  }

  @Test
  public void setSunk() {
    shipCell4.setSunk(true);
    Assert.assertTrue(shipCell4.getSunk());
  }

  @Test
  public void getSunk() {
    Assert.assertFalse(shipCell4.getSunk());
  }

  @Test
  public void placeShipOnCell() {
    Assert.assertFalse(shipCell1.placeShipOnCell());
  }

  @Test
  public void setHit() {
    shipCell4.setHit(true);
    Assert.assertTrue(shipCell4.isCellHit());
  }
}