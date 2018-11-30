package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;


public class NodeIteratorTest {

  private NodeIterator iterator;
  private LinkedList<Integer> list;
  private Integer numUsers;

  @Before
  public void setUp() throws Exception {
    list = new LinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    numUsers = 2;
    iterator = new NodeIterator(list, numUsers);
  }
  @Test
  public void testNext() {
    Assert.assertTrue(iterator.hasNext());
    Assert.assertEquals(iterator.next(), new Integer(0));
    Assert.assertTrue(iterator.hasNext());
    Assert.assertEquals(iterator.next(), new Integer(1));
    Assert.assertFalse(iterator.hasNext());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void testRemove() {
    iterator.remove();
  }

  @Test
  public void testEquals() {
    Assert.assertFalse(iterator.equals(new NodeIterator(list, numUsers+1)));
    Assert.assertTrue(iterator.equals(new NodeIterator(list, numUsers)));
    Assert.assertTrue(iterator.equals(iterator));
    Assert.assertFalse(iterator.equals(null));
    Assert.assertFalse(iterator.equals("1234"));
  }

  @Test
  public void testHashCode() {
    Assert.assertNotEquals(iterator.hashCode(), (new NodeIterator(list, numUsers+1)).hashCode());
    Assert.assertEquals(iterator.hashCode(), (new NodeIterator(list, numUsers)).hashCode());
  }
}