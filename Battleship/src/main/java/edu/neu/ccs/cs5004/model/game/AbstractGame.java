package edu.neu.ccs.cs5004.model.game;

import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.player.Player;
import edu.neu.ccs.cs5004.view.ConsolePrinter;
import edu.neu.ccs.cs5004.view.GameObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents an abstract battleship game.
 */
public abstract class AbstractGame implements Game {
  protected Player user;
  protected Player robot;
  protected List<GameObserver> observers;

  /**
   * Creates an abstract game.
   */
  public AbstractGame() {
    observers = new ArrayList<>();
  }


  /**
   * Gets the user player.
   * @return the user player
   */
  public Player getUser() {
    return user;
  }

  /**
   * Gets the robot player.
   * @return  the robot player
   */
  public Player getRobot() {
    return robot;
  }

  @Override
  public AttackResult userFire() {
    AttackResult result = user.userAttack();
    notifyObservers();
    return result;
  }


  @Override
  public AttackResult robotFire() {
    AttackResult result = robot.randomAttack();
    return result;
  }

  @Override
  public AttackResult robotSmartFire() {
    return robot.smartAttack();
  }

  @Override
  public void printGame(ConsolePrinter printer) {
    printer.printRegularGame(this);
  }

  @Override
  public void registerObserver(GameObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(GameObserver observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    for (GameObserver obs : observers) {
      obs.update(this);
    }
  }

  @Override
  public boolean endGame() {
    return user.winGame() || robot.winGame();
  }


  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    AbstractGame that = (AbstractGame) object;
    return Objects.equals(user, that.user)
        && Objects.equals(robot, that.robot)
        && Objects.equals(observers, that.observers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(user, robot, observers);
  }
}
