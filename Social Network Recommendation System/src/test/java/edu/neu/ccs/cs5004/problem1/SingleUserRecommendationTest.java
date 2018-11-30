package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class SingleUserRecommendationTest {
  private SingleUserRecommendation single;
  private SingleUserRecommendation sameRefSingle;
  private SingleUserRecommendation sameStateAsSingle;
  private SingleUserRecommendation yetAnotherSingle;
  private SingleUserRecommendation diffSingle;
  private SingleUserRecommendation nullSingle = null;
  private SingleUserRecommendation newSingle;
  private SingleUserRecommendation newDiffSingle;
  private SingleUserRecommendation single1;
  private SingleUserRecommendation single2;
  private Queue<Integer> queue;

  @Before
  public void setUp() throws Exception {
    single = new SingleUserRecommendation(1,5);
    sameRefSingle = single;
    sameStateAsSingle = new SingleUserRecommendation(1,5);
    yetAnotherSingle = new SingleUserRecommendation(1,5);
    diffSingle = new SingleUserRecommendation(3);
    newSingle = new SingleUserRecommendation(1,5);
    newDiffSingle = new SingleUserRecommendation(3);
    single1 = new SingleUserRecommendation(1,6);
    single2 = new SingleUserRecommendation(1);
    queue = new PriorityQueue<>();
    queue.add(10);
    queue.add(23);
    queue.add(34);
    queue.add(36);
    queue.add(46);
  }

  @Test
  public void getResultQueue() {
    newSingle.recommendForUser("edges_small.csv",25,100);
    Assert.assertEquals(queue.poll(),newSingle.getResultQueue().poll());
    Assert.assertEquals(queue.poll(),newSingle.getResultQueue().poll());
    Assert.assertEquals(queue.poll(),newSingle.getResultQueue().poll());
    Assert.assertEquals(queue.poll(),newSingle.getResultQueue().poll());
    Assert.assertEquals(queue.poll(),newSingle.getResultQueue().poll());
    Assert.assertTrue(queue.isEmpty());
    Assert.assertTrue(newSingle.getResultQueue().isEmpty());
  }

  @Test
  public void recommendForUser() {
    newSingle.recommendForUser("edges_small.csv",25,100);
    newDiffSingle.recommendForUser("edges_small.csv",25,100);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(single.equals(single)); // reflexivity
    Assert.assertTrue(single.equals(sameRefSingle)); // trivial condition both reference the same object
    Assert.assertTrue(single.equals(sameStateAsSingle)); // both objects should have the same state
    Assert.assertTrue(sameStateAsSingle.equals(single)); //symmetry
    Assert.assertFalse(single.equals(new Integer(1))); //objects have different class
    Assert.assertFalse(single.equals(nullSingle)); //
    Assert.assertFalse(single.equals(diffSingle)); //objects have different state
    Assert.assertFalse(single.equals(single1)); //objects have different state
    Assert.assertFalse(single.equals(single2)); //objects have different state
    Assert.assertFalse(single.equals(queue)); //objects have different class
    Assert.assertEquals(single.equals(sameStateAsSingle), sameStateAsSingle.equals(single));
    Assert.assertEquals(single.equals(sameStateAsSingle) && sameStateAsSingle.equals(single),
        single.equals(single)); //transitivity

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(single.equals(sameRefSingle),
        single.hashCode() == sameRefSingle.hashCode());
    Assert.assertEquals(single.equals(sameStateAsSingle),
        single.hashCode() == sameStateAsSingle.hashCode());
  }
  @Test
  public void testToString() {
    String res = "SingleUserRecommendation{userId=1, "
        + "resultQueue=[], numberOfRecommendations=5, currentNumberOfRecommendations=0}";
    Assert.assertEquals(res,single.toString());
  }

}