package edu.neu.ccs.cs5004.model.game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.model.player.AbstractPlayer;

import static org.junit.Assert.*;

public class RegularGameTest {
  private RegularGame game;
  private RegularGame game1;
  private RegularGame game2;

  @Before
  public void setUp() throws Exception {
    game = new RegularGame(false);
    game1= game;
    game2 = new RegularGame(true);

  }

  @Test
  public void equals() {
    RegularGame nullGame = null;
    Assert.assertTrue(game.equals(game));
    Assert.assertTrue(game.equals(game1));
    Assert.assertTrue(game.equals(game2));
    Assert.assertFalse(game.equals(nullGame));
    Assert.assertFalse(game.equals(new Integer(0)));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(game.hashCode(),game1.hashCode());
  }
}