package edu.neu.ccs.cs5004.model.attackresult;

/**
 * Represents the attack result when a cell got hit.
 * which can be:
 * Miss: the guessed cell does not contain a ship;
 * Hit: the guessed cell is a part of a ship, but there are other cells that
 * have not been hit yet;
 * Sunk: the cell is a part of the ship and all the other cells of the ship
 * were hit(the ship has been sunk).
 */
public interface AttackResult {
}
