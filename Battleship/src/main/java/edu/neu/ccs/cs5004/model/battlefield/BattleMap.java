package edu.neu.ccs.cs5004.model.battlefield;

import edu.neu.ccs.cs5004.model.Constant;
import edu.neu.ccs.cs5004.model.attackresult.AttackResult;
import edu.neu.ccs.cs5004.model.cell.SpecificShipCell;
import edu.neu.ccs.cs5004.model.ship.Ship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Random;

/**
 * Represents the battle map of a player.
 */
public class BattleMap {
  private FleetMap map;
  private int numBattle;
  private int numCruiser;
  private int numSubmarine;
  private int numDestroyer;

  /**
   * Creates a battle map.
   *
   * @param map the fleet map that battle map have
   */
  public BattleMap(FleetMap map) {
    this.map = map;
    this.numBattle = 0;
    this.numCruiser = 0;
    this.numSubmarine = 0;
    this.numDestroyer = 0;

  }

  /**
   * Attacks the cell and set the attacked cell sunk.
   *
   * @param row    the row of the cell
   * @param column the column of the cell
   */
  public void attack(Row row, Column column) {
    if (map.getMap().getCell(row, column).attackCell().attackResult()
        .toString().equals(Constant.SUNK)) {
      SpecificShipCell cell = (SpecificShipCell) map.getMap().getCell(row, column);
      sunkSet(cell.getShip(), map.getMap());
    }
  }

  /**
   * Attacks a cell using random strategy.
   *
   * @return attack result of this attack
   */
  public AttackResult randomAttack() {
    Random index = new Random();
    Row row = Row.values()[index.nextInt(10)];
    Column column = Column.values()[index.nextInt(10)];
    while (map.getMap().getCell(row, column).isCellHit()) {
      row = Row.values()[index.nextInt(10)];
      column = Column.values()[index.nextInt(10)];
    }
    attack(row, column);
    return map.getMap().getCell(row, column).attackResult();
  }

