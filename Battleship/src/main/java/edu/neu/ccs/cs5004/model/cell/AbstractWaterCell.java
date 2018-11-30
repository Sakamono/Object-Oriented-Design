package edu.neu.ccs.cs5004.model.cell;

import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.attackresult.Miss;

/**
 * Represents a water cell with common behaviors.
 */
public abstract class AbstractWaterCell extends AbstractCell implements WaterCell {

  /**
   * Creates a new abstract water cell with default hit status false.
   */
  public AbstractWaterCell() {
    super(false);
  }

  @Override
  public Cell attackCell() {
    setHit(true);
    return this;
  }

  @Override
  public AttackResult attackResult() {
    return new Miss();
  }

  @Override
  public boolean equals(Object object) {
    return super.equals(object);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
