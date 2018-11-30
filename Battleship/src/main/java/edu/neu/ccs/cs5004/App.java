package edu.neu.ccs.cs5004;


import edu.neu.ccs.cs5004.controller.Controller;

/**
 * Runs the game.
 */
public class App {
  public static void main(String[] args) {
    Controller controller = new Controller();
    controller.gameStart();
  }
}
