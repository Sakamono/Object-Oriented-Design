package edu.neu.ccs.cs5004.problem1;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * Represents a recommendation method "When in doubt, branch out", which means pick the
 * recommended randomly.
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class RecommendRandomUser implements RecommendationCriteria {
  /**
   * Generates a queue of random users.
   *
   * @param queue                   the queue of recommended users after generating users after
   *                                criteria one and two.
   * @param numberOfRecommendations number of recommendations to generate randomly.
   * @param maxId                   the maximum user ID to choose within.
   * @return a queue of recommended users.
   */
  public static Queue<Integer> generateRecommendations(Queue<Integer> queue,
                                                       Integer numberOfRecommendations,
                                                       Integer maxId) {
    Queue<Integer> res = new PriorityQueue<Integer>();

    Random randomGenerator = new Random();
    Integer userId;
    while (res.size() < numberOfRecommendations) {
      userId = randomGenerator.nextInt(maxId + 1);
      if (!queue.contains(userId) && !res.contains(userId)) {
        res.add(userId);
      }
    }
    return res;
  }



//  private static void printQueue() {
//    Map<Integer, List<Integer>> graphMap = new HashMap<Integer, List<Integer>>();
//    Map<Integer, Integer> influentialMap = new HashMap<Integer, Integer>();
//
//    UserGraphGenerationSystem.process("edges_small.csv", graphMap, influentialMap);
//    Queue<Integer> queue = RecommendByInfluence.generateRecommendation(influentialMap, 25);
//    Queue<Integer> queueRandom = RecommendRandomUser.generateRecommendations(queue,25,100);
//    int size = queueRandom.size();
//    System.out.println(queue.size());
//    System.out.println(queueRandom.size());
//    for (int i = 0; i < size; i++) {
//      if (i == size - 1) {
//        System.out.println(queueRandom.poll() + "]");
//      } else {
//        System.out.print(queueRandom.poll() + ", ");
//      }
//    }
//  }
//
//  public static void main(String arg[]) {
//    RecommendRandomUser.printQueue();
//  }
}