package edu.neu.ccs.cs5004.model.cell;

import edu.neu.ccs.cs5004.model.attackresult.AttackResult;

/**
 * Represents a cell in the Battleship game with common behaviors.
 */
public interface Cell {

  /**
   * Tells if a ship could be placed on the cell or not.
   *
   * @return true if a ship could be placed on the cell,
   *         and false otherwise
   */
  Boolean placeShipOnCell();

  /**
   * Attacks a cell and marks it as hit, which means set the value of
   * isHit field to be true.
   *
   * @return the original cell with its isHit field updated to be true
   */
  Cell attackCell();

  /**
   * Returns the attack result after being attacked.
   *
   * @return Miss: the guessed cell does not contain a ship;
   *         Hit: the guessed cell is a part of a ship, but there are other cells that
   *         have not been hit yet;
   *         Sunk: the cell is a part of the ship and all the other cells of the ship
   *         were hit(the ship has been sunk).
   */
  AttackResult attackResult();

  /**
   * Tells if the cell had been attacked.
   *
   * @return True if the cell has been attacked, and false otherwise
   */
  Boolean isCellHit();
}
