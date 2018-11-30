package edu.neu.ccs.cs5004.model.attackresult;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HitTest {
  private Hit hit;
  private Hit sameRefHit;
  private Hit sameStateAsHit;
  private Hit yetAnotherHit;
  private Hit nullHit = null;


  @Before
  public void setUp() throws Exception {
    hit = new Hit();
    sameRefHit = hit;
    sameStateAsHit = new Hit();
    yetAnotherHit = new Hit();
  }


  @Test
  public void testEquals() {
    Assert.assertTrue(hit.equals(hit));
    Assert.assertTrue(hit.equals(sameRefHit));
    Assert.assertTrue(hit.equals(sameStateAsHit));
    Assert.assertTrue(sameStateAsHit.equals(hit));
    Assert.assertEquals(hit.equals(sameStateAsHit)
        && sameStateAsHit.equals(yetAnotherHit), yetAnotherHit.equals(hit));
    Assert.assertFalse(hit.equals(nullHit));
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(hit.equals(sameRefHit),
        hit.hashCode() == sameRefHit.hashCode());
    Assert.assertEquals(hit.equals(sameStateAsHit),
        hit.hashCode() == sameStateAsHit.hashCode());
  }

}