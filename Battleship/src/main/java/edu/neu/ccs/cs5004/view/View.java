package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.game.Game;

/**
 * Represents the View of the game.
 */
public class View implements GameObserver {

  @Override
  public void update(Game observable) {
    ConsolePrinter printer = new ConsolePrinter();
    observable.printGame(printer);
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
    return 41;
  }

}
