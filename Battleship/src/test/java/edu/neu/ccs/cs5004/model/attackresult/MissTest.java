package edu.neu.ccs.cs5004.model.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class MissTest {
  private Miss miss;
  private Miss sameRefMiss;
  private Miss sameStateAsMiss;
  private Miss yetAnotherMiss;
  private Miss nullMiss = null;

  @Before
  public void setUp() throws Exception {
    miss = new Miss();
    sameRefMiss = miss;
    sameStateAsMiss = new Miss();
    yetAnotherMiss = new Miss();
  }


  @Test
  public void testEquals() {
    Assert.assertTrue(miss.equals(miss));
    Assert.assertTrue(miss.equals(sameRefMiss));
    Assert.assertTrue(miss.equals(sameStateAsMiss));
    Assert.assertTrue(sameStateAsMiss.equals(miss));
    Assert.assertEquals(miss.equals(sameStateAsMiss)
        && sameStateAsMiss.equals(yetAnotherMiss), yetAnotherMiss.equals(miss));
    Assert.assertFalse(miss.equals(nullMiss));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(miss.equals(sameRefMiss),
        miss.hashCode() == sameRefMiss.hashCode());
    Assert.assertEquals(miss.equals(sameStateAsMiss),
        miss.hashCode() == sameStateAsMiss.hashCode());
  }
}