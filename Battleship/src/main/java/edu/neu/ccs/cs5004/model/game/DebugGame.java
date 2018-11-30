package edu.neu.ccs.cs5004.model.game;


import edu.neu.ccs.cs5004.model.battlefield.BattleMap;
import edu.neu.ccs.cs5004.model.battlefield.FleetMap;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

/**
 * Represents a debug mode game and it's behaviors.
 */
public class DebugGame extends AbstractGame {

  /**
   * Creates a debug mode game.
   *
   * @param numBattle    number of battleships
   * @param numCruiser   number of cruisers
   * @param numSubmarine number of submarines
   * @param numDestroyer number of destroyers
   * @param randPlace    true for random ship placement and false for user placement
   */
  public DebugGame(int numBattle, int numCruiser, int numSubmarine,
                   int numDestroyer, boolean randPlace) {
    FleetMap userFleet = new FleetMap(numBattle, numCruiser, numSubmarine, numDestroyer);
    FleetMap robotFleet = new FleetMap(numBattle, numCruiser, numSubmarine, numDestroyer);
    BattleMap userBattle = new BattleMap(robotFleet);
    BattleMap robotBattle = new BattleMap(userFleet);
    user = Player.createUserPlayer(randPlace, userFleet, userBattle);
    robot = Player.createRobotPlayer(robotFleet, robotBattle);
  }

  @Override
  public void printGame(ConsolePrinter printer) {
    printer.printDebugGame(this);
  }

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
    return 57;
  }

}
