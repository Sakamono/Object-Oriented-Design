package edu.neu.ccs.cs5004.model.attackresult;

/**
 * Represents the attack result Hit, which means the hit cell has a ship, but
 * there are other cells of the ship have not been hit.
 */

public class Hit implements AttackResult {

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || this.getClass() != object.getClass()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return 17;
  }

  @Override
  public String toString() {
    return "Hit";
  }
}
