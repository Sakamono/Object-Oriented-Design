package edu.neu.ccs.cs5004.model.ship;

import edu.neu.ccs.cs5004.model.battlefield.Column;
import edu.neu.ccs.cs5004.model.battlefield.Direction;
import edu.neu.ccs.cs5004.model.battlefield.Row;

import java.util.Objects;

/**
 * Represents a ship with common attributes and behaviors.
 * Where size is the number of cells which is greater than 0 and less or equal to 4, and
 * number of hit cells is the number of cells that were hit, which is greater or equal to 0
 * and less or equal to size.
 */
public abstract class AbstractShip implements Ship {
  protected Integer size;
  protected Integer hitCell;
  protected Direction direction;
  protected Row topLeftRow;
  protected Column topLeftColumn;

  /**
   * Creates an abstract ship with size and number of hit cells.
   *
   * @param size    the size of the ship
   * @param hitCell the number of hit cells of the ship
   */
  public AbstractShip(Integer size, Integer hitCell) {
    this.size = size;
    this.hitCell = hitCell;
    direction = null;
    topLeftColumn = null;
    topLeftRow = null;
  }

  @Override
  public Integer getSize() {
    return size;
  }

  @Override
  public Integer getHitCell() {
    return hitCell;
  }


  @Override
  public Direction getDirection() {
    return direction;
  }

  @Override
  public Row getTopLeftRow() {
    return topLeftRow;
  }

  @Override
  public Column getTopLeftColumn() {
    return topLeftColumn;
  }

  @Override
  public Ship hitShip() {
    hitCell++;
    return this;
  }


  @Override
  public Boolean isSunk() {
    return hitCell.equals(size);
  }

  @Override
  public void setShip(Row row, Column column, Direction direction) {
    topLeftRow = row;
    topLeftColumn = column;
    this.direction = direction;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractShip abstractship = (AbstractShip) object;
    return Objects.equals(getSize(), abstractship.getSize())
        && Objects.equals(hitCell, abstractship.hitCell);
  }

  @Override
  public int hashCode() {

    return Objects.hash(getSize(), hitCell);
  }

}
