package edu.neu.ccs.cs5004.model.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SunkTest {
  private Sunk sunk;
  private Sunk sameRefSunk;
  private Sunk sameStateAsSunk;
  private Sunk yetAnotherSunk;
  private Sunk nullSunk = null;

  @Before
  public void setUp() throws Exception {
    sunk = new Sunk();
    sameRefSunk = sunk;
    sameStateAsSunk = new Sunk();
    yetAnotherSunk = new Sunk();
  }


  @Test
  public void testEquals() {
    Assert.assertTrue(sunk.equals(sunk));
    Assert.assertTrue(sunk.equals(sameRefSunk));
    Assert.assertTrue(sunk.equals(sameStateAsSunk));
    Assert.assertTrue(sameStateAsSunk.equals(sunk));
    Assert.assertEquals(sunk.equals(sameStateAsSunk)
        && sameStateAsSunk.equals(yetAnotherSunk), yetAnotherSunk.equals(sunk));
    Assert.assertFalse(sunk.equals(nullSunk));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(sunk.equals(sameRefSunk),
        sunk.hashCode() == sameRefSunk.hashCode());
    Assert.assertEquals(sunk.equals(sameStateAsSunk),
        sunk.hashCode() == sameStateAsSunk.hashCode());
  }
}
