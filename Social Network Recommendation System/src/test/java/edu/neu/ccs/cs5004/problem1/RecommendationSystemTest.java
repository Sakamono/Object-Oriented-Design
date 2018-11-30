package edu.neu.ccs.cs5004.problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.neu.ccs.cs5004.problem1.RecommendationSystem;

public class RecommendationSystemTest {

  private RecommendationSystem system;
  private RecommendationSystem sameRefSystem;
  private RecommendationSystem sameStateAsSystem;
  private RecommendationSystem yetAnotherSystem;
  private RecommendationSystem nullSystem = null;
  private RecommendationSystem system2;
  private RecommendationSystem system3;
  private RecommendationSystem system4;
  private RecommendationSystem system5;



  @Before
  public void setUp() throws Exception {
    String[] args = {"nodes_small.csv", "edges_small.csv", "output.csv"};
    String[] argsNew = {"nodes_small.csv", "edges_small.csv", "output.csv", "-f", "r"};
    String[] args6 = {"nodes_small.csv", "edges_small.csv", "output.csv", "-f", "e"};
    String[] args7 = {"nodes_small.csv", "edges_small.csv", "output.csv", "-f", "s","-u", "30", "-r","20"};
    String[] args8 = {"nodes_small.csv", "edges_small.csv", "output.csv", "-f", "s","-u", "50", "-r", "30"};
    system = new RecommendationSystem(args);
    sameRefSystem = system;
    sameStateAsSystem = new RecommendationSystem(args);
    yetAnotherSystem = new RecommendationSystem(args);
    system2 = new RecommendationSystem(argsNew);
    system3 = new RecommendationSystem(args6);
    system4 = new RecommendationSystem(args7);
    system5 = new RecommendationSystem(args8);
  }

  @Test
  public void makeRecommendation() {
    system.makeRecommendation();
    String[] test = {"nodes_small.csv", "edges_small.csv"};
    RecommendationSystem wrong = new RecommendationSystem(test);
    wrong.makeRecommendation();
  }


  @Test
  public void main() {
    String[] args1 = {"nodes_small.csv", "edges_small.csv", "output.csv"};
    String[] args2 = {"nodes_small.csv", "edges_small.csv", "output2.csv", "s", "40", "20"};
    String[] args3 = {"nodes_small.csv", "edges_small.csv", "output3.csv", "e"};
    String[] args4 = {"nodes_small.csv", "edges_small.csv", "output4.csv", "r", "50"};
    String[] args5 = {"nodes_small.csv", "edges_small.csv", "output5.csv", "50"};
    String[] args9 = {"nodes_10000.csv", "edges_10000.csv", "output9.csv", "50"};
    RecommendationSystem.main(args1);
    RecommendationSystem.main(args2);
    RecommendationSystem.main(args3);
    RecommendationSystem.main(args4);
    RecommendationSystem.main(args5);
    RecommendationSystem.main(args9);
  }

  @Test
  public void testShowUsage() {
    this.system.showUsage();
  }

  @Test
  public void testEquals() {
    Assert.assertTrue(system.equals(system)); // reflexivity
    Assert.assertTrue(system.equals(sameRefSystem)); // trivial condition both reference the same object
    Assert.assertTrue(system.equals(sameStateAsSystem)); // both objects should have the same state
    Assert.assertTrue(sameStateAsSystem.equals(system)); //symmetry
    Assert.assertEquals(system.equals(sameStateAsSystem), sameStateAsSystem.equals(system));
    Assert.assertEquals(system.equals(sameStateAsSystem) && sameStateAsSystem.equals(system),
        system.equals(system)); //transitivity
    Assert.assertFalse(system.equals(new Integer(1))); //objects have different class
    Assert.assertFalse(system.equals(nullSystem)); // system is NOT null
    Assert.assertFalse(system.equals(system2)); //objects have different state
    Assert.assertFalse(system2.equals(system3)); //objects have different state
    Assert.assertFalse(system2.equals(system4)); //objects have different state
    Assert.assertFalse(system2.equals(system5)); //objects have different state

  }

  @Test
  public void testHashCode() {
    Assert.assertEquals(system.equals(sameRefSystem),
        system.hashCode() == sameRefSystem.hashCode());
    Assert.assertEquals(system.equals(sameStateAsSystem),
        system.hashCode() == sameStateAsSystem.hashCode());
  }
}