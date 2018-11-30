package edu.neu.ccs.cs5004.controller;

import edu.neu.ccs.cs5004.model.Constant;
import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.game.Game;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.GameObserver;
import edu.neu.ccs.cs5004.view.View;


import java.util.Objects;

/**
 * Controls the game, connecting Model and View.
 */
public class Controller {
  private GameObserver console;
  private Game game;
  private Boolean smartAttack;

  /**
   * Set the game with mode choose, place strategy choose and attack strategy choose.
   */
  private void setGame() {
    boolean debug = ConsolePrinter.mode();
    boolean randPlace = ConsolePrinter.randPlace();
    smartAttack = ConsolePrinter.smartAttack();
    if (debug) {
      setDebugGame(randPlace);
    } else {
      setRegularGame(randPlace);
    }
  }

  /**
   * Set a game with debug mode.
   *
   * @param randPlace boolean
   */
  private void setDebugGame(boolean randPlace) {
    int numBattle = ConsolePrinter.numOfShip(Constant.BATTLESHIP);
    int numCruiser = ConsolePrinter.numOfShip(Constant.CRUISER);
    int numSubmarine = ConsolePrinter.numOfShip(Constant.SUBMARINE);
    int numDestroyer = ConsolePrinter.numOfShip(Constant.DESTROYER);
    game = Game.createDebugGame(numBattle, numCruiser, numSubmarine, numDestroyer, randPlace);
  }

  /**
   * Set a game with game mode and the placement.
   *
   * @param randPlace boolean
   */
  private void setRegularGame(Boolean randPlace) {
    game = Game.createRegularGame(randPlace);
  }

  /**
   * Connect view and model.
   */
  private void gamePrepare() {
    ConsolePrinter.printName();
    setGame();
    console = new View();
    game.registerObserver(console);
    console.update(game);
    ConsolePrinter.gameStart();
  }

  /**
   * Game continue with round.
   */
  private void gameLoop() {
    robotFire();
  }

  /**
   * Robot fire round.
   */
  private void robotFire() {
    if (game.endGame()) {
      console.update(game);
      ConsolePrinter.printLose();
      return;
    } else {
      AttackResult result = smartAttack ? game.robotSmartFire() : game.robotFire();
      if (result.toString().equals(Constant.MISS)) {
        userFire();
      } else {
        robotFire();
      }
    }
  }

  /**
   * User fire round.
   */
  private void userFire() {
    if (game.endGame()) {
      ConsolePrinter.printWin();
      return;
    } else {
      AttackResult result = game.userFire();
      ConsolePrinter.attackMessage(result);
      if (result.toString().equals(Constant.MISS)) {
        robotFire();
      } else {
        userFire();
      }
    }
  }

  /**
   * Game start.
   */
  public void gameStart() {
    gamePrepare();
    gameLoop();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    Controller that = (Controller) object;
    return Objects.equals(console, that.console)
        && Objects.equals(game, that.game)
        && Objects.equals(smartAttack, that.smartAttack);
  }

  @Override
  public int hashCode() {
    return Objects.hash(console, game, smartAttack);
  }
}
