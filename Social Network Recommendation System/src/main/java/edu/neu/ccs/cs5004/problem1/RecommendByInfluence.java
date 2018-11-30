package edu.neu.ccs.cs5004.problem1;


import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Represents a recommendation method "Always follow the influential users".
 *
 * @author Wenbo Wang / Xiaoyu Zhang / Jiahuan Yu
 */
public class RecommendByInfluence implements RecommendationCriteria {
  /**
   * @param influentialMap a influential Map which keeps information of userId
   *                       and number of followers.
   * @param base           when a user's number of followers is greater than base,
   *                       it should be considered as an influential user.
   * @return a priority queue of recommended users.
   */
  public static Queue<Integer> generateRecommendation(Map<Integer, Integer> influentialMap,
                                                      Integer base) {
    Queue<Integer> result = new PriorityQueue<>();
    for (Map.Entry<Integer, Integer> entry : influentialMap.entrySet()) {
      Integer value = entry.getValue();
      if (value > base) {
        result.add(entry.getKey());
      }
    }
    return result;
  }


//  private static void printQueue() {
//    Map<Integer, List<Integer>> graphMap = new HashMap<Integer, List<Integer>>();
//    Map<Integer, Integer> influentialMap = new HashMap<Integer, Integer>();
//
//    UserGraphGenerationSystem.process("edges_small.csv", graphMap, influentialMap);
//    Queue<Integer> queue = RecommendByInfluence.generateRecommendation(influentialMap, 25);
//    int size = queue.size();
//    for (int i = 0; i < size; i++) {
//      if (i == size - 1) {
//        System.out.println(queue.poll());
//      } else {
//        System.out.print(queue.poll() + ", ");
//      }
//    }
//  }
//
//  public static void main(String arg[]) {
//    RecommendByInfluence.printQueue();
//  }
}
