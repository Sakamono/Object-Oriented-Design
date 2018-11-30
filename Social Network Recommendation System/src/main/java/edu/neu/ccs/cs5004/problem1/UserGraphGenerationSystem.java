package edu.neu.ccs.cs5004.problem1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Represents a user graph generation system that takes in a collection of users and their
 * friendship relationships between any two users to generate a graph of user friendship relations
 * and a collection of most influential users.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class UserGraphGenerationSystem {

  /**
   * Given an input csv file and a map of user friendship relations map and a most influential
   * users map to process and fill two given maps, which record all the followers of a certain
   * user, and a collections of most influential users.
   *
   * @param inputFileName  the name of the input csv file.
   * @param graphMap       an empty graph map.
   * @param influentialMap an empty influential map.
   */
  public static void process(String inputFileName, Map<Integer,
      List<Integer>> graphMap, Map<Integer, Integer> influentialMap) {

    try (BufferedReader
             inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(
        inputFileName), "UTF-8"))) {
      String line;

      // read the first line as header.
      inputFile.readLine();

      while ((line = inputFile.readLine()) != null) {
        String[] segments = line.split(",");

        Integer follower = Integer.parseInt(segments[0]);
        Integer followed = Integer.parseInt(segments[1]);
        List<Integer> temp = graphMap.getOrDefault(follower, new LinkedList<Integer>());
        temp.add(followed);
        graphMap.put(follower, temp);
        influentialMap.put(followed,
            influentialMap.getOrDefault(followed, 0) + 1);
      }
    } catch (IOException e) {
      System.out.println("Something went wrong: " + e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Prints a graph map.
   *
   * @param map the graph map to be printed.
   */
  public static void printGraphMap(Map<Integer, List<Integer>> map) {
    System.out.println("The follower graph is as follows: \n\n");

    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      System.out.print("User ID: " + entry.getKey() + " follows [");
      List<Integer> temp = entry.getValue();
      for (int i = 0; i < temp.size(); i++) {
        if (i == temp.size() - 1) {
          System.out.println(temp.get(i) + "]");
        } else {
          System.out.print(temp.get(i) + ", ");
        }
      }
    }
  }

  /**
   * Prints an influential map.
   * @param map the influential map to be printed.
   */
  public static void printInfluentialMap(Map<Integer, Integer> map) {
    System.out.println("The most influential users are: \n\n");

    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.println("User ID: " + entry.getKey() + ", has "
          + entry.getValue() + " followers.");
    }
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }


//
//  public static void main(String[] args) {
//    Map<Integer, List<Integer>> graphMap = new HashMap<Integer, List<Integer>>();
//    Map<Integer, Integer> influentialMap = new HashMap<Integer, Integer>();
//
//    UserGraphGenerationSystem.process("edges_small.csv", graphMap, influentialMap);
//
//    UserGraphGenerationSystem.printGraphMap(graphMap);
//    UserGraphGenerationSystem.printInfluentialMap(influentialMap);
//  }
}