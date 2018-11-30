package edu.neu.ccs.cs5004.model.cell;

import java.util.Objects;

/**
 * Represents a cell with common attributes and behaviors.
 */
public abstract class AbstractCell implements Cell {
  protected Boolean isHit;

  /**
   * Creates a new abstract cell with its hit status and attack result.
   *
   * @param isHit the cell's hit status, true if it is hit and false otherwise
   */
  public AbstractCell(Boolean isHit) {
    this.isHit = isHit;
  }

  /**
   * Sets the hit status of the cell.
   *
   * @param hit true if the cell is hit and false otherwise
   */
  public void setHit(Boolean hit) {
    isHit = hit;
  }

  @Override
  public Boolean isCellHit() {
    return isHit;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractCell that = (AbstractCell) object;
    return Objects.equals(isHit, that.isHit);
  }

  @Override
  public int hashCode() {

    return Objects.hash(isHit);
  }
}
