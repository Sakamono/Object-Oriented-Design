package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class ReverseNodeIteratorTest {
  private ReverseNodeIterator iterator;
  private LinkedList<Integer> list;
  private Integer numUsers;

  @Before
  public void setUp() throws Exception {
    list = new LinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    numUsers = 2;
    iterator = new ReverseNodeIterator(list, numUsers);
  }
  @Test
  public void testNext() {
    Assert.assertTrue(iterator.hasNext());
    Assert.assertEquals(iterator.next(), new Integer(2));
    Assert.assertTrue(iterator.hasNext());
    Assert.assertEquals(iterator.next(), new Integer(1));
    Assert.assertFalse(iterator.hasNext());
  }

  @Test
  public void testEquals() {
    Assert.assertFalse(iterator.equals(new ReverseNodeIterator(list, numUsers+1)));
    Assert.assertTrue(iterator.equals(new ReverseNodeIterator(list, numUsers)));
    Assert.assertTrue(iterator.equals(iterator));
    Assert.assertFalse(iterator.equals(null));
    Assert.assertFalse(iterator.equals("1234"));
  }

  @Test
  public void testHashCode() {
    Assert.assertNotEquals(iterator.hashCode(), (new ReverseNodeIterator(list, numUsers+1)).hashCode());
    Assert.assertEquals(iterator.hashCode(), (new ReverseNodeIterator(list, numUsers)).hashCode());
  }
}