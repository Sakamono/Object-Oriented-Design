package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.game.Game;

/**
 * Represents a game observer.
 */
public interface GameObserver {

  /**
   * Update the state of the observable game.
   *
   * @param observable a game
   */
  void update(Game observable);
}
