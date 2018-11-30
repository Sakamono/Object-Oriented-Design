package edu.neu.ccs.cs5004.problem1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an input process system that takes in a CSV file and generate a collection of the
 * items stored in the given file.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class InputProcessSystem {
  /**
   * Create a new map to store all the users in the given file.
   *
   * @param inputFileName the file to read the users from.
   * @return a map which stores all the information of uses in the given file.
   */
  public static Map<Integer, User> process(String inputFileName) {
    Map<Integer, User> res = new HashMap<>();


    try (BufferedReader
             inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(
        inputFileName),
        "UTF-8"))) {
      String line;
      inputFile.readLine(); // to read the header line.

      while ((line = inputFile.readLine()) != null) {
        // split the line with separator "," and store the separated segments into a string array.
        String[] segments = line.split(",");

        // Creates a new user.
        User newUser = new User(Integer.parseInt(segments[0]),
            segments[1],
            segments[2],
            Integer.parseInt(segments[3]),
            segments[4]);

        res.put(newUser.getUserId(), newUser);
      }
    } catch (IOException e) {
      System.out.println("Something went wrong: " + e.getMessage());
      e.printStackTrace();
    }

    return res;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }


  /**
   * Prints the map.
   * @param map the map to be printed.
   */
  public static void printMap(Map<Integer, User> map) {
    System.out.println("The generated map: \n");
    for (Map.Entry<Integer, User> entry : map.entrySet()) {
      System.out.println("User ID: " + entry.getKey() + " -> " + entry.getValue());
    }
  }

//  public static void main(String[] args) {
//    Map<Integer, User> map = new HashMap<Integer, User>();
//
//    map = InputProcessSystem.process("nodes_small.csv");
//
//    InputProcessSystem.printMap(map);
//  }
}