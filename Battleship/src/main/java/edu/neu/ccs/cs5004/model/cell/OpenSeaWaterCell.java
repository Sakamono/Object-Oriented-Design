package edu.neu.ccs.cs5004.model.cell;

/**
 * Represents a open sea water cell.
 */
public class OpenSeaWaterCell extends AbstractWaterCell {
  /**
   * Creates a new open sea cell with all the fields inherited by super
   * classes AbstractCell and AbstractWaterCell.
   */
  public OpenSeaWaterCell() {
    super();
  }

  @Override
  public Boolean placeShipOnCell() {
    return true;
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
    return "OpenSeaWaterCell";
  }
}
