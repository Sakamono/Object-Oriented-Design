package edu.neu.ccs.cs5004.model.cell;

import java.util.Objects;

/**
 * Represents a ship cell with common attributes and behaviors.
 */
public abstract class AbstractShipCell extends AbstractCell implements ShipCell {
  protected Boolean isSunk;

  /**
   * Creates a new abstract ship cell with its hit status and sunk status.
   */
  public AbstractShipCell() {
    super(false);
    this.isSunk = false;
  }

  /**
   * Sets the sunk status of cell.
   *
   * @param sunk true if the cell is sunk and false otherwise
   */
  public void setSunk(Boolean sunk) {
    isSunk = sunk;
  }

  /**
   * Gets the abstract ship cell's sunk status.
   *
   * @return true if the abstract ship cell is sunk,
   *         and false otherwise
   */
  public Boolean getSunk() {
    return isSunk;
  }

  @Override
  public Boolean placeShipOnCell() {
    return false;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    if (!super.equals(object)) {
      return false;
    }
    AbstractShipCell that = (AbstractShipCell) object;
    return Objects.equals(isSunk, that.isSunk);
  }

  @Override
  public int hashCode() {

    return Objects.hash(super.hashCode(), isSunk);
  }
}
