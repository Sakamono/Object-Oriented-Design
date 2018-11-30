package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.User;

public class UserTest {
  private User user1;
  private User sameRefUser1;
  private User sameStateAsUser1;
  private User yetAnotherUser1;
  private User user2;
  private User nullUser = null;
  private User user3;
  private User user4;
  private User user5;
  private User user6;


  @Before
  public void setUp() throws Exception {
    user1 = new User(1, "2/3/2000", "M", 33, "Seattle");
    sameRefUser1 = user1;
    sameStateAsUser1 = new User(1, "2/3/2000",
        "M", 33, "Seattle");
    yetAnotherUser1 = new User(1, "2/3/2000",
        "M", 33, "Seattle");
    user2 = new User(2, "1/3/2000", "F", 20, "Tacoma");
    user3 = new User(1, "1/3/2000", "M", 33, "Seattle");
    user4 = new User(1, "2/3/2000", "F", 33, "Seattle");
    user5 = new User(1, "2/3/2000", "M", 10, "Seattle");
    user6 = new User(1, "2/3/2000", "M", 33, "Tacoma");
  }

  @Test
  public void getUserId() {
    Assert.assertEquals(new Integer(1), user1.getUserId());
    Assert.assertEquals(new Integer(2), user2.getUserId());
  }

  @Test
  public void compareTo() {
    Assert.assertEquals(-1, user1.compareTo(user2));
    Assert.assertEquals(1, user2.compareTo(user1));
    Assert.assertEquals(0, user1.compareTo(user1));
  }


  @Test
  public void testEquals() {
    Assert.assertTrue(user1.equals(user1)); // reflexivity
    Assert.assertTrue(user1.equals(sameRefUser1)); // trivial condition both reference the same object
    Assert.assertTrue(user1.equals(sameStateAsUser1)); // both objects should have the same state
    Assert.assertTrue(sameStateAsUser1.equals(user1)); //symmetry
    Assert.assertEquals(user1.equals(sameStateAsUser1), sameStateAsUser1.equals(user1));
    Assert.assertEquals(user1.equals(sameStateAsUser1) && sameStateAsUser1.equals(user1),
        user1.equals(user1)); //transitivity
    Assert.assertFalse(user1.equals(user2)); //objects have different state
    Assert.assertFalse(user1.equals(user3)); //objects have different state
    Assert.assertFalse(user1.equals(user4)); //objects have different state
    Assert.assertFalse(user1.equals(user5)); //objects have different state
    Assert.assertFalse(user1.equals(user6)); //objects have different state
    Assert.assertFalse(user1.equals(new Integer(1))); //objects have different class
    Assert.assertFalse(user1.equals(nullUser)); // user1 is NOT null
  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(user1.equals(sameRefUser1),
        user1.hashCode() == sameRefUser1.hashCode());
    Assert.assertEquals(user1.equals(sameStateAsUser1),
        user1.hashCode() == sameStateAsUser1.hashCode());
  }

  @Test
  public void testToString() {
    String temp = "[User 1, 2/3/2000, M, 33, Seattle]";
    Assert.assertEquals(temp, user1.toString());
  }

}