package edu.neu.ccs.cs5004.model.cell;

import edu.neu.ccs.cs5004.model.attackresult.AttackResult;

/**
 * Represents an enemy ship cell.
 */
public class EnemyShipCell extends AbstractShipCell {

  /**
   * Creates a new enemy ship cell with hit and sunk status inherited from
   * super classes AbstractShipCell and AbstractCell.
   */
  public EnemyShipCell() {
  }

  @Override
  public Cell attackCell() {
    return null;
  }

  @Override
  public AttackResult attackResult() {
    return null;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 23;
  }

  @Override
  public String toString() {
    return "EnemyShipCell{"
        + ", isSunk=" + isSunk
        + ", isHit=" + isHit
        + '}';
  }

}
