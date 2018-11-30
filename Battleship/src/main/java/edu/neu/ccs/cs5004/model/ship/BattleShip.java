package edu.neu.ccs.cs5004.model.ship;

/**
 * Represents a BattleShip.
 * Where size is the number of cells which is greater than 0 and less or equal to 4, and
 * number of hit cells is the number of cells that were hit, which is greater or equal to 0
 * and less or equal to size
 */
public class BattleShip extends AbstractShip {
  private static final Integer CELL_OCCUPY = 4;
  private static final Integer UN_HIT_SHIP_CELL = 0;

  /**
   * Creates a BattleShip with fixed size and zero hit cell.
   */
  BattleShip() {
    super(CELL_OCCUPY, UN_HIT_SHIP_CELL);
  }


  @Override
  public String toString() {
    return "BattleShip{"
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
    return "BattleShip";
  }
}
