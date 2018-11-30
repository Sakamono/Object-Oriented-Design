package edu.neu.ccs.cs5004.model.attackresult;

/**
 * Represents the attack result Miss, which means the hit cell does not
 * contain a ship.
 */
public class Miss implements AttackResult {

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
    return 23;
  }

  @Override
  public String toString() {
    return "Miss";
  }
}
