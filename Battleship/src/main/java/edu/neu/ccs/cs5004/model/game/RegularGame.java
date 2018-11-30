package edu.neu.ccs.cs5004.model.game;

import edu.neu.ccs.cs5004.model.Constant;
import edu.neu.ccs.cs5004.model.battlefield.BattleMap;
import edu.neu.ccs.cs5004.model.battlefield.FleetMap;
import edu.neu.ccs.cs5004.model.player.Player;

/**
 * Represents a regular game and it's behaviors.
 */
public class RegularGame extends AbstractGame {
  /**
   * Creates a regular game.
   *
   * @param randPlace true for random ship placement and false for user placement
   */
  public RegularGame(boolean randPlace) {
    FleetMap userFleet = new FleetMap(Constant.INT_ONE, Constant.INT_TWO,
        Constant.INT_THREE, Constant.INT_FOUR);
    FleetMap robotFleet = new FleetMap(Constant.INT_ONE, Constant.INT_TWO,
        Constant.INT_THREE, Constant.INT_FOUR);
    BattleMap userBattle = new BattleMap(robotFleet);
    BattleMap robotBattle = new BattleMap(userFleet);
    user = Player.createUserPlayer(randPlace, userFleet, userBattle);
    robot = Player.createRobotPlayer(robotFleet, robotBattle);
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
    return 19;
  }
}
