package edu.neu.ccs.cs5004.view;

import edu.neu.ccs.cs5004.model.ship.Ship;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewTest {
  private View view;
  private View sameRefView;
  private View sameStateAsView;
  private View yetAnotherView;
  private Ship ship;
  private View nullView = null;


  @Before
  public void setUp() throws Exception {
    view = new View();
    sameRefView = view;
    sameStateAsView = new View();
    yetAnotherView = new View();
    ship = Ship.createDestroyer();
  }



  @Test
  public void testEquals() {
    Assert.assertTrue(view.equals(view));
    Assert.assertTrue(view.equals(sameRefView));
    Assert.assertTrue(view.equals(sameStateAsView));
    Assert.assertTrue(sameStateAsView.equals(view));
    Assert.assertEquals(view.equals(sameStateAsView)
        && sameStateAsView.equals(yetAnotherView), yetAnotherView.equals(view));
    Assert.assertFalse(view.equals(nullView));
    Assert.assertFalse(view.equals(ship));

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(view.equals(sameRefView),
        view.hashCode() == sameRefView.hashCode());
    Assert.assertEquals(view.equals(sameStateAsView),
        view.hashCode() == sameStateAsView.hashCode());

  }
}