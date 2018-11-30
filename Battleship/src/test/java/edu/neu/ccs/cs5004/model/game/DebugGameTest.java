package edu.neu.ccs.cs5004.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sun.java2d.pipe.AAShapePipe;

import edu.neu.ccs.cs5004.view.ConsolePrinter;

import static org.junit.Assert.*;

public class DebugGameTest {
  private DebugGame game;
  private DebugGame game1;
  private DebugGame game2;
  private ConsolePrinter printer;

  @Before
  public void setUp() throws Exception {
    game = new DebugGame(0,0,0,0,false);
    game1 = game;
    game2 = new DebugGame(1,1,1,1,true);
    printer = new ConsolePrinter();
  }

  @Test
  public void printGame() {
    game.printGame(printer);
  }

  @Test
  public void equals() {
    DebugGame nullGame = null;
    Assert.assertTrue(game.equals(game));
    Assert.assertTrue(game.equals(game1));
    Assert.assertTrue(game.equals(game2));
    Assert.assertFalse(game.equals(nullGame));
    Assert.assertFalse(game.equals(new String("a")));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(game.hashCode(),game1.hashCode());
  }
}