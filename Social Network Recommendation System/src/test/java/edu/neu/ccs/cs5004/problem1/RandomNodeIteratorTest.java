package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;


public class RandomNodeIteratorTest {

  private RandomNodeIterator iter;
  private LinkedList<Integer> list;
  private Integer numUsers;

  @Before
  public void setUp() throws Exception {
    list = new LinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    numUsers = 2;
    iter = new RandomNodeIterator(list, numUsers);
  }
  @Test
  public void testNext() {
    Assert.assertTrue(iter.hasNext());
    Integer val1 = iter.next();
    Assert.assertTrue(val1 >=0 && val1 <=2);
    Assert.assertTrue(iter.hasNext());
    Integer val2 = iter.next();
    Assert.assertTrue(val1 >=0 && val1 <=2 && val1 != val2);
    Assert.assertFalse(iter.hasNext());
  }

  @Test
  public void testEquals() {
    Assert.assertFalse(iter.equals(new RandomNodeIterator(list, numUsers+1)));
    Assert.assertTrue(iter.equals(new RandomNodeIterator(list, numUsers)));
    Assert.assertTrue(iter.equals(iter));
    Assert.assertFalse(iter.equals(null));
    Assert.assertFalse(iter.equals("1234"));
  }

  @Test
  public void testHashCode() {
    Assert.assertNotEquals(iter.hashCode(), (new RandomNodeIterator(list, numUsers+1)).hashCode());
    Assert.assertEquals(iter.hashCode(), (new RandomNodeIterator(list, numUsers)).hashCode());
  }
}