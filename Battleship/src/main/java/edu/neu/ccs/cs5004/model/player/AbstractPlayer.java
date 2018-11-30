package edu.neu.ccs.cs5004.model.player;


import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.battlefield.BattleMap;
import edu.neu.ccs.cs5004.model.battlefield.FleetMap;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

import java.util.Objects;
import java.util.Observable;


/**
 * Represents an abstract player in the game.
 */
public class AbstractPlayer extends Observable implements Player {
  private FleetMap fleetMap;
  private BattleMap battleMap;

  /**
   * Creates a new abstract player in the game.
   *
   * @param fleetMap  the fleet map of the player
   * @param battleMap the battle map of the player
   * @param randPlace true if place the ship randomly and false to place the ship by the player
   */
  AbstractPlayer(FleetMap fleetMap, BattleMap battleMap, boolean randPlace) {
    this.fleetMap = fleetMap;
    this.battleMap = battleMap;
    fleetMap.setMap(randPlace);
  }

  @Override
  public AttackResult randomAttack() {
    return battleMap.randomAttack();
  }

  @Override
  public AttackResult userAttack() {
    return battleMap.userAttack();
  }

  @Override
  public AttackResult smartAttack() {
    return battleMap.smartAttack();
  }

  @Override
  public boolean winGame() {
    return battleMap.endGame();
  }

  @Override
  public void printFleet(ConsolePrinter printer) {
    printer.toConsole(fleetMap.getMap());
  }

  @Override
  public void printBattle(ConsolePrinter printer) {
    printer.toEnemyMap(fleetMap.getMap());
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractPlayer that = (AbstractPlayer) object;
    return Objects.equals(fleetMap, that.fleetMap)
        && Objects.equals(battleMap, that.battleMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fleetMap, battleMap);
  }
}
