package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OutputRecommendationsTest {

  private OutputRecommendations output;
  @Before
  public void setUp() throws Exception {
    output = new OutputRecommendations("test.csv");
  }

  @Test
  public void testWriteRecommendation() {
//    Integer id = 0;
//    Queue<Integer> queue = new PriorityQueue<>();
//    queue.add(1);
//    queue.add(2);
//    queue.add(3);
//    output.writeRecommendation();
  }

  @Test
  public void testEquals() {
    Assert.assertFalse(output.equals(new OutputRecommendations("test2.csv")));
    Assert.assertTrue(output.equals(new OutputRecommendations("test.csv")));
    Assert.assertTrue(output.equals(output));
    Assert.assertFalse(output.equals(null));
    Assert.assertFalse(output.equals("1234"));
  }

  @Test
  public void testHashCode() {
    Assert.assertNotEquals(output.hashCode(), (new OutputRecommendations("test2.csv").hashCode()));
    Assert.assertEquals(output.hashCode(), (new OutputRecommendations("test.csv").hashCode()));
  }
}