  /**
   * Attacks a cell using smart strategy.
   *
   * @return an attack result
   */
  public AttackResult smartAttack() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        Row row = Row.values()[i];
        Column column = Column.values()[j];
        if (map.getMap().getCell(row, column).isCellHit()
            && map.getMap().getCell(row, column).attackResult().toString().equals(Constant.HIT)) {
          if (j + 1 < 10
              && map.getMap().getCell(row, Column.values()[j + 1]).isCellHit()
              && map.getMap().getCell(row, Column.values()[j + 1]).attackResult()
              .toString().equals(Constant.HIT)) {
            int index = j - 1
                >= 0 ? -1 : 2;
            while (j + index < 10 && map.getMap().getCell(row, column).isCellHit()) {
              column = Column.values()[j + index];
              index++;
            }
          } else if (i + 1 < 10 && map.getMap()
              .getCell(Row.values()[i + 1], column).isCellHit()
              && map.getMap().getCell(Row.values()[i + 1], column)
              .attackResult().toString().equals(Constant.HIT)) {
            int index = i - 1
                >= 0 ? -1 : 2;
            while (i + index < 10 && map.getMap().getCell(row, column).isCellHit()) {
              row = Row.values()[i + index];
              index++;
            }
          } else if (i - 1 >= 0
              && !map.getMap().getCell(Row.values()[i - 1], column).isCellHit()) {
            row = Row.values()[i - 1];
          } else if (i + 1 < 10
              && !map.getMap().getCell(Row.values()[i + 1], column).isCellHit()) {
            row = Row.values()[i + 1];
          } else if (j - 1 >= 0
              && !map.getMap().getCell(row, Column.values()[j - 1]).isCellHit()) {
            column = Column.values()[j - 1];
          } else if (j + 1 < 10
              && !map.getMap().getCell(row, Column.values()[j + 1]).isCellHit()) {
            column = Column.values()[j + 1];
          } else {
            break;
          }
          attack(row, column);
          return map.getMap().getCell(row, column).attackResult();
        }
      }
    }
    return randomAttack();
  }

  /**
   * Sets a ship as sunk.
   * @param ship the ship to be attacked
   * @param map the map that has the ship
   */
  public void sunkSet(Ship ship, Map map) {
    Row row = ship.getTopLeftRow();
    Column column = ship.getTopLeftColumn();
    Direction direction = ship.getDirection();
    switch (direction) {
      case Horizontal:
        for (int i = 0; i < ship.getSize(); i++) {
          if (row.ordinal() - 1 >= 0) {
            map.getCell(Row.values()[row.ordinal() - 1],
                Column.values()[column.ordinal() + i]).attackCell();
          }
          if (row.ordinal() + 1 < Map.ROW) {
            map.getCell(Row.values()[row.ordinal() + 1],
                Column.values()[column.ordinal() + i]).attackCell();
          }
        }
        for (int i = -1; i < 2; i++) {
          if (row.ordinal() + i >= 0 && row.ordinal() + i < Map.ROW) {
            if (column.ordinal() - 1 >= 0) {
              map.getCell(Row.values()[row.ordinal() + i],
                  Column.values()[column.ordinal() - 1]).attackCell();
            }
            if (column.ordinal() + ship.getSize() < Map.COLUMN) {
              map.getCell(Row.values()[row.ordinal() + i],
                  Column.values()[column.ordinal() + ship.getSize()]).attackCell();
            }
          }
        }
        break;
      case Vertical:
        for (int i = 0; i < ship.getSize(); i++) {
          if (column.ordinal() - 1 >= 0) {
            map.getCell(Row.values()[row.ordinal() + i],
                Column.values()[column.ordinal() - 1]).attackCell();
          }
          if (column.ordinal() + 1 < Map.COLUMN) {
            map.getCell(Row.values()[row.ordinal() + i],
                Column.values()[column.ordinal() + 1]).attackCell();
          }
        }
        for (int i = -1; i < 2; i++) {
          if (column.ordinal() + i >= 0 && column.ordinal() + i < Map.COLUMN) {
            if (row.ordinal() - 1 >= 0) {
              map.getCell(Row.values()[row.ordinal() - 1],
                  Column.values()[column.ordinal() + i]).attackCell();
            }
            if (row.ordinal() + ship.getSize() < Map.ROW) {
              map.getCell(Row.values()[row.ordinal() + ship.getSize()],
                  Column.values()[column.ordinal() + i]).attackCell();
            }
          }
        }
        break;
      default:
        break;
    }
    switch (ship.getName()) {
      case Constant.BATTLESHIP:
        numBattle++;
        break;
      case Constant.CRUISER:
        numCruiser++;
        break;
      case Constant.SUBMARINE:
        numSubmarine++;
        break;
      case Constant.DESTROYER:
        numDestroyer++;
        break;
      default:
        break;
    }
  }

  /**
   * Users attack the cell.
   *
   * @return AttackResult
   */
  public AttackResult userAttack() {
    BufferedReader bufferedReader = null;
    System.out.println(Constant.ATTACK);
    Row row;
    Column column;
    AttackResult result = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in, Constant.CHARSET));
      while (true) {
        System.out.print(Constant.ROW);
        String str1 = bufferedReader.readLine();
        if (str1 == null) {
          break;
        }
        try {
          if ((str1.length() != 1 && str1.length() != 2)
              || !(Integer.parseInt(str1) > 0
              && Integer.parseInt(str1) <= 10)) {
            System.out.println(Constant.INVALID_INPUT);
            continue;
          }
        } catch (NumberFormatException e) {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }
        row = Row.values()[Integer.parseInt(str1) - 1];
        System.out.print(Constant.COLUMN);
        String str2 = bufferedReader.readLine();
        if (str2 == null) {
          break;
        }

        try {
          if (str2.length() != 1 || !(str2.charAt(0)
              >= Constant.CHAR_A && str2.charAt(0) <= Constant.CHAR_J)) {
            System.out.println(Constant.INVALID_INPUT);
            continue;
          }
        } catch (StringIndexOutOfBoundsException e) {
          System.out.println(Constant.INVALID_INPUT);
          continue;
        }

        column = Column.values()[str2.charAt(0) - Constant.CHAR_A];

        if (!map.getMap().getCell(row, column).isCellHit()) {
          attack(row, column);
          result = map.getMap().getCell(row, column).attackResult();
          break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return result;
  }

  /**
   * Tells if the game is end.
   * @return true if the game is end and false otherwise
   */
  public boolean endGame() {
    return numBattle == map.getNumBattle()
        && numCruiser == map.getNumCruiser()
        && numSubmarine == map.getNumSubmarine()
        && numDestroyer == map.getNumDestroyer();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }
    BattleMap battleMap = (BattleMap) object;
    return numBattle == battleMap.numBattle
        && numCruiser == battleMap.numCruiser
        && numSubmarine == battleMap.numSubmarine
        && numDestroyer == battleMap.numDestroyer
        && Objects.equals(map, battleMap.map);
  }

  @Override
  public int hashCode() {
    return Objects.hash(map, numBattle, numCruiser, numSubmarine, numDestroyer);
  }
}
