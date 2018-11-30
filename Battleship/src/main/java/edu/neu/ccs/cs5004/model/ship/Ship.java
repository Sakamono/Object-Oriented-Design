package edu.neu.ccs.cs5004.model.ship;


import edu.neu.ccs.cs5004.model.battlefield.Column;
import edu.neu.ccs.cs5004.model.battlefield.Direction;
import edu.neu.ccs.cs5004.model.battlefield.Row;

/**
 * Represents a ship in the Battleship game with common behaviors.
 */
public interface Ship {

  /**
   * Creates a BattleShip.
   *
   * @return a BattleShip
   */
  static Ship createBattleShip() {
    return new BattleShip();
  }

  /**
   * Creates a Cruiser.
   *
   * @return a Cruiser
   */
  static Ship createCruiser() {
    return new Cruiser();
  }

  /**
   * Creates a Submarine.
   *
   * @return a Submarine
   */
  static Ship createSubmarine() {
    return new Submarine();
  }

  /**
   * Creates a Destroyer.
   *
   * @return a Destroyer
   */
  static Ship createDestroyer() {
    return new Destroyer();
  }


  /**
   * Hits a ship and increases its number of hit cells.
   *
   * @return the original ship with the number of hit cells updated
   */
  Ship hitShip();

  /**
   * Returns whether a ship is sunk or not.
   *
   * @return true if the ship is sunk, and false otherwise
   */
  Boolean isSunk();

  /**
   * Gets the size (the number of cells) of the ship.
   *
   * @return the size of the ship
   */
  Integer getSize();

  /**
   * Return the number of cells that are attacked.
   *
   * @return the number of hit cells
   */
  Integer getHitCell();

  /**
   * Gets the name of the ship.
   *
   * @return a string representing the name of the ship
   */
  String getName();

  /**
   * Gets the direction of a ship.
   *
   * @return the direction of the ship
   */
  Direction getDirection();


  /**
   * Gets the row name of the first cell of the ship.
   *
   * @return the row name
   */
  Row getTopLeftRow();


  /**
   * Gets the column name of the first cell of the ship.
   *
   * @return the column name
   */
  Column getTopLeftColumn();

  /**
   * Set the top left position and the direction of the ship.
   */
  void setShip(Row row, Column column, Direction direction);

}
