package edu.neu.ccs.cs5004.model.ship;

/**
 * Represents a Cruiser.
 * Where size is the number of cells which is greater than 0 and less or equal to 3, and
 * number of hit cells is the number of cells that were hit, which is greater or equal to 0
 * and less or equal to size
 */
public class Cruiser extends AbstractShip {
  private static final Integer CELL_OCCUPY = 3;
  private static final Integer UN_HIT_SHIP_CELL = 0;

  /**
   * Creates a Cruiser with fixed size and zero hit cell.
   */
  Cruiser() {
    super(CELL_OCCUPY, UN_HIT_SHIP_CELL);
  }

  @Override
  public String toString() {
    return "Cruiser{"
        + "size=" + this.getSize()
        + ", hitCell=" + this.getHitCell()
        + '}';
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String getName() {
    return "Cruiser";
  }
}
