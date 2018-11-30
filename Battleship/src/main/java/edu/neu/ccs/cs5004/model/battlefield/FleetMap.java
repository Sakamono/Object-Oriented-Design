package edu.neu.ccs.cs5004.model.battlefield;

import edu.neu.ccs.cs5004.model.Constant;
import edu.neu.ccs.cs5004.model.cell.GapWaterCell;
import edu.neu.ccs.cs5004.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.model.ship.Ship;
import edu.neu.ccs.cs5004.view.ConsolePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

/**
 * Represents the fleet map of a player.
 */
public class FleetMap {
  private Map map;
  private int numBattle;
  private int numCruiser;
  private int numSubmarine;
  private int numDestroyer;


  /**
   * Creates a fleet map.
   *
   * @param numBattle    The number of BattleShip
   * @param numCruiser   The number of Cruiser
   * @param numSubmarine The number of Submarine
   * @param numDestroyer The number of Destroyer
   */
  public FleetMap(int numBattle, int numCruiser, int numSubmarine, int numDestroyer) {
    map = new Map();
    this.numBattle = numBattle;
    this.numCruiser = numCruiser;
    this.numSubmarine = numSubmarine;
    this.numDestroyer = numDestroyer;
  }

  /**
   * Return the map of this fleet map.
   *
   * @return Map
   */
  public Map getMap() {
    return map;
  }

