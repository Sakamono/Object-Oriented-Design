package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserGraphGenerationSystemTest {
  Map<Integer, List<Integer>> graphMap;
  Map<Integer, Integer> influentialMap;
  UserGraphGenerationSystem system;
  UserGraphGenerationSystem system1;

  @Before
  public void setUp() throws Exception {
    graphMap= new HashMap<>();
    influentialMap= new HashMap<>();
    system = new UserGraphGenerationSystem();
    system1 = system;
  }

  @Test
  public void process() {
    UserGraphGenerationSystem.process("edges_small.csv", graphMap, influentialMap);
  }

  @Test
  public void printGraphMap() {
    UserGraphGenerationSystem.process("edges_small.csv", graphMap, influentialMap);
    UserGraphGenerationSystem.printGraphMap(graphMap);
    System.out.println();
    System.out.println();
  }

  @Test
  public void printInfluentialMap() {
    UserGraphGenerationSystem.process("edges_small.csv", graphMap, influentialMap);
    UserGraphGenerationSystem.printInfluentialMap(influentialMap);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(system.equals(system));
    Assert.assertTrue(system.equals(system1));
    Assert.assertFalse(system.equals(graphMap));
  }
  @Test
  public void testHashCode() {
    Assert.assertEquals(system.equals(system1),
        system.hashCode() == system1.hashCode());
  }

}