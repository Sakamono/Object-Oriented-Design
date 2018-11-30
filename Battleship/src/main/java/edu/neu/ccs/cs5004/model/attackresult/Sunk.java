package edu.neu.ccs.cs5004.model.attackresult;

/**
 * Represents the attack result Sunk, which means the hit cell has a ship, and
 * all other cells of the ship have been hit(so the ship is sunk).
 */
public class Sunk implements AttackResult {

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
    return 31;
  }

  @Override
  public String toString() {
    return "Sunk";
  }

}
