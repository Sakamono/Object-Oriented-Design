package edu.neu.ccs.cs5004.model.player;

import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.battlefield.BattleMap;
import edu.neu.ccs.cs5004.model.battlefield.FleetMap;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents the common behavior of the player in the game.
 */
public interface Player {


  /**
   * Represents the attack result of random strategy.
   *
   * @return an attack result
   */
  AttackResult randomAttack();

  /**
   * Represents the attack result of user strategy.
   *
   * @return an attack result
   */
  AttackResult userAttack();

  /**
   * Represents the attack result of smart strategy.
   *
   * @return an attack result
   */
  AttackResult smartAttack();

  /**
   * Tells if one of the players has win the game.
   *
   * @return true if wins the game and false otherwise
   */
  boolean winGame();

  /**
   * Prints the fleet map.
   *
   * @param printer the printer to print the map
   */
  void printFleet(ConsolePrinter printer);

  /**
   * Prints the battle map.
   *
   * @param printer the printer to print the map
   */
  void printBattle(ConsolePrinter printer);

  /**
   * Creates a user player.
   *
   * @param randPlace true if place the ship randomly and false to place the ship by the player
   * @param fleetMap  the fleet map of the player
   * @param battleMap the battle map of the player
   * @return a new user player
   */
  static Player createUserPlayer(boolean randPlace, FleetMap fleetMap, BattleMap battleMap) {
    return new AbstractPlayer(fleetMap, battleMap, randPlace);
  }

  /**
   * Creates a robot player.
   *
   * @param fleetMap  the fleet map of the player
   * @param battleMap the battle map of the player
   * @return a new robot player
   */
  static Player createRobotPlayer(FleetMap fleetMap, BattleMap battleMap) {
    return new AbstractPlayer(fleetMap, battleMap, true);
  }
}