  /**
   * Place a ship in the map with given top left cell and the direction.
   *
   * @param row       The row of the top left cell
   * @param column    The column of the top left cell
   * @param direction The direction of the ship
   * @param ship      The kind of the ship
   */
  public void placeShip(Row row, Column column, Direction direction, Ship ship) {
    if (!canPlaceShip(row, column, direction, ship)) {
      throw new RuntimeException(Constant.INVALID_PLACE);
    }
    ship.setShip(row, column, direction);
    switch (direction) {
      case Horizontal:
        for (int i = 0; i < ship.getSize(); i++) {
          if (row.ordinal() - 1 >= 0) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() - 1],
                Column.values()[column.ordinal() + i]);
          }
          if (row.ordinal() + 1 < Map.ROW) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + 1],
                Column.values()[column.ordinal() + i]);
          }
          map.setCell(new SpecificShipCell(ship), row, Column.values()[column.ordinal() + i]);
        }
        for (int i = -1; i < 2; i++) {
          if (row.ordinal() + i >= 0 && row.ordinal() + i < Map.ROW) {
            if (column.ordinal() - 1 >= 0) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i],
                  Column.values()[column.ordinal() - 1]);
            }
            if (column.ordinal() + ship.getSize() < Map.COLUMN) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i],
                  Column.values()[column.ordinal() + ship.getSize()]);
            }
          }
        }
        break;
      case Vertical:
        for (int i = 0; i < ship.getSize(); i++) {
          if (column.ordinal() - 1 >= 0) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i],
                Column.values()[column.ordinal() - 0]);
          }
          if (column.ordinal() + 1 < Map.COLUMN) {
            map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + i],
                Column.values()[column.ordinal() + 0]);
          }
          map.setCell(new SpecificShipCell(ship), Row.values()[row.ordinal() + i], column);
        }
        for (int i = -1; i < 2; i++) {
          if (column.ordinal() + i >= 0 && column.ordinal() + i < Map.COLUMN) {
            if (row.ordinal() - 1 >= 0) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() - 1],
                  Column.values()[column.ordinal() + i]);
            }
            if (row.ordinal() + ship.getSize() < Map.ROW) {
              map.setCell(new GapWaterCell(), Row.values()[row.ordinal() + ship.getSize()],
                  Column.values()[column.ordinal() + i]);
            }
          }
        }
        break;
      default:
        break;
    }
  }

  /**
   * Tells if a ship can be placed in this cell as its left corner cell.
   *
   * @param row       The row of the top left cell
   * @param column    The column of the top left cell
   * @param direction The direction of the ship
   * @param ship      The kind of the ship
   * @return true if user can place the ship and false otherwise
   */
  public boolean canPlaceShip(Row row, Column column, Direction direction, Ship ship) {
    switch (direction) {
      case Horizontal:
        if (column.ordinal() + ship.getSize() > Map.COLUMN) {
          return false;
        }
        for (int i = 0; i < ship.getSize(); i++) {
          if (!map.getCell(row, Column.values()[column.ordinal() + i]).placeShipOnCell()) {
            return false;
          }
        }
        return true;
      case Vertical:
        if (row.ordinal() + ship.getSize() > Map.ROW) {
          return false;
        }
        for (int i = 0; i < ship.getSize(); i++) {
          if (!map.getCell(Row.values()[row.ordinal() + i], column).placeShipOnCell()) {
            return false;
          }
        }
        return true;
      default:
        break;
    }
    return false;
  }

  /**
   * Randomly place the ship on the map.
   */
  public void randomPlacement() {
    Random index = new Random();
    Row row = Row.values()[index.nextInt(Constant.INT_TEN)];
    Column column = Column.values()[index.nextInt(Constant.INT_TEN)];
    Direction direction = Direction.values()[index.nextInt(2)];
    for (int i = 0; i < numBattle; i++) {
      Ship ship = Ship.createBattleShip();
      while (!canPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(Constant.INT_TEN)];
        column = Column.values()[index.nextInt(Constant.INT_TEN)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row, column, direction, ship);
    }
    for (int i = 0; i < numCruiser; i++) {
      Ship ship = Ship.createCruiser();
      while (!canPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(Constant.INT_TEN)];
        column = Column.values()[index.nextInt(Constant.INT_TEN)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row, column, direction, ship);
    }
    for (int i = 0; i < numSubmarine; i++) {
      Ship ship = Ship.createSubmarine();
      while (!canPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(Constant.INT_TEN)];
        column = Column.values()[index.nextInt(Constant.INT_TEN)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row, column, direction, ship);
    }
    for (int i = 0; i < numDestroyer; i++) {
      Ship ship = Ship.createDestroyer();
      while (!canPlaceShip(row, column, direction, ship)) {
        row = Row.values()[index.nextInt(Constant.INT_TEN)];
        column = Column.values()[index.nextInt(Constant.INT_TEN)];
        direction = Direction.values()[index.nextInt(2)];
      }
      placeShip(row, column, direction, ship);
    }
  }

  /**
   * Lets player to place ship on the board.
   *
   * @param ship the ship to be placed
   * @param num the number of the ship
   */
  public void playerPlace(Ship ship, int num) {
    BufferedReader bufferedReader = null;
//    System.out.println(Constant.PLACE + num + Constant.SPACE + ship.getName());
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, Constant.CHARSET));
      int index = 1;
      while (index <= num) {
        System.out.println(Constant.PLACE + index + Constant.SPACE + ship.getName());
        System.out.print(Constant.ROW);
        String str1 = bufferedReader.readLine();
        if (str1 == null) {
          break;
        }
        try {
          if (!(Integer.parseInt(str1) > 0
              && Integer.parseInt(str1) <= Constant.INT_TEN)) {
            System.out.println(Constant.INVALID_INPUT);
            continue;
          }
        } catch (NumberFormatException e) {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }

        System.out.print(Constant.COLUMN);
        String str2 = bufferedReader.readLine();
        if (str2 == null) {
          break;
        }
        try {
          if (!(str2.charAt(0)
              >= Constant.CHAR_A && str2.charAt(0) <= Constant.CHAR_J)) {
            System.out.println(Constant.INVALID_INPUT);
            continue;
          }
        } catch (StringIndexOutOfBoundsException e) {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }


        System.out.print(Constant.DIRECTION);
        String str3 = bufferedReader.readLine();
        if (str3 == null) {
          break;
        }
        try {
          if (Integer.parseInt(str3) != 0
              && Integer.parseInt(str3) != 1) {
            System.out.println(Constant.INVALID_INPUT);
            continue;
          }
        } catch (NumberFormatException e) {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }
        Row row = Row.values()[Integer.parseInt(str1) - 1];
        Column column = Column.values()[str2.charAt(0) - Constant.CHAR_A];
        Direction direction = Direction.values()[Integer.parseInt(str3)];

        if (canPlaceShip(row, column, direction, ship)) {
          placeShip(row, column, direction, ship);
          index++;
        }
        map.prettyPrint(new ConsolePrinter());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Gets the number of battle ship.
   * @return the number of battle ship
   */
  public int getNumBattle() {
    return numBattle;
  }

  /**
   * Gets the number of cruiser.
   * @return the number of cruiser
   */
  public int getNumCruiser() {
    return numCruiser;
  }

  /**
   * Gets the number of submarine.
   * @return the number of submarine
   */
  public int getNumSubmarine() {
    return numSubmarine;
  }

  /**
   * Gets the number of destroyer.
   * @return the number of destroyer
   */
  public int getNumDestroyer() {
    return numDestroyer;
  }

  /**
   * Set up the map with ship.
   */
  public void setMap(boolean randomSet) {
    if (randomSet) {
      randomPlacement();
    } else {
      playerPlace(Ship.createBattleShip(), numBattle);
      playerPlace(Ship.createCruiser(), numCruiser);
      playerPlace(Ship.createSubmarine(), numSubmarine);
      playerPlace(Ship.createDestroyer(), numDestroyer);
    }
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    FleetMap fleetMap = (FleetMap) object;
    return numBattle == fleetMap.numBattle
        && numCruiser == fleetMap.numCruiser
        && numSubmarine == fleetMap.numSubmarine
        && numDestroyer == fleetMap.numDestroyer
        && Objects.equals(map, fleetMap.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(map, numBattle, numCruiser, numSubmarine, numDestroyer);
  }
}
