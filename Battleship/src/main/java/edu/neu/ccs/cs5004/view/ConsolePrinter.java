package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.Constant;
import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.battlefield.Map;
import edu.neu.ccs.cs5004.model.cell.Cell;
import edu.neu.ccs.cs5004.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.model.game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Represents a console printer to show game information and interact with players.
 */
public class ConsolePrinter {

  /**
   * Prints the fleet map: use " " represent the water cell,
   * use "o" represent ship cell.
   *
   * @param map the map to be printed
   */
  public void toConsole(Map map) {
    Cell[][] cells = map.getCells();
    System.out.println(Constant.COLUMN_NAME);
    System.out.println(Constant.LINE);
    for (int i = 0; i < cells.length; i++) {
      System.out.format(Constant.TYPE, i + 1);
      System.out.print(Constant.BAR);
      for (int j = 0; j < cells[0].length; j++) {

        if (cells[i][j].getClass() == SpecificShipCell.class) {
          if (cells[i][j].isCellHit()) {
            System.out.print(Constant.SHOW_HIT_SHIP_CELL + Constant.SPACE + Constant.BAR);
          } else {
            System.out.print(Constant.SHOW_SHIP_CELL + Constant.SPACE_BAR);
          }
        } else {
          if (cells[i][j].isCellHit()) {
            System.out.print(Constant.SHOW_GAP_CELL + Constant.SPACE_BAR);
          } else {
            System.out.print(Constant.SPACES + Constant.BAR);
          }
        }
      }
      System.out.println();
    }
    System.out.println(Constant.LINE);
  }

  /**
   * Prints the result of the guess map after each attack.
   *
   * @param map the map to be printed
   */
  public void toEnemyMap(Map map) {
    Cell[][] cells = map.getCells();
    System.out.println(Constant.COLUMN_NAME);
    System.out.println(Constant.LINE);
    for (int i = 0; i < cells.length; i++) {
      System.out.format(Constant.TYPE, i + 1);
      System.out.print(Constant.BAR);
      for (int j = 0; j < cells[0].length; j++) {
        if (cells[i][j].isCellHit()) {
          if (cells[i][j].getClass() == SpecificShipCell.class) {
            System.out.print(Constant.SHOW_HIT_SHIP_CELL + Constant.SPACE_BAR);
          } else {
            System.out.print(Constant.STAR_BAR);
          }
        } else {
          System.out.print(Constant.SPACES_BAR);
        }
      }
      System.out.println();
    }
    System.out.println(Constant.LINE);
  }

  /**
   * Prints the regular game maps.
   *
   * @param game the game to be printed
   */
  public void printRegularGame(Game game) {
    System.out.println(Constant.MY_FLEET);
    game.getUser().printFleet(this);
    System.out.println(Constant.MY_BATTLE);
    game.getRobot().printBattle(this);
  }

  /**
   * Prints the debug game maps.
   *
   * @param game the game to be printed
   */
  public void printDebugGame(Game game) {
    this.printRegularGame(game);
    System.out.println(Constant.ENEMY_FLEET);
    game.getRobot().printFleet(this);
    System.out.println(Constant.ENEMY_BATTLE);
    game.getUser().printBattle(this);
    System.out.println();
  }


  /**
   * Lets user to choose game mode or debug mode.
   *
   * @return true for game mode and false for debug mode
   */
  public static boolean mode() {
    BufferedReader bufferedReader;
    boolean result = false;
    System.out.print(Constant.CHOOSE_MODE);
    try {
      boolean correct = true;
      while (correct) {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in, Constant.CHARSET));
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.equals(Constant.STRING_G)) {
          result = false;
        } else if (str.equals(Constant.STRING_D)) {
          result = true;
        } else {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }
        correct = false;
      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Lets user to decide the number of ships in the debug mode.
   *
   * @param ship a string to represent different ships
   * @return number of each kind of ship
   */
  public static int numOfShip(String ship) {
    BufferedReader bufferedReader;
    int result = 0;
    try {
      boolean correct = true;
      while (correct) {
        System.out.print(Constant.GET_SHIP_NUMBER + ship + Constant.COLON);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in, Constant.CHARSET));
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        result = Integer.parseInt(str);
        if (result < 0 || result > 5) {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }
        correct = false;
      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Lets user to choose random placement or manual placement of ships.
   *
   * @return true for random placement and false for random placement
   */
  public static boolean randPlace() {
    BufferedReader bufferedReader;
    boolean result = false;
    try {
      boolean correct = true;
      while (correct) {
        System.out.print(Constant.CHOOSE_PLACE_MODE);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in, Constant.CHARSET));
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.equals(Constant.STRING_N)) {
          result = false;
        } else if (str.equals(Constant.STRING_Y)) {
          result = true;
        } else {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }
        correct = false;
      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Lets user to choose the robot strategy of smart or random.
   *
   * @return true for smart strategy and false for random strategy
   */
  public static boolean smartAttack() {
    BufferedReader bufferedReader;
    boolean result = false;
    try {
      boolean correct = true;
      while (correct) {
        System.out.print(Constant.CHOOSE_STRATEGY);
        bufferedReader = new BufferedReader(new InputStreamReader(System.in, Constant.CHARSET));
        String str = bufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (str.equals(Constant.STRING_R)) {
          result = false;
        } else if (str.equals(Constant.STRING_S)) {
          result = true;
        } else {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }
        correct = false;
      }
    } catch (
        IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Prints a string at the start of the game.
   */
  public static void gameStart() {
    System.out.println(Constant.GAME_START);
  }

  /**
   * Shows attack result.
   *
   * @param attackResult the attack result
   */
  public static void attackMessage(AttackResult attackResult) {
    System.out.println(attackResult.toString());
  }

  /**
   * Prints the user win message.
   */
  public static void printWin() {
    System.out.println(Constant.YOU_WIN);
  }

  /**
   * Prints the robot win message.
   */
  public static void printLose() {
    System.out.println(Constant.ROBOT_WIN);
  }

  /**
   * Prints the title of the game.
   */
  public static void printName() {
    System.out.println(Constant.NAME);
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
    return 5;
  }


}
