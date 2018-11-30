package edu.neu.ccs.cs5004.model.game;

import edu.neu.ccs.cs5004.view.GameObserver;

/**
 * Represents the interface of observable subject by loan observers.
 */
public interface Subject {
  /**
   * add observer to a list of observers.
   *
   * @param observer to register to the observable
   */
  void registerObserver(GameObserver observer);

  /**
   * remove observer from a list of observers.
   *
   * @param observer to remove
   */
  void removeObserver(GameObserver observer);

  /**
   * notify observer if a model was changed.
   */
  void notifyObservers();

}
