package edu.neu.ccs.cs5004.model.battlefield;

import edu.neu.ccs.cs5004.model.ship.Ship;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import edu.neu.ccs.cs5004.model.cell.Cell;
import edu.neu.ccs.cs5004.model.cell.GapWaterCell;
import edu.neu.ccs.cs5004.model.cell.OpenSeaWaterCell;
import edu.neu.ccs.cs5004.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

import static org.junit.Assert.*;

public class MapTest {
  Map map;
  Map map1;
  Map map2;
  Cell cell1;
  Cell cell2;
  Cell cell3;
  Cell cell4;

  @Before
  public void setUp() throws Exception {
    map = new Map();
    map1 = new Map();
    map2 = new Map();
    cell1 = new GapWaterCell();
    cell2 = new SpecificShipCell(Ship.createBattleShip());
    cell3 = new SpecificShipCell(Ship.createDestroyer());
    cell4 = new OpenSeaWaterCell();
  }

  @Test
  public void getCell() {
    Assert.assertEquals(cell4, map.getCell(Row.ROW1, Column.C));
  }

  @Test
  public void setCell() {
    map.setCell(cell2, Row.ROW2, Column.D);
    Assert.assertEquals(cell2, map.getCell(Row.ROW2, Column.D));
  }

  @Test
  public void prettyPrint() {
    map.setCell(cell3, Row.ROW1, Column.A);
    map.setCell(cell3, Row.ROW2, Column.B);
    map.setCell(cell3, Row.ROW3, Column.C);
    map.setCell(cell3, Row.ROW4, Column.D);
    map.setCell(cell3, Row.ROW5, Column.E);
    map.setCell(cell3, Row.ROW6, Column.F);
    map.setCell(cell3, Row.ROW7, Column.G);
    ConsolePrinter printer = new ConsolePrinter();
    map.prettyPrint(printer);
  }

  @Test
  public void equals() {
    Map test = new Map();
    test.setCell(cell2, Row.ROW2, Column.D);
    Assert.assertTrue(map.equals(map));
    Assert.assertTrue(map.equals(map1));
    Assert.assertTrue(map1.equals(map));
    Assert.assertTrue(map1.equals(map2));
    Assert.assertTrue(map.equals(map2));
    Assert.assertFalse(map.equals(null));
    Assert.assertFalse(map.equals(test));
  }

  @Test
  public void testHashCode() {
    assertEquals(map.equals(map1), map.hashCode() == map1.hashCode());
  }
}