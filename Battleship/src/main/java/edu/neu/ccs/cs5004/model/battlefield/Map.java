package edu.neu.ccs.cs5004.model.battlefield;

import edu.neu.ccs.cs5004.model.cell.Cell;
import edu.neu.ccs.cs5004.model.cell.OpenSeaWaterCell;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents the map of the game.
 */
public class Map {
  public static final Integer ROW = 10;
  public static final Integer COLUMN = 10;
  private Cell[][] cells;

  /**
   * Creates a new map and set all the cells to open sea water cells.
   */
  public Map() {
    cells = new Cell[ROW][COLUMN];
    for (Row row : Row.values()) {
      for (Column column : Column.values()) {
        cells[row.ordinal()][column.ordinal()] = new OpenSeaWaterCell();
      }
    }
  }

  /**
   * Gets the 2D array of cells.
   *
   * @return Cell[][]
   */
  public Cell[][] getCells() {
    Cell[][] result = cells;
    return result;
  }

  /**
   * Gets the specific cell in this map with a given position.
   *
   * @param row    The row of the cell position in map
   * @param column The column of the cell position im map
   */
  public Cell getCell(Row row, Column column) {
    return this.cells[row.ordinal()][column.ordinal()];
  }

  /**
   * Sets the cell to specific position in map.
   *
   * @param cell   Cell
   * @param row    Row
   * @param column Column
   */
  public void setCell(Cell cell, Row row, Column column) {
    cells[row.ordinal()][column.ordinal()] = cell;
  }

  /**
   * Prints the map.
   *
   * @param printer ConsolePrinter
   */
  public void prettyPrint(ConsolePrinter printer) {
    printer.toConsole(this);
  }


  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Map map = (Map) object;
    Cell[][] cells = map.getCells();
    for (Row row : Row.values()) {
      for (Column column : Column.values()) {
        if (!cells[row.ordinal()][column.ordinal()]
            .equals(this.cells[row.ordinal()][column.ordinal()])) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 13;
  }
}
