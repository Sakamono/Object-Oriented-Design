package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InputProcessSystemTest {
  private Map<Integer, User> map;
  private InputProcessSystem system;
  private InputProcessSystem system1;

  @Before
  public void setUp() throws Exception {
    map = new HashMap<>();
    system = new InputProcessSystem();
    system1 = system;
  }

  @Test
  public void process() {
    map = InputProcessSystem.process("nodes_small.csv");
  }


  @Test
  public void printMap() {
    map = InputProcessSystem.process("nodes_small.csv");
    InputProcessSystem.printMap(map);
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(system.equals(system));
    Assert.assertTrue(system.equals(system1));
    Assert.assertFalse(system.equals(map));
  }
  @Test
  public void testHashCode() {
    Assert.assertEquals(system.equals(system1),
        system.hashCode() == system1.hashCode());
  }



}