package edu.neu.ccs.cs5004.model.game;

import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents the battleship game and common behaviors.
 */
public interface Game extends Subject {

  /**
   * Gets the attack result of user fire.
   *
   * @return an attack result
   */
  AttackResult userFire();

  /**
   * Gets the attack result of robot fire.
   *
   * @return an attack result
   */
  AttackResult robotFire();

  /**
   * Gets the attack result of smart fire.
   *
   * @return an attack result
   */
  AttackResult robotSmartFire();

  /**
   * Gets the user player.
   *
   * @return the user player
   */
  Player getUser();

  /**
   * Gets the robot player.
   *
   * @return the robot player
   */
  Player getRobot();


  /**
   * Prints the map of the game.
   *
   * @param printer the printer to printer the game
   */
  void printGame(ConsolePrinter printer);

  /**
   * Creates a regular game.
   *
   * @param randPlace true for random ship placement and false for user placement
   * @return a regular game
   */
  static Game createRegularGame(boolean randPlace) {
    return new RegularGame(randPlace);
  }

  /**
   * Creates a debug game.
   *
   * @param numBattle    the number of battle ship
   * @param numCruiser   the number of cruiser
   * @param numSubmarine the number of submarine
   * @param numDestroyer the number of destroyer
   * @param randPlace true if the game fleet map is randomly placed, and false if user placing
   * @return a debug game
   */
  static Game createDebugGame(int numBattle, int numCruiser, int numSubmarine,
                              int numDestroyer, boolean randPlace) {
    return new DebugGame(numBattle, numCruiser, numSubmarine, numDestroyer, randPlace);
  }

  /**
   * Tells if the game is end.
   *
   * @return true if the game is end and false otherwise
   */
  boolean endGame();
}
