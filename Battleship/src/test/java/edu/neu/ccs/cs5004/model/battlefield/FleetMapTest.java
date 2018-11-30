package edu.neu.ccs.cs5004.model.battlefield;

import edu.neu.ccs.cs5004.model.ship.Ship;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayInputStream;

import edu.neu.ccs.cs5004.model.cell.Cell;
import edu.neu.ccs.cs5004.model.cell.OpenSeaWaterCell;
import edu.neu.ccs.cs5004.model.ship.BattleShip;
import edu.neu.ccs.cs5004.model.player.Player;

import static org.junit.Assert.*;

public class FleetMapTest {
  private FleetMap fleetMap1;
  private FleetMap fleetMap2;
  private FleetMap fleetMap3;
  private FleetMap fleetMap4;
  private Map shipMap;
  private Map shipMap1;
  private Cell[][] cells;
  private OpenSeaWaterCell cell1;
  private Ship ship;
  private Player player;

  @Before
  public void setUp() throws Exception {
    fleetMap1 = new FleetMap(0, 0, 0, 0);
    fleetMap2 = fleetMap1;
    fleetMap4 = fleetMap2;
    fleetMap3 = new FleetMap(1, 1, 1, 1);
    shipMap = new Map();
    shipMap1 = new Map();
    ship = Ship.createBattleShip();
    cell1 = new OpenSeaWaterCell();
    shipMap1.setCell(cell1, Row.ROW1, Column.C);
    cells = new Cell[Map.ROW][Map.COLUMN];
    for (Row row : Row.values()) {
      for (Column column : Column.values()) {
        cells[row.ordinal()][column.ordinal()] = new OpenSeaWaterCell();
      }

    }
  }

  @Test
  public void getMap() {
    Assert.assertTrue(fleetMap1.getMap().equals(fleetMap2.getMap()));
  }

  @Test(expected = RuntimeException.class)
  public void placeShip() {
    fleetMap1.placeShip(Row.ROW1, Column.C, Direction.Horizontal, ship);
    fleetMap1.placeShip(Row.ROW5, Column.E, Direction.Vertical, ship);
    fleetMap1.placeShip(Row.ROW5, Column.J, Direction.Vertical, ship);
    fleetMap1.placeShip(Row.ROW9, Column.J, Direction.Horizontal, ship);
    fleetMap1.placeShip(Row.ROW9, Column.J, Direction.Vertical, ship);
  }

  @Test
  public void canPlaceShip() {
    Assert.assertEquals(fleetMap1.canPlaceShip(Row.ROW9, Column.J, Direction.Horizontal, ship), false);
    Assert.assertEquals(fleetMap1.canPlaceShip(Row.ROW9, Column.J, Direction.Vertical, ship), false);
  }

  @Test
  public void randomPlacement() {
    fleetMap1.randomPlacement();
    fleetMap3.randomPlacement();
  }

  @Test
  public void playerPlace() {
    fleetMap1.playerPlace(ship,0);
    fleetMap3.playerPlace(ship,0);


  }

  @Test
  public void getNumBattle() {
    Assert.assertEquals(0, fleetMap1.getNumBattle());
  }

  @Test
  public void getNumCruiser() {
    Assert.assertEquals(0, fleetMap2.getNumCruiser());
  }

  @Test
  public void getNumSubmarine() {
    Assert.assertEquals(0, fleetMap2.getNumSubmarine());
  }

  @Test
  public void getNumDestroyer() {
    Assert.assertEquals(0, fleetMap2.getNumDestroyer());
  }

  @Test
  public void setMap() {
    fleetMap1.setMap(true);
  }

  @Test
  public void equals() {
    FleetMap nullFleetMap = null;
    int num = 0;
    int num1 = 1;

    Assert.assertTrue(fleetMap1.equals(fleetMap1));
    Assert.assertTrue(fleetMap1.equals(fleetMap2));
    Assert.assertTrue(fleetMap2.equals(fleetMap1));
    Assert.assertEquals(fleetMap1.equals(fleetMap2) && fleetMap2.equals(fleetMap4), fleetMap1.equals(fleetMap4));
    Assert.assertFalse(fleetMap1.equals(fleetMap3));
    Assert.assertFalse(fleetMap1.equals(nullFleetMap));
    Assert.assertTrue(num ==(fleetMap1.getNumBattle()));
    Assert.assertTrue(num1 == (fleetMap3.getNumCruiser()));
    Assert.assertTrue(num1 == fleetMap3.getNumDestroyer());
    Assert.assertTrue(num1 == (fleetMap3.getNumSubmarine()));
    Assert.assertTrue(fleetMap1.getMap().equals(shipMap));
    Assert.assertFalse(fleetMap1.equals(num));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(fleetMap1.hashCode(), fleetMap2.hashCode());
  }
}