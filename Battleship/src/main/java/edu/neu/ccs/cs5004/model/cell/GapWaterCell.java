package edu.neu.ccs.cs5004.model.cell;

/**
 * Represents a gap water cell.
 */
public class GapWaterCell extends AbstractWaterCell {
  /**
   * Creates a new gap water cell with all the fields inherited by super
   * classes AbstractCell and AbstractWaterCell.
   */
  public GapWaterCell() {
    super();
  }

  @Override
  public Boolean placeShipOnCell() {
    return false;
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode() * 31;
  }

  @Override
  public String toString() {
    return "GapWaterCell";
  }
}